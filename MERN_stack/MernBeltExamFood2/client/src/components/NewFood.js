import React, { useState } from 'react'
import FoodForm from './FoodForm'
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";
import axios from 'axios';

const NewFood = () => {
    const [errors, setErrors] = useState([]);
    const navigate = useNavigate();

    const createFood = (name, img, kitchen, recipe) => {
        axios.post('http://localhost:8000/api/foods', {name, img, kitchen, recipe})
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
                <FoodForm onSubmitProp={createFood} initialName="" initialImg="" initialKitchen="" initialRecipe=""/>
            </div>
        </div>
    )
}

export default NewFood