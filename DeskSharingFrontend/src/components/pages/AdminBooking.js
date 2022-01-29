import React from 'react'

import ApiService from '../../APIService';




function AdminBooking() {


    const [bookingRequest, setBookingRequest] = React.useState([]);




    React.useEffect(() => {

        ApiService.getAllRequest().then(bookingRequest => setBookingRequest(bookingRequest));
    }, []);


    function declineBooking(id) {
        ApiService.leaveWorkspace(id);

    }

    function acceptBooking(id) {
        ApiService.acceptBooking(id);
    }






    return (
        <div>

            <h2 style={{ color: "white" }} className="text-center">Buchungsanfragen Liste</h2>
            <div className="row">

            </div>

            <div style={{ backgroundColor: "#101522" }} className="row">
                <table className="table table-striped table-bordered">

                    <thead>
                        <tr>
                            <th style={{ color: "white" }}>Name</th>

                            <th style={{ color: "white" }}>Startzeit</th>
                            <th style={{ color: "white" }}>Endzeit</th>
                            <th style={{ color: "white" }}>Status</th>
                            <th style={{ color: "white" }}>Arbeitsplatz</th>


                            <th style={{ color: "white" }}>Actions</th>

                        </tr>

                    </thead>

                    <tbody>
                        {console.log(bookingRequest)}
                        {bookingRequest.map(
                            e =>
                                <tr key={e.id}>



                                    <td style={{ color: "white" }}>{e.employee.firstname}</td>


                                    <td style={{ color: "white" }}>{e.timestart.substr(0, 10)} {e.timestart.charAt(11) + e.timestart.charAt(12) + e.timestart.charAt(13) + e.timestart.charAt(14) + e.timestart.charAt(15)}</td>
                                    <td style={{ color: "white" }}>{e.timeend.substr(0, 10)} {e.timeend.charAt(11) + e.timeend.charAt(12) + e.timeend.charAt(13) + e.timeend.charAt(14) + e.timeend.charAt(15)}</td>
                                    <td style={{ color: "white" }}>{e.status}</td>
                                    <td style={{ color: "white" }}>{e.workplace.id} {e.workplace.office.description}</td>




                                    <td>
                                        <button onClick={() => acceptBooking(e.id)} className="btn btn-info">Akzeptieren </button>

                                        <button style={{ marginLeft: "10px" }} onClick={() => declineBooking(e.id)} className="btn btn-danger">Ablehnen </button>

                                    </td>


                                </tr>
                        )}

                    </tbody>


                </table>



            </div>



        </div>
    )
}
export default AdminBooking