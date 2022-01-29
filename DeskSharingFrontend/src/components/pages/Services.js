import React from 'react';

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import Cards from '../cards/Cards'
import Bowser from './offices/Bowser';
import Mario from './offices/Mario';
import DonkeyKong from './offices/DonkeyKong';
import Typed from 'react-typed'


const Services = () => {

  return (

    <div
      style={{
        justifyContent: 'center',
        alignItems: 'center',
        height: '60vh',
        backgroundColor: "#101522",

      }}
    >

      <Router>


        <div className="cardsDiv">
          <h1 style={{ color: 'red' }}>
            <Typed className="typed-text"
              strings={["Are you ready to take a table?", "Choose your office!"
              ]}
              typeSpeed={30}
              backSpeed={8}
            ></Typed>
          </h1>
          <Cards />
        </div>

        <div className="floorplan">
          <Switch>
            <Route exact path='/officedonkeykong' exact component={DonkeyKong} />
            <Route exact path='/officebowser' exact component={Bowser} />
            <Route exact path='/officemario' exact component={Mario} />
          </Switch>
        </div>

      </Router>
    </div>

  );
};




export default Services;