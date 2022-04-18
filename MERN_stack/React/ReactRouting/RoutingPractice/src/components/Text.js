import React from 'react'
import { useParams } from "react-router";

const Text = (props) => {
    const { param, color, bgColor } = useParams();

    return (
        <div>
            {isNaN(param) ? <h3 style={{ backgroundColor: bgColor, color: color }}>The Word is {param}</h3> : <h3 style={{ backgroundColor: bgColor, color: color }}>The Number is {param}</h3>}
        </div>
    )
}

export default Text