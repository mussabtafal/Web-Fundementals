import React, { useEffect, useState } from 'react'
import { Link } from "react-router-dom";
import axios from 'axios';
import AuthorsList from '../components/AuthorsList'

const Main = () => {
    const [authors, setAuthors] = useState([]);
    const [loaded, setLoaded] = useState(false)

    useEffect(() => {
        axios
            .get("http://localhost:8000/api/authors")
            .then((res) => {
                setAuthors(res.data);
                setLoaded(true);
            })
            .catch((err) => console.log(err));
    }, []);

    const removeFromDom = authorId => {
        setAuthors(authors.filter(author => author._id !== authorId));
    }

    return (
        <div className="App">
            <Link to={`/new`}>
                <button>Add New Author</button>
            </Link>
            {loaded && <AuthorsList authors={authors} removeFromDom={removeFromDom} />}
        </div>
    )
}
export default Main;
