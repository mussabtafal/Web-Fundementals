import React, { useState, useEffect } from 'react'
import axios from 'axios';
import { useParams } from "react-router-dom";
import { useNavigate, Link } from "react-router-dom";
import { width } from '@mui/system';

const FoodDetail = () => {
  const [food, setFood] = useState({});
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    axios.get('http://localhost:8000/api/foods/' + id)
      .then(res => setFood(res.data))
      .catch(err => console.error(err));
    console.log(food.name);
  }, []);

  const deleteFood = id => {
    axios.delete('http://localhost:8000/api/foods/' + id)
        .then((res) => {
          console.log(res);
          navigate("/list")
      })
}

  return (
    <div className='container-md-fluid p-4 m-5 border '>
      <div className='d-flex justify-content-center'>
        <div>
          <img src={`${food.img}`} alt="FoodPic" style={{height: "300px", width: "300px"}}></img>
        </div>
        <div>
          <p>Name: {food.name}</p>
          <p>Kitchen: {food.kitchen}</p>
          <p>Recipe: {food.recipe}</p>
          <Link to={"/edit/" + food._id }>
          <button type="button" className="btn btn-info mx-4">Edit</button>
          </Link>
          <Link to={"/delete"}>
            <button type="button" onClick={(e) => deleteFood(food._id)} className="btn btn-danger">Delete</button>
          </Link>
        </div>
      </div>
    </div>
  )
}

export default FoodDetail