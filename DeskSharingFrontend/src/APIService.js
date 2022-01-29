
import axios from 'axios'
export default class ApiService {




    /* 131.173.88.173:443 */

    /* 37.5.253.38 */
    
    static loginUser(body) {

        return axios.post('http://131.173.88.173:443/login', body)
            .then(resp => {
                // console.log(resp)
                localStorage.setItem("token", resp.data)
                /*              resp.json().then((result)=>{
                                 console.warn("result",result);
                                 localStorage.setItem('login', JSON.stringify({
                                     login:true,
                                     token:result.token
                                 })
                                 )
                             }) */
            })
            .then(localStorage.setItem("username", body.username))
            .catch(error => {
                console.log(error)
            })
    }





    /* 
        static RegisterUser(body) {
    
            return fetch('http://127.0.0.1:8000/api/users/', {
                'method': 'POST',
                headers: {
                    'Content-Type': 'application/json',
    
                },
                body: JSON.stringify(body)
    
            }).then(resp => resp.json())
    
        } */

    /* ADMIN BOOKING API CALLS */

    static declineBooking(id) {
        let tokenLS = localStorage.getItem('token')

        return fetch(`http://131.173.88.173:443/api/v1/booking/e1/updateAbgelehnt/${id}`, {
            'method': 'PUT',
            headers: {

                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': `Bearer ${tokenLS}`
            },

        }).then(resp => console.log(resp.json()))



    }


    static leaveWorkspace(id) {
        let tokenLS = localStorage.getItem('token')

        return fetch(`http://131.173.88.173:443/api/v1/booking/leaveWorkspace/${id}`, {
            'method': 'PUT',
            headers: {

                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': `Bearer ${tokenLS}`
            },




        }).then(resp => console.log(resp.json()))



    }



    static acceptBooking(id) {


        let tokenLS = localStorage.getItem('token')

        return fetch(`http://131.173.88.173:443/api/v1/booking/updateAkzeptiert/${id}`, {
            'method': 'PUT',
            headers: {

                'Content-Type': 'application/json',
                'Accept': 'application/json',
                'Authorization': `Bearer ${tokenLS}`
            },

        }).then(resp => console.log(resp.json()))


    }

    static getAllRequest() {

        const url = "http://131.173.88.173:443/api/v1/booking/getAllBookings";
        const tokenLS = localStorage.getItem('token')


        return fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${tokenLS}`

            }

        })
            .then(res => res.json())

            .catch(err => console.log(err.message));
    }

    /* EMPLOYEE API CALLS */

    static getAllEmployees() {
        const urlphone = "http://131.173.88.173:443/api/v1/booking/getCurrentPhoneNumberofEmployees"

        return fetch(urlphone, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                // 'Authorization': `Bearer ${token}`

            }

        })
            .then(res => res.json())
            .catch(err => console.log(err.message));
    }

    static getEmployeeByUsername(name) {

        // const name = localStorage.getItem('username');

        const url = `http://131.173.88.173:443/api/v1/employee/e1/findEmployeeByUsername/${name}`;

        const tokenLS = localStorage.getItem('token')


        return fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${tokenLS}`

            }

        })
    }

    static getEmployeeByUsernameAdmin(name) {

        // const name = localStorage.getItem('username');

        const url = `http://131.173.88.173:443/api/v1/employee/findEmployeeByUsername/${name}`;

        const tokenLS = localStorage.getItem('token')


        return fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${tokenLS}`

            }

        })
    }






    /* BOOKING REQUEST API CALLS */
    static sendBookingRequest(body) {
        let tokenLS = localStorage.getItem('token')


        return fetch(`http://131.173.88.173:443/api/v1/booking/e1/saveBookingWithIDs/`, {
            'method': 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${tokenLS}`


            },
            body: JSON.stringify(body)

        }).then(resp => resp.json()
            .then(resp => console.log(resp)))



    }

    static findEmployeeByUsername() {
        const tokenLS = localStorage.getItem('token');
        const username = localStorage.getItem('username');
        console.log(username);

        return fetch(`http://131.173.88.173:443/api/v1/employee/e1/findEmployeeByUsername/${username}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${tokenLS}`

            }

        })
    }




    static getBlockedBookingsByOffice(id) {
        const url = `http://131.173.88.173:443/api/v1/booking/getCurrentTakenWorksplacesByOffice/${id}`;
        const token = localStorage.getItem('token')


        return fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`

            }

        })

    }

    /* MY BOOKINGS */
    static getBookingsByUsername() {

        const token = localStorage.getItem('token')
        const username = localStorage.getItem("username")

        console.log(token)
        console.log(username)

        const url = `http://131.173.88.173:443/api/v1/booking/e1/findBookingsByUsername/${username}`
        return fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`

            }

        })
    }



}