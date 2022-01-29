import React from 'react'
import ApiService from '../../APIService';



function EmployeeList() {



    const [employees, setEmployees] = React.useState([]);

    const [name, setName] = React.useState(" ");

    React.useEffect(() => {

        ApiService.getAllEmployees().then(employees => setEmployees(employees));
    }, []);




    const getEmployeeByUsername = event => {
        setName(event.target.value);
    };

    const printUsername = () => {


        let user = localStorage.getItem("username")

        if (user !== 'admin') {
            ApiService.getEmployeeByUsername(name)
                .then(res => res.json())
                .then(res => setName(res))
                .catch(err => console.log(err.message));

        } else {
            ApiService.getEmployeeByUsernameAdmin(name)
                .then(res => res.json())
                .then(res => setName(res))
                .catch(err => console.log(err.message));

        }


    };


    return (
        <div style={{ backgroundColor: "#101522" }}>



            <input onChange={getEmployeeByUsername} placeholder="Usernamen eingeben!" />      <button onClick={printUsername}>Mitarbeiter suchen</button>
            <h1 style={{ color: "white" }}>Mitarbeiter mit Username: {name.username} hat Telefonnummer: {name.phonenumber} und Email: {name.email}</h1>

            <h2 style={{ color: "white" }} className="text-center">Mitarbeiter Liste</h2>
            <div className="row">

            </div>

            <div style={{ backgroundColor: "#101522" }} className="row">
                <table className="table table-striped table-bordered">


                    <thead>
                        <tr>
                            {/*  <th  style={{color:"white"}}>ID</th> */}
                            <th style={{ color: "white" }}>User</th>

                            <th style={{ color: "white" }}>Name</th>
                            <th style={{ color: "white" }}>Telefon</th>
                            <th style={{ color: "white" }}>Email</th>

                        </tr>

                    </thead>

                    <tbody>
                        {employees.map(
                            e =>
                                <tr key={e.id}>
                                    {/*    <td style={{color:"white"}}>{e.id}</td> */}
                                    <td style={{ color: "white" }}>{e.username}</td>


                                    <td style={{ color: "white" }}>{e.lastname} {e.firstname}</td>
                                    <td style={{ color: "white" }}>{e.currentphonenumber}</td>
                                    <td style={{ color: "white" }}>{e.email}</td>
                                    <td>

                                    </td>


                                </tr>
                        )}

                    </tbody>


                </table>



            </div>



        </div>
    )
}
export default EmployeeList