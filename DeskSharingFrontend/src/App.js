
import Navbar2 from "./components/navbar/Navbar2"
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom'
import Footer from './components/footer/Footer'
import Slider from "./components/slideshow/Slider"

import Login from './components/pages/Login.js'
import myBookings from './components/pages/MyBookings.js'
import home from './components/pages/Home.js';
import Services from './components/pages/Services.js'
import EmployeeList from './components/pages/EmployeeList';
import AdminBooking from './components/pages/AdminBooking';
import { useEffect, useState } from "react"
function App() {


  const [width, setWindowWidth] = useState(0);




  useEffect(() => {

    updateDimensions();

    window.addEventListener("resize", updateDimensions); return () =>
      window.removeEventListener("resize", updateDimensions);
  }, [])

  const updateDimensions = () => {
    const width = window.innerWidth
    setWindowWidth(width)
  }


  const responsive = {
    showFooter: width > 1023
  }

  return (

    <div className="mainDiv"
      style={{
        position: 'absolute',
        height: '100%',
        width: '100%',
        backgroundColor: "#101522"
      }}

    >

      <Router>

        <Navbar2 />

        <Switch>

          <Route exact path="/" render={() => (
            <Redirect to="/home" exact component={Login} />
          )} />

          <Route exact path='/services' exact component={Services} />

          <Route exact path='/employeelist' exact component={EmployeeList}></Route>

          <Route exact path='/login' exact component={Login} />
          <Route exact path='/myBookings' exact component={myBookings} />
          <Route exact path='/home' exact component={home} />
          <Route exact path='/adminbooking' exact component={AdminBooking}></Route>

        </Switch>

      </Router>


      {
        width > 1200 ? (<div style={
          {
            marginBottom: '160vh',
            backgroundColor: "#101522"
          }}>

        </div>) : (
          <div style={
            {
              marginBottom: '250vh',
              backgroundColor: "#101522"
            }}>

          </div>)

      }



      {console.log(width)}



      {
        width > 1200 && (<Slider></Slider>)
      }


      {width < 1200 ? (<div style={{
        height: 300, backgroundColor: "#101522"
      }}></div>) :
        (<div style={{
          height: 300, backgroundColor: "#101522"
        }} ></div>)
      }




      <Router>

        <Footer />
      </Router>
    </div>
  );
}


export default App;


