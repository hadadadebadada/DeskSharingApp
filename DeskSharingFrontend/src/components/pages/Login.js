import React, { useState } from 'react'
import ApiService from '../../APIService'
import { useCookies } from 'react-cookie'




function Login() {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [token, setToken] = useCookies(['mytoken'])
    const [isLogin, setLogin] = useState(true)







    const loginBtn = () => {
        ApiService.loginUser({ username, password })

            .then(resp => setToken('mytoken', resp.token)) //cookie token verifizierung
            .catch(error => console.log(error))

    }
    const RegisterBtn = () => {
        ApiService.RegisterUser({ username, password })
            .then(() => loginBtn())
            .catch(error => console.log(error))

    }



    return (
        <div className="App">
            <br></br>
            <br></br>
            {isLogin ? <h1 style={{ color: 'white' }}>Please Login </h1> : <h1 style={{ color: 'white' }}>Please Register </h1>}
            <br></br>
            <br></br>
            <div className="mb-3"></div>



            <label htmlFor="username" className="form-label"></label>

            <input type="text" className="form-control" id="username" placeholder="Enter a username"
                value={username} onChange={e => setUsername(e.target.value)}></input>

            <br></br>
            <div className="mb-3"></div>
            <label htmlFor="password" className="form-label"></label>
            <input type="password" className="form-control" id="password" placeholder="Enter a password"
                value={password} onChange={e => setPassword(e.target.value)}
            ></input>
            <br></br>
            {isLogin ? <button onClick={loginBtn} className="btn btn-primary">Login</button>
                : <button onClick={RegisterBtn} className="btn btn-primary">Register</button>
            }

            <div className="mb-3">
                <br />
                {isLogin ? <h5 style={{ color: 'white' }}>If You Don't Have Account, Please <button className="btn btn-primary" onClick={() => setLogin(false)} >Register</button>Here</h5>

                    : <h5 style={{ color: 'white' }}>If You Have Account, Please <button className="btn btn-primary" onClick={() => setLogin(true)} >Login</button>Here</h5>
                }

                <h1 style={{ color: 'red' }}>Your loged in as: {localStorage.getItem('username')}</h1>

            </div>

        </div>
    )
}

export default Login
