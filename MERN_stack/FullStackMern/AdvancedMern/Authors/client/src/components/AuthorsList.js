import React from 'react'
import { Link } from "react-router-dom";
import DeleteButton from './DeleteButton'

const AuthorsList = (props) => {

    return (
        <div>
            {props.authors.map((author, idx) => {
                return <p key={idx}>
                    {author.name}
                    |
                    <Link to={`/edit/${author._id}`}>
                        <button>Edit</button>
                    </Link>
                    |
                    <DeleteButton authorId={author._id} successCallBack={() => props.removeFromDom(author._id)} />
                </p>
            })}
        </div>
    )
}

export default AuthorsList;
