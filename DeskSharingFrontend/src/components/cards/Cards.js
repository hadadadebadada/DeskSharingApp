import React from 'react';
import './Cards.css';
import CardItem from './CardItem';
import styled from 'styled-components'
const Div3 = styled.div`
    position: relative;
    width: 100%;
    border-radius: 25px;

  background-color:  #101522;
 
`;




function Cards() {
  return (
    <div
      style={{

        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        borderRadius: '25px',
        height: '100%',
        width: '100%',
        backgroundColor: "#101522"
      }}
    >


      <Div3 className='cards__wrapper'>

        <ul className='cards__items'>
          <CardItem


            src='https://sketchfab.com/models/d7b857dfd9c14611b1e7423c671b4f73/embed'
            text='Buchen Sie einen Platz in Büro Donkey Kong'

            label='Büro Donkey Kong'
            path='/officedonkeykong'
          />
          <CardItem
            src='https://sketchfab.com/models/f2992a1ec6454ab5bb5b4a0c09973e24/embed'
            text='Buchen Sie einen Platz in Büro Bowser'
            label='Büro Bowser'
            path='/officeBowser'
          />
          <CardItem
            src='https://sketchfab.com/models/24de5497539a4eccb5bb17285d2155bd/embed'
            text='Buchen Sie einen Platz in Büro Mario'
            label='Büro Mario'
            path='/officeMario'
          />

        </ul>


      </Div3>

    </div>

  );
}

export default Cards;