import React from "react";
import axios from "axios";
const DeleteButton = (props) => {
    const { successCallBack, playerId } = props;
    const deletePlayer = () => {
        if (window.confirm(`Are you sure you want Delete ${props.playerName} ?`)) {
            axios
                .delete(`http://localhost:8000/api/players/${playerId}`)
                .then((res) => {
                    console.log(res);
                })
                .then(() => successCallBack())
                .catch((err) => console.error(err));
        }
    };
    return (
        <button onClick={deletePlayer} className="btn btn-sm btn-danger mx-2">
            Delete
        </button>
    );
};

export default DeleteButton;