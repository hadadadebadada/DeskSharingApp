import React from 'react'

function ShowBlockedBookings(props) {



    const [blockedBookings, setBlockedBookings] = React.useState([]);


    function getProps() {
        let id = props.value;
        return id;
    }



    const urlWP = `http://131.173.88.173:443/api/v1/booking/e1/getBlockedBookingsByOffice/${getProps()}`;
    const token = localStorage.getItem('token')

    React.useEffect(() => {
        fetch(urlWP, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`

            }

        })
            .then(res => res.json())
            .then(blockedBookings => setBlockedBookings(blockedBookings))
            .catch(err => console.log(err.message));
    }, []);







    return (
        <div>

            <h2 style={{ color: "white" }} className="text-center">Geblockte Arbeitsplätze</h2>


            <div style={{ width: 100 }} className="row">

            </div>

            <div style={{
                resize: 'both',
                overflow: 'auto',
                justifyContent: 'center',
                alignItems: 'center',

            }} className="row">
                <table style={{ width: 100 }} className="table table-striped table-bordered">

                    <thead>
                        <tr>

                            <th style={{ color: "white" }}>Startzeit</th>
                            <th style={{ color: "white" }}>Endzeit</th>
                            <th style={{ color: "white" }}>Arbeitsplatz</th>

                        </tr>

                    </thead>

                    <tbody>

                        {blockedBookings.map(
                            e =>
                                <tr key={e.id}>



                                    <td style={{ color: "white" }}>{e.timestart.substr(0, 10)} {e.timestart.charAt(11) + e.timestart.charAt(12) + e.timestart.charAt(13) + e.timestart.charAt(14) + e.timestart.charAt(15)}</td>
                                    <td style={{ color: "white" }}>{e.timeend.substr(0, 10)} {e.timeend.charAt(11) + e.timeend.charAt(12) + e.timeend.charAt(13) + e.timeend.charAt(14) + e.timeend.charAt(15)}</td>
                                    <td style={{ color: "white" }}>{e.workplace.id}</td>





                                </tr>
                        )}

                    </tbody>


                </table>



            </div>



        </div>
    )
}
export default ShowBlockedBookings