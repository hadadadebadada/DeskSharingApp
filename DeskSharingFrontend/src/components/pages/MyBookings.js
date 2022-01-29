import React from 'react'
import ApiService from '../../APIService';
import ParticleTest from '../particleAnimation/ParticleTest';
function MyBookings() {



    const [myBookings, setMyBookings] = React.useState([]);


    React.useEffect(() => {

        ApiService.getBookingsByUsername()
            .then(res => res.json())

            .then(myBookings => setMyBookings(myBookings))
            .catch(err => console.log(err.message));
    }, []);


    function declineBooking(id) {
        ApiService.declineBooking(id);
    }


    return (
        <div>

            <h2 style={{ color: "white" }} className="text-center">Meine Buchungen</h2>
            <div className="row">

            </div>

            <div style={{ backgroundColor: "#101522" }} className="row">
                <table className="table table-striped table-bordered">

                    <thead>
                        <tr>
                            {/*     <th style={{ color: "white" }}>ID</th>
                            <th style={{ color: "white" }}>Name</th> */}
                            <th style={{ color: "white" }}>Startzeit</th>
                            <th style={{ color: "white" }}>Endzeit</th>
                            <th style={{ color: "white" }}>Status</th>

                        </tr>

                    </thead>

                    <tbody>
                        {myBookings.map(
                            e =>
                                <tr key={e.id}>
                                    {/*    <td style={{ color: "white" }}>{e.id}</td>
                                    <td style={{ color: "white" }}>{e.employee.firstname}</td> */}
                                    <td style={{ color: "white" }}>{e.timestart.substr(0, 10)} {e.timestart.charAt(11) + e.timestart.charAt(12) + e.timestart.charAt(13) + e.timestart.charAt(14) + e.timestart.charAt(15)}</td>
                                    <td style={{ color: "white" }}>{e.timeend.substr(0, 10)} {e.timeend.charAt(11) + e.timeend.charAt(12) + e.timeend.charAt(13) + e.timeend.charAt(14) + e.timeend.charAt(15)}</td>
                                    {/*                                     <td style={{ color: "white" }}>{e.status}</td>
 */}
                                    <td>



                                        {e.status == "akzeptiert" ? <button style={{ marginLeft: "10px" }} onClick={() => declineBooking(e.id)} className="btn btn-danger">Auschecken </button> :
                                            <p style={{ color: 'white' }}>{e.status}</p>}

                                    </td>


                                </tr>
                        )}



                    </tbody>


                </table>





            </div>




        </div>
    )
}
export default MyBookings