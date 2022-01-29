import testfloor from '../../../assets/images/floorplans/floorplan3.jpeg'


import React, { Component } from 'react';
import ApiService from '../../../APIService';
import ShowBlockedBookings from './ShowBlockedBookings';

import bowser from '../../../assets/models/landingpage/bowser.glb'
import * as THREE from 'three';
import { OrbitControls } from "three/examples/jsm/controls/OrbitControls";
import { GLTFLoader } from 'three/examples/jsm/loaders/GLTFLoader';


class Bowser extends Component {


    constructor(props) {
        super(props)
        const current = new Date();
        const date = `${current.getFullYear()}-0${current.getMonth() + 1}-${current.getDate()}`;

        const name = `${localStorage.getItem('username')}`

        this.state = {


            username: name,
            timestart: date + "T00:00" + "",
            timeend: date + "T00:00" + "",
            status: "schwebend",
            employee: { id: "" },
            workplace: { id: "" },

            officeid: 3,

            blockedbookings: [],
            matches: window.matchMedia("(min-width: 768px)").matches,
            errorMessage: ''



        }



        this.changeDeskId = this.changeDeskId.bind(this);
        this.changeStarttime = this.changeStarttime.bind(this);
        this.changeEndtime = this.changeEndtime.bind(this);

        this.submitHandler = this.submitHandler.bind(this);





    }

    componentDidMount() {


        ApiService.findEmployeeByUsername().then(resp => resp.json())
            .then(resp => this.setState({ employee: { id: resp.id } })
            )


        const handler = e => this.setState({ matches: e.matches });
        window.matchMedia("(min-width: 768px)").addEventListener('change', handler);
        /* MODEL */


        var camera, scene, renderer;



        init();
        animate();

        function init() {

            //erzeugen eines 3js objektes
            renderer = new THREE.WebGLRenderer({ canvas: document.querySelector("#c"), antialias: true, alpha: true });
            renderer.shadowMap.enabled = true;
            renderer.shadowMap.type = THREE.PCFShadowMap;
            renderer.setPixelRatio(window.devicePixelRatio);
            const canvasContainer = document.querySelector('#divR');
            renderer.setSize(canvasContainer.offsetWidth, canvasContainer.offsetHeight);


            let aspect = canvasContainer.offsetWidth / canvasContainer.offsetHeight
            camera = new THREE.PerspectiveCamera(45, aspect, 0.1, 1500);
            camera.position.z = -105;

            scene = new THREE.Scene();


            const controls = new OrbitControls(camera, document.querySelector("#c"));
            controls.target.set(0, 0, 0);
            controls.enableDamping = true;
            controls.enableRotate = false;
            controls.enableZoom = true;
            controls.update();



            const GLTFloader = new GLTFLoader();
            let obj = null;

            GLTFloader.setCrossOrigin("true");


            GLTFloader.load(bowser, function (glb) {

                obj = glb.scene;

                glb.scene.scale.set(2, 2, 2);


                glb.scene.rotation.z = 0;
                glb.scene.rotation.y = 3;
                glb.scene.position.y = -25;

                scene.add(glb.scene);

            });



            var light = new THREE.DirectionalLight(0xffffff, 2);
            light.position.set(0, 1, -250).normalize();
            light.castShadow = true;

            scene.add(light);


        }




        function resize() {
            var width = renderer.domElement.clientWidth;
            var height = renderer.domElement.clientHeight;
            renderer.setSize(width, height, false);
            camera.aspect = width / height;
            camera.updateProjectionMatrix();
        }



        function animate() {
            resize();
            renderer.render(scene, camera);
            renderer.clearDepth();
            camera.layers.set(0);
            camera.rotation.z += 0.005;
            requestAnimationFrame(animate);
        }



        window.addEventListener('resize', this.updateDimensions);

    }

    submitHandler = e => {
        e.preventDefault()
        console.log(this.state)
        ApiService.sendBookingRequest(this.state)

    }



    changeStarttime = (e) => {
        this.setState({ timestart: e.target.value })
    }
    changeEndtime = (e) => {
        this.setState({ timeend: e.target.value })
    }

    changeDeskId = (e) => {
        this.setState({ workplace: { id: e.target.value } })
    }

    getWorkingPlace = (e) => {
        this.setState({ workplace: { id: '1' } })
    }

    getWorkingPlace2 = (e) => {
        this.setState({ workplace: { id: '2' } })
    }
    getWorkingPlace3 = (e) => {
        this.setState({ workplace: { id: '3' } })
    }

    getWorkingPlace4 = (e) => {
        this.setState({ workplace: { id: '4' } })
    }

    getWorkingPlace5 = (e) => {
        this.setState({ workplace: { id: '5' } })
    }
    getWorkingPlace6 = (e) => {
        this.setState({ workplace: { id: '6' } })
    }
    getWorkingPlace7 = (e) => {
        this.setState({ workplace: { id: '7' } })
    }





    cancel() {
        this.props.history.push('/services');
    }

    changeHandler = e => {
        this.setState({ [e.target.value]: e.target.value })
    }




    submitHandler = e => {
        e.preventDefault()
        console.log(this.state)
        ApiService.sendBookingRequest(this.state).catch(err => {
            this.setState({ errorMessage: err.message });
        })


    }

    render() {

        return (


            <div className='column' style={{
                backgroundColor: "#101522",
                alignItems: 'center',
                justifyContent: 'center',
                display: 'flex',
                flexDirection: 'column'


            }}            >
                <h1 style={{ color: "white" }} >Willkommen im Büro Bowser</h1>
                <div id='divR'

                    style={{
                        display: 'flex',
                        justifyContent: 'center',
                        alignItems: 'center',

                        height: '300px',
                        width: '300px'

                    }}
                >


                    <canvas id='c'></canvas>
                </div>
                <div >
                    <p>  <ShowBlockedBookings value={3}></ShowBlockedBookings></p>

                </div>



                <div style={{

                    display: 'flex',
                    flexDirection: 'column',
                    justifyContent: 'center',
                    textAlign: 'center',
                    alignItems: 'center',
                }}>



                    {this.state.matches && (
                        <img src={testfloor} alt="this is a floorplan" width="750" height="560" align='middle' usemap="#floormap" />

                    )}


                    {this.state.matches && (
                        <map name="floormap">


                            <area shape="circle" coords="50,200,60" alt="Platz1" onClick={this.getWorkingPlace}></area>
                            <area shape="circle" coords="150,200,60" alt="Platz2" onClick={this.getWorkingPlace2}></area>
                            <area shape="circle" coords="250,200,60" alt="Platz3" onClick={this.getWorkingPlace3}></area>
                            <area shape="circle" coords="400,200,60" alt="Platz1" onClick={this.getWorkingPlace4}></area>
                            <area shape="circle" coords="520,200,60" alt="Platz2" onClick={this.getWorkingPlace5}></area>
                            <area shape="circle" coords="640,200,60" alt="Platz3" onClick={this.getWorkingPlace6}></area>
                            <area shape="circle" coords="520,380,60" alt="Platz1" onClick={this.getWorkingPlace7}></area>



                        </map>

                    )}


                    {!this.state.matches && (
                        <img src={testfloor} alt="this is a floorplan" width="380" height="420" align='middle' usemap="#floormap" />

                    )}


                    {!this.state.matches && (
                        <map name="floormap">


                            <area shape="circle" coords="30,180,30" alt="Platz1" onClick={this.getWorkingPlace}></area>
                            <area shape="circle" coords="70,180,30" alt="Platz2" onClick={this.getWorkingPlace2}></area>
                            <area shape="circle" coords="110,180,30" alt="Platz3" onClick={this.getWorkingPlace3}></area>
                            <area shape="circle" coords="200,180,30" alt="Platz4" onClick={this.getWorkingPlace4}></area>
                            <area shape="circle" coords="260,180,30" alt="Platz5" onClick={this.getWorkingPlace5}></area>
                            <area shape="circle" coords="320,180,30" alt="Platz6" onClick={this.getWorkingPlace6}></area>
                            <area shape="circle" coords="260,300,30" alt="Platz7" onClick={this.getWorkingPlace7}></area>



                        </map>

                    )}

                    {/* INPUT FIELDS */}

                    <div className="container">

                        <div className="row">
                            <div className="card col-md-6 offset-md-3 offset-md-3">


                                <div className="card-body">



                                    <form>

                                        <div className="form-group">
                                            <label> Buchung für Platz: </label>
                                            <input type="text" placeholder="Platz im Plan wählen" name="id" className="form-control"
                                                value={this.state.workplace.id} onChange={this.changeDeskId} readonly="false" />

                                        </div>
                                        <div className="form-group">
                                            <label> Startzeit: </label>
                                            <input placeholder="Startzeit" name="starttime" className="form-control"
                                                value={this.state.timestart} onChange={this.changeStarttime} />
                                        </div>
                                        <div className="form-group">
                                            <label> Endzeit: </label>
                                            <input placeholder="Endzeit" name="endtime" className="form-control"

                                                value={this.state.timeend} onChange={this.changeEndtime} />


                                        </div>

                                        <button className="btn btn-success" onClick={this.submitHandler}>Buchungsanfrage senden</button>


                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Abbrechen</button>

                                        {this.state.errorMessage &&
                                            <h3 className="error"> Biite überprüfen Sie Ihre Eingabe. Ist ein Platz ausgewählt? Eingabe im richtigen Datumsformat ? Fehlermeldung: {this.state.errorMessage} </h3>}
                                    </form>

                                </div>
                            </div>
                        </div>

                    </div>

                </div>
                <br></br>




            </div>
        );
    }
}

export default Bowser;
