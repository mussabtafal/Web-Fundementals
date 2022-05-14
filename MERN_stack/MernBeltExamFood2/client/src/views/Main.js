import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
const Main = () => {
const [allFoods, setAllFoods] = useState([]);
const [food, setFood] = useState(0);
const [loaded, setLoaded] = useState(false);
const navigate = useNavigate();

useEffect(()=>{
    axios.get('http://localhost:8000/api/foods')
            .then(res=>{
            setAllFoods(res.data);
            setLoaded(true);
        })
        .catch(err => console.error(err));
},[]);

const reject =()=>{
    var food = Math.floor(Math.random()* allFoods.length);
    console.log(food)
    setFood(food)
}
const accept =()=>{
    axios.put('http://localhost:8000/api/foods/'+ allFoods[food]._id, {like:allFoods[food].like+1})
            .then(res=>{
                var item = Math.floor(Math.random()* allFoods.length);
                console.log(item)
                setFood(item)
            })
}

    return (
    <div>
        { loaded && (
        <>
        <div className="container">
            <div className="row" style={{padding:"10px"}}>
            <h1>{allFoods[food].name} </h1>
                <div className="col">
                <img src={allFoods[food].img} alt="foodPic" style={{width:"500px"}}></img>
                </div>
            </div>
            <div className="row">
                <h3>Do you like the food??</h3>
            <div className="col" >
            <button type="button" className="btn btn-outline-danger" onClick={reject}  style={{margin:"5px" }}>No</button>
            <button type="button" className="btn btn-outline-success" onClick={accept} style={{margin:"5px" }}>Yes</button>
                </div>
                
                </div>
            </div>
        </>)}
    </div>
)
}

export default Main