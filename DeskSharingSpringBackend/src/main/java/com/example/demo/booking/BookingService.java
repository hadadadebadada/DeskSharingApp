package com.example.demo.booking;

import com.example.demo.building.workplace.Workplace;
import com.example.demo.building.workplace.WorkplaceRepository;
import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service("api/v1/booking")
@CrossOrigin(origins = "*", maxAge = 3600)

public class BookingService {

    @Autowired // new
    private final BookingRepository bookingRepository;
    private final WorkplaceRepository workplaceRepository;
    private final EmployeeRepository employeeRepository;



    @GetMapping
    public List<Booking> getAllBookings(){
        List <Booking> bookings  = bookingRepository.findAll();
        Date currentDate= new Date();
        for(Booking currentBooking:bookings){
            if (currentDate.after(currentBooking.getTimeend())){
                currentBooking.setStatus("beendet");
            }
        }
        return bookings;
    }

//    @PostMapping
//    public Booking saveBooking(Booking booking){ //funktioniert auch als list
//        return bookingRepository.save(booking);
//    }

//    @GetMapping
//    public Booking getBooking(long id){
//
//        return bookingRepository.findById(id).orElse(null);
//    }

//    @GetMapping
//    public List <Booking> getBookingByStatus(String status){
//        return bookingRepository.findByStatus(status);
//    }

//    @GetMapping
//    public  Workplace getWorkplaceByBookingID (long id){
//        Booking booking1  = bookingRepository.findById(id).orElse(null);
//        return booking1.getWorkplace();
//    }

    @GetMapping
    public List<Booking> getBookingByUsername(String username) {
        Employee employee = employeeRepository.findByUsername(username);
        List<Booking> bookings =bookingRepository.findByEmployee(employee);
        Date currentDate= new Date();

        for (Booking currentBooking:bookings) {
            if (currentDate.after(currentBooking.getTimeend())){
                currentBooking.setStatus("beendet");
                bookingRepository.save(currentBooking);
            }
        }
        return bookings;
    }

//    public List<Booking> getBookingByEmployee(long id) {
//        Employee employee = employeeRepository.findById(id).orElse(null);
//        return bookingRepository.findByEmployee(employee);
//    }

    // Holt alle Telefonnummern der Mitarbeiter. Achtet dabei darauf welcher gerade im Homeoffice ist oder welcher Platz reserviert ist
    @GetMapping
    public  List <Employee> getAllPhoneNumbersofEmployees (){

        Date currentDate= new Date();
        List <Employee> employeesInOffice= new ArrayList<>();
        List <Employee> employeesHome = new ArrayList<>();
        List <Employee> employeesAll = employeeRepository.findAll();
        List <Booking> bookings  = bookingRepository.findAll();

        for (Employee employee: employeesAll) {
            employee.setCurrentphonenumber(employee.getPhonenumber());
            employeeRepository.save(employee);
        }
        for (Booking currentBooking:bookings) {
            System.out.println(currentBooking);
            if (currentBooking.getStatus().equals("akzeptiert")) {

                if ((currentDate.before(currentBooking.getTimestart()) || currentDate.after(currentBooking.getTimeend()))) {
                    Employee employeetmp = currentBooking.getEmployee();
                    if(!(employeesInOffice.contains(employeetmp))) {
                        employeetmp.setCurrentphonenumber(currentBooking.getWorkplace().getPhone());
                        employeeRepository.save(employeetmp);
                        employeesInOffice.add(employeetmp);
                    }
                } else {
                    Employee employeetmp = currentBooking.getEmployee();
                    try {
                        employeetmp.setCurrentphonenumber(employeetmp.getPhonenumber());
                        employeeRepository.save(employeetmp);
                        employeesHome.add(employeetmp);
                    } catch (NullPointerException ioe) {

                    }
                }
            }
            else {
                Employee employeetmp = currentBooking.getEmployee();
                try {
                    employeetmp.setCurrentphonenumber(employeetmp.getPhonenumber());
                    employeeRepository.save(employeetmp);
                    //employeesHome.add(employeetmp);
                } catch (NullPointerException ioe) {

                }
            }
        }
        employeesInOffice.addAll(employeesHome);
        for (Employee employeeCurrent:employeesAll){
            if(employeesInOffice.contains(employeeCurrent)){
            }else{
                employeesInOffice.add(employeeCurrent);
            }
        }

        return employeesInOffice;
    }

    //Holt alle besetzten Arbeitsplätze die zum Moment der Abfrage besetzt sind
    @GetMapping
    public  List <Workplace> getCurrentTakenWorkplaces (){

        Date currentDate= new Date();
        List <Workplace> workplacesBooked= new ArrayList<>();
        List <Booking> bookings  = bookingRepository.findAll();

        for (int i = 0; i<bookings.size(); i++) {
            //System.out.println(i);
            Booking currentBooking = bookings.get(i);
            System.out.println(currentDate);
            System.out.println(currentBooking.getTimestart());
            System.out.println(currentBooking.getTimeend());
                if (!(currentDate.before(currentBooking.getTimestart()) || currentDate.after(currentBooking.getTimeend()))){
                    System.out.println("Endzeit nach Jetztzeit");
                    workplacesBooked.add(currentBooking.getWorkplace());
                }
        }
        return workplacesBooked;
    }

    // Holt alle Buchungen die derzeit laufen
    @GetMapping
    public List<Booking> getBlockedBookingsByOffice(long id){
        List <Booking> blockedBookings= new ArrayList<>();
        List <Booking> bookings  = bookingRepository.findAll();
        Date currentDate= new Date();

        for (Booking currentBooking:bookings) {
            if(currentBooking.getStatus().equals("akzeptiert") && (currentDate.before(currentBooking.getTimestart()) || currentDate.after(currentBooking.getTimeend()))){
                if (currentBooking.getWorkplace().getOffice().getId().equals(id)) {
                    blockedBookings.add(currentBooking);
                } else {
                    System.out.println("Arbeitsplatz nicht im Office: " + id);
                }
            }
            if(currentBooking.getStatus().equals("akzeptiert") && (currentDate.after(currentBooking.getTimeend()))){
                currentBooking.setStatus("beendet");
                bookingRepository.save(currentBooking);
            }
        }
            return blockedBookings;
    }

    // Holt alle besetzten Arbeitsplaetze eines Bueros
    @GetMapping
    public  List <Workplace> getCurrentTakenWorkplacesByOffice (long id){
        Date currentDate= new Date();
        List <Workplace> workplacesBooked= new ArrayList<>();
        List <Booking> bookings  = bookingRepository.findAll();

        for (int i = 0; i<bookings.size(); i++) {
            //System.out.println(i);
            Booking currentBooking = bookings.get(i);
            System.out.println(currentDate);
            System.out.println(currentBooking.getTimestart());
            System.out.println(currentBooking.getTimeend());
            System.out.println("TEST1");

            if (currentBooking.getStatus().equals("akzeptiert")) {
                System.out.println("TEST2");
                if ((currentDate.before(currentBooking.getTimestart()) || currentDate.after(currentBooking.getTimeend()))) {
                    System.out.println("Endzeit nach Jetztzeit");
                    System.out.print("ID IST: ");
                    System.out.println(id);
                    if (currentBooking.getWorkplace().getOffice().getId().equals(id)) {
                        workplacesBooked.add(currentBooking.getWorkplace());
                    } else {
                        System.out.println("Arbeitsplatz nicht im Office: " + id);
                    }
                }
            }
        }
        return workplacesBooked;
    }

    public String deleteEmployee(long id){
        bookingRepository.deleteById(id);
        return "booking deleted";
    }

//    @PutMapping
//    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
//    public Booking updateBooking(Booking booking){
//        Booking booking1  = bookingRepository.findById(booking.getId()).orElse(null);
//        booking1.setTimeend(booking.getTimeend());
//        booking1.setStatus(booking.getStatus());
//        booking1.setTimestart(booking.getTimestart());
//        return bookingRepository.save(booking1);
//    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking updateBookingbyIDSetStatusAkzeptiert(Long id){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        booking1.setStatus("akzeptiert");
        Employee employee=booking1.getEmployee();
        Mail mail = new Mail ();
        mail.setpName(employee.getFirstname()+" "+employee.getLastname());
        mail.setpStatus("akzeptiert");
        mail.setpMailAdresse(employee.getEmail());
        mail.sendMail();
        return bookingRepository.save(booking1);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    public Booking updateBookingbyIDSetStatusAbgelehnt(Long id){
        Booking booking1  = bookingRepository.findById(id).orElse(null);
        Date currentDate= new Date();
        booking1.setStatus("abgelehnt");
        Employee employee=booking1.getEmployee();
        Mail mail = new Mail ();
        mail.setpName(employee.getFirstname()+" "+employee.getLastname());
        if(currentDate.after(booking1.getTimeend())){
            booking1.setStatus("beendet");
            return bookingRepository.save(booking1);
        }
        mail.setpStatus("abgelehnt");
        mail.setpMailAdresse(employee.getEmail());
        mail.sendMail();
        return bookingRepository.save(booking1);
    }

//    @PutMapping
//    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
//    public Booking updateBookingbyIDSetStatusSchwebend(Long id){
//        Booking booking1  = bookingRepository.findById(id).orElse(null);
//        booking1.setStatus("schwebend");
//        Employee employee=booking1.getEmployee();
//        Mail mail = new Mail ();
//        mail.setpName(employee.getFirstname()+" "+employee.getLastname());
//        mail.setpStatus("schwebend");
//        mail.setText(booking1.getWorkplace().getId().toString());
//        mail.setpMailAdresse(employee.getEmail());
//        mail.sendMail();
//        return bookingRepository.save(booking1);
//    }

//    @PutMapping
//    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
//    public Booking addWorkplace(Long id, long wid){
//        Booking booking1  = bookingRepository.findById(id).orElse(null);
//        booking1.setWorkplace(workplaceRepository.findById(wid).orElse(null));
//        return bookingRepository.save(booking1);
//    }

//    @PutMapping
//    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
//    public Booking addEmployee(Long id, long wid){
//        Booking booking1  = bookingRepository.findById(id).orElse(null);
//        booking1.setEmployee(employeeRepository.findById(wid).orElse(null));
//        return bookingRepository.save(booking1);
//    }

//    public Booking saveBookingwithids(Booking booking, String username, Long workplaceid) {
//        Booking bookingtmp = booking;
//        bookingtmp.setUsername(username);
//        bookingtmp.setEmployee(employeeRepository.findByUsername(username));
//        bookingtmp.setWorkplace(workplaceRepository.findById(workplaceid).orElse(null));
//        Date currentDate= new Date();
//        if (bookingtmp.getTimeend().before(bookingtmp.getTimestart())){
//            System.err.println("Startzeit vor Endzeit");
//            return null;
//        }
//        if (bookingtmp.getTimeend().before(currentDate)&&bookingtmp.getTimestart().before(currentDate)){
//            System.err.println("Zeit liegt in der Vergangenheit");
//            return null;
//        }
//        List <Booking> bookinstemp = bookingRepository.findByWorkplace(bookingtmp.getWorkplace());
//
//        for (Booking currentBooking:bookinstemp) {
//            boolean ueberschneidung = bookingtmp.getTimeend().compareTo(currentBooking.getTimestart()) < 0
//                    || currentBooking.getTimeend().compareTo(bookingtmp.getTimeend()) < 0;
//            if (ueberschneidung == false){
//                System.err.println("Zeit weißt Ueberschneidungen auf");
//                return null;
//            }
//        }
//
//        return bookingRepository.save(bookingtmp);
//    }

    @PutMapping
    public Booking leaveWorkspace(Long emid){
        Employee employee = employeeRepository.findById(emid).orElse(null);
        List <Booking> bookings = bookingRepository.findByEmployee(employee);
        Date currentDate= new Date();
        for (Booking currentBooking:bookings) {
            if (!(currentDate.before(currentBooking.getTimestart()) || currentDate.after(currentBooking.getTimeend()))){
                System.out.println(currentDate.before(currentBooking.getTimestart()));
                System.out.println(currentDate.before(currentBooking.getTimeend()));
                System.out.println(currentDate);
                currentBooking.setTimeend(currentDate);
                currentBooking.setStatus("beendet");
                bookingRepository.save(currentBooking);
                return currentBooking;
            }
        }
        return null;
    }

    public Booking saveBookingwithids(Booking booking) {
       // Booking bookingtmp = booking;
        Date currentDate= new Date();
        if (booking.getTimeend().before(booking.getTimestart())){
            System.err.println("Startzeit vor Endzeit");
            return null;
        }
        if (booking.getTimeend().before(currentDate)&&booking.getTimestart().before(currentDate)){
            System.err.println("Zeit liegt in der Vergangenheit");
            return null;
        }
        List <Booking> bookinstemp = bookingRepository.findByWorkplace(booking.getWorkplace());

        for (Booking currentBooking:bookinstemp) {
//            Booking currentBooking= bookinstemp.get(i);
            boolean ueberschneidung = booking.getTimeend().compareTo(currentBooking.getTimestart()) < 0
                    || currentBooking.getTimeend().compareTo(booking.getTimeend()) < 0;
            if (ueberschneidung == false){
                System.err.println("Zeit weißt Ueberschneidungen auf");
                return null;
            }
        }
        return bookingRepository.save(booking);
    }
}
