import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams } from "react-router-dom";
import AuthorForm from '../components/AuthorForm';
import DeleteButton from '../components/DeleteButton'
import { useNavigate } from "react-router-dom";

const AuthorUpdate = (props) => {
    const { id } = useParams();
    const [author, setAuthor] = useState({});
    const [loaded, setLoaded] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8000/api/authors/' + id)
            .then(res => {
                setAuthor(res.data);
                setLoaded(true)
            })
    }, [id]);

    const updateAuthor = author => {
        axios.put('http://localhost:8000/api/authors/' + id, author)
            .then(res => { console.log(res); navigate('/') })
            .catch(err => console.error(err));
    }

    return (
        <div>
            {loaded && (
                <AuthorForm
                    onSubmitProp={updateAuthor}
                    initialName={author.name}
                />
            )}
            <DeleteButton authorId={author._id} successCallBack={() => navigate("/")} />
        </div>
    )
}

export default AuthorUpdate;
