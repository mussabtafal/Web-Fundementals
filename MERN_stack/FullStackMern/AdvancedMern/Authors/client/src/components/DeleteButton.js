import React from "react";
import axios from "axios";
const DeleteButton = (props) => {
    const { successCallBack, authorId } = props;
    const deleteAuthor = () => {
        axios
            .delete(`http://localhost:8000/api/authors/${authorId}`)
            .then((res) => {
                console.log(res);
            })
            .then(() => successCallBack())
            .catch((err) => console.error(err));
    };
    return (
        <button onClick={deleteAuthor} className="btn btn-sm btn-danger mx-2">
            Delete
        </button>
    );
};

export default DeleteButton;