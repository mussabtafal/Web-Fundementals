import React from 'react'
import List from '../components/List';
import { Link } from "react-router-dom";


const Main = () => {

    return (
        <div className='container-md-fluid p-5 m-5 border border-dark horizontal-scrollable'>
                <div className="border border-dark" style={{ margin: "0 auto", width: "100%", height: "20%", borderRadius: 20 }}>
                    <h3 className="py-4" style={{ backgroundColor: "#9FC5F8" }}>Available Meals</h3>
                    <List />
                </div>
        </div >
    )
}

export default Main