import React, { useState } from 'react'

const Form = () => {
    const [firstName, setFirstName] = useState("");
    const [firstNameError, setFirstNameError] = useState("");
    const [lastName, setLastName] = useState("");
    const [lastNameError, setLastNameError] = useState("");
    const [email, setEmail] = useState("");
    const [emailError, setEmailError] = useState("");
    const [password, setPassword] = useState("");
    const [passwordError, setPasswordError] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [confirmPasswordError, setConfirmPasswordError] = useState("");

    const handleFirstName = (e) => {
        setFirstName(e.target.value);
        if (e.target.value.length === 1) {
            setFirstNameError('*first name must be at least two characters');
        } else {
            setFirstNameError('');
            setFirstName(e.target.value);
        }
    }
    const handleLastName = (e) => {
        setLastName(e.target.value);
        if (e.target.value.length === 1) {
            setLastNameError('*last name must be at least two characters');
        } else {
            setLastNameError('');
            setLastName(e.target.value);

        }
    }
    const handleEmail = (e) => {
        setEmail(e.target.value);
        if (e.target.value.length > 0 && e.target.value.length < 5) {
            setEmailError('*email must be longer than 5 characters');
        } else {
            setEmailError('');
            setEmail(e.target.value);
        }
    }
    const handlePassword = (e) => {
        setPassword(e.target.value);
        if (e.target.value.length > 0 && e.target.value.length < 8) {
            setPasswordError('*password must be at least 8 characters');
        } else {
            setPasswordError('');
            setPassword(e.target.value);
        }
    }
    const handleConfirmPassword = (e) => {
        setConfirmPassword(e.target.value);
        if (e.target.value.length > 0 && e.target.value !== password) {
            setConfirmPasswordError('*passwords must match');
        } else {
            setConfirmPasswordError('');
            setConfirmPassword(e.target.value);
        }
    }   

    return (
        <div className="container-md-fluid">
            <div className="row justify-content-center">
                <div className="col-5 align-self-center p-5 m-5">
                    <form>
                        <div className="form-floating mb-3">
                            <input type="text" onChange={handleFirstName} className="form-control" id="floatingInput" placeholder="name@example.com"></input>
                            <label htmlFor="floatingInput">First Name</label>
                        </div>
                        {firstNameError ?<p style={{ color: 'red' }}>{firstNameError}</p> :''}

                        <div className="form-floating mb-3">
                            <input type="text" onChange={handleLastName} className="form-control" id="floatingInput" placeholder="name@example.com"></input>
                            <label htmlFor="floatingInput">Last Name</label>
                        </div>
                        {lastNameError ?<p style={{ color: 'red' }}>{lastNameError}</p> :''}

                        <div className="form-floating mb-3">
                            <input type="email" onChange={handleEmail} className="form-control" id="floatingInput" placeholder="name@example.com"></input>
                            <label htmlFor="floatingInput">Email address</label>
                        </div>
                        {lastNameError ?<p style={{ color: 'red' }}>{emailError}</p> :''}

                        <div className="form-floating">
                            <input type="password" onChange={handlePassword} className="form-control" id="floatingPassword" placeholder="Password"></input>
                            <label htmlFor="floatingPassword">Password</label>
                        </div>
                        {passwordError ?<p style={{ color: 'red' }}>{passwordError}</p> :''}

                        <div className="form-floating my-3">
                            <input type="password" onChange={handleConfirmPassword} className="form-control" id="floatingPassword" placeholder="Password"></input>
                            <label htmlFor="floatingPassword">Confirm Password</label>
                        </div>
                        {confirmPasswordError ?<p style={{ color: 'red' }}>{confirmPasswordError}</p> :''}

                    </form>
                    <h2>Your Form Data</h2>
                    <p>First Name: {firstName}</p>
                    <p>Last Name: {lastName}</p>
                    <p>Email address: {email}</p>
                    <p>Password: {password}</p>
                    <p>Confirm Password: {confirmPassword}</p>
                </div>
            </div>
        </div>
    )
}

export default Form