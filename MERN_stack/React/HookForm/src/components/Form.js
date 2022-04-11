import React, {useState} from 'react'

const Form = () => {
    const [firstName, setFirstName] = useState("");
  return (
    <div>
        <div class="form-floating mb-3">
            <input type="text" className="form-control" id="floatingInput" placeholder="name@example.com"></input>
            <label htmlFor="floatingInput">First Name</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" className="form-control" id="floatingInput" placeholder="name@example.com"></input>
            <label htmlFor="floatingInput">Last Name</label>
        </div>
        <div class="form-floating mb-3">
            <input type="email" className="form-control" id="floatingInput" placeholder="name@example.com"></input>
            <label htmlFor="floatingInput">Email address</label>
        </div>
        <div class="form-floating">
            <input type="password" className="form-control" id="floatingPassword" placeholder="Password"></input>
            <label htmlFor="floatingPassword">Password</label>
        </div>
        <div class="form-floating">
            <input type="password" className="form-control" id="floatingPassword" placeholder="Password"></input>
            <label htmlFor="floatingPassword">Confirm Password</label>
        </div>

        <h2>Your Form Data</h2>
        <p>First Name: </p>
        <p>Last Name: </p>
        <p>Email address: </p>
        <p>Password: </p>
        <p>Confirm Password: </p>
    </div>
  )
}

export default Form