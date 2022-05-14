import React, { useEffect, useState} from 'react';
import { Button, Link } from '@mui/material';
import axios from 'axios';


const List = (props) => {

    const [foods, setFoods] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8000/api/foods')
            .then(res => {
                setFoods(res.data);
            })
            .catch(err => console.error(err));
    }, []);

    return (
        <div className="d-flex overflow-scroll">
            {foods.map((food, index) => <div key={index} className="card m-4" style={{width: "40%"}}>
                <img src={food.img} className="card-img-top" alt="foodpic" style={{height:"25%"}}></img>
                <div className="card-body">
                    <h5 className="card-title">{food.name}</h5>
                    <p className="card-text">{food.recipe}</p>
                    <a href={"/detail/" + food._id} className="btn btn-primary">Detail</a>
                </div>
            </div>)}
        </div>
    )
}

export default List