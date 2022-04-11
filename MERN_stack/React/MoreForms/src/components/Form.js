import React, { useState } from 'react'

const Form = () => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");



    return (
        <div className="container-md-fluid">
            <div className="row justify-content-center">
                <div className="col-5 align-self-center p-5 m-5">
                    <form>
                        <div className="form-floating mb-3">
                            <input type="text" onChange={(e) => setFirstName(e.target.value)} className="form-control" id="floatingInput" placeholder="name@example.com"></input>
                            <label htmlFor="floatingInput">First Name</label>
                        </div>
                        <div className="form-floating mb-3">
                            <input type="text" onChange={(e) => setLastName(e.target.value)} className="form-control" id="floatingInput" placeholder="name@example.com"></input>
                            <label htmlFor="floatingInput">Last Name</label>
                        </div>
                        <div className="form-floating mb-3">
                            <input type="email" onChange={(e) => setEmail(e.target.value)} className="form-control" id="floatingInput" placeholder="name@example.com"></input>
                            <label htmlFor="floatingInput">Email address</label>
                        </div>
                        <div className="form-floating">
                            <input type="password" onChange={(e) => setPassword(e.target.value)} className="form-control" id="floatingPassword" placeholder="Password"></input>
                            <label htmlFor="floatingPassword">Password</label>
                        </div>
                        <div className="form-floating my-3">
                            <input type="password" onChange={(e) => setConfirmPassword(e.target.value)} className="form-control" id="floatingPassword" placeholder="Password"></input>
                            <label htmlFor="floatingPassword">Confirm Password</label>
                        </div>
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