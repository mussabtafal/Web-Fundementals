import React, { useState } from 'react';
import PlayerForm from './PlayerForm';
import axios from "axios";
import { useNavigate } from "react-router-dom";


const NewPLayer = () => {
    const [errors, setErrors] = useState([]);
    const navigate = useNavigate();

    const createPlayer = (player) => {
        axios
            .post("http://localhost:8000/api/players", player)
            .then((res) => {
                console.log("Response, ", res);
                navigate("/players");
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
    };
    return (
        <div>
            <PlayerForm onSubmitProp={createPlayer} errorProp= {errors} initialName="" initialPostion="" />
        </div>
    )
}

export default NewPLayer