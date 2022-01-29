package com.example.demo.booking;

import com.example.demo.building.workplace.Workplace;
import com.example.demo.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
//Name der DB-Tabelle
@Table(name = "t_booking")
public class Booking {

    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_sequence"
    )
    @Id
    //Variablen
    private Long id;

    private Date timestart;
    private Date timeend;
    private String status;
    private String username;
    //Datenbankbeziehungen (FKeys)
    @ManyToOne( )
    @JoinColumn(name="employeeid", nullable=true)
    private Employee employee=null;

    @ManyToOne()
    @JoinColumn(name="workplaceid", nullable=true)
    private Workplace workplace=null;

    //Constructor
    public Booking(Long id, Date timestart, Date timeend, String status) {

    }
    //Getter Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestart() {
        return timestart;
    }

    public void setTimestart(Date timestart) {
        this.timestart = timestart;
    }

    public Date getTimeend() {
        return timeend;
    }

    public void setTimeend(Date timeend) {
        this.timeend = timeend;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(timestart, booking.timestart) && Objects.equals(timeend, booking.timeend) && Objects.equals(status, booking.status) && Objects.equals(employee, booking.employee) && Objects.equals(workplace, booking.workplace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestart, timeend, status, employee, workplace);
    }
}
