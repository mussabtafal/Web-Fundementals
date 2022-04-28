import React, { useState } from 'react'
import { TextField, Button } from "@mui/material"
import { Link } from 'react-router-dom'

const PlayerForm = (props) => {
    const [name, setName] = useState(props.initialName)
    const [position, setPosition] = useState(props.initialPosition)

    const onSubmitHandler = (e) => {
        e.preventDefault();
        props.onSubmitProp({ name, position })
    }

    return (
        <div>
            <Link to="/players">List</Link>
            |
            <Link to="/players/addplayer">Add Player</Link>
            <h1>Add a new Player</h1>
            {props.errorProp.map((err, index) => <p key={index}>{err}</p>)}
            <form onSubmit={onSubmitHandler}>
                <TextField id="standard-basic" label="Player Name" variant="standard" onChange={e => setName(e.target.value)} value={name} />
                <TextField id="standard-basic" label="Player Position" variant="standard" onChange={e => setPosition(e.target.value)} value={props.initialPosition} />
                <Button variant="contained" color="success" type='submit'>Add</Button>
            </form>
        </div>
    )
}

export default PlayerForm