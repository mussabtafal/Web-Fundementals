import React, { useState } from "react";
import AuthorForm from "./AuthorForm";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";


const NewAuthor = () => {
    const [errors, setErrors] = useState([]);
    const navigate = useNavigate();

    const createAuthor = (author) => {
        axios
            .post("http://localhost:8000/api/authors", author)
            .then((res) => {
                console.log("Response", res);
                navigate("/");
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
        <>
            <Link to="/">
                <button>All Authors</button>
            </Link>
            <p>Add new author:</p>
            {errors.map((err, index) => <p key={index}>{err}</p>)}
            <AuthorForm onSubmitProp={createAuthor} initialName="" />
        </>
    );
};

export default NewAuthor;