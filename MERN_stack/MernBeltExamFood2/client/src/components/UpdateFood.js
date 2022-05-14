import React, { useState, useEffect } from 'react'
import FoodForm from './FoodForm'
import { useNavigate, useParams } from "react-router-dom";
import { Link } from "react-router-dom";
import axios from 'axios';

const UpdateFood = () => {
    const [errors, setErrors] = useState([]);
    const [food, setFood] = useState({})
    const [loaded, setLoaded] = useState(false);


    const navigate = useNavigate();
    const {id} = useParams();

    useEffect(() => {
        axios.get('http://localhost:8000/api/foods/' + id)
            .then(res => {
                setFood(res.data);
                setLoaded(true)
            })
    }, []);

    const updateFood = (name, img, kitchen, recipe) => {
        axios.put('http://localhost:8000/api/foods/' + id, {name, img, kitchen, recipe })
            .then(res => {
                console.log("Response", res);
                navigate("/list");
            })
            .catch(err => {
                const errorResponse = err.response.data.errors; // Get the errors from err.response.data
                const errorArr = []; // Define a temp error array to push the messages in
                for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
                    errorArr.push(errorResponse[key].message)
                }
                // Set Errors
                setErrors(errorArr);
            })
    }
    return (
        <div className='container-md-fluid p-5 m-5 border border-dark' style={{ width: "60%", margin: "0 auto" }}>
            <div className='row justify-content-end'>
                <div className="col-3">
                    <Link className="text-end" to="/dashboard">Back to Dashboard</Link>
                </div>
            </div>
            <div className="row justify-content-center">
                {errors.map((err, index) => <p key={index}>{err}</p>)}
                {loaded && (<FoodForm onSubmitProp={updateFood} initialName={food.name} initialImg={food.img} initialKitchen={food.kitchen} initialRecipe={food.recipe}/> )}
            </div>
        </div>
    )
}

export default UpdateFood