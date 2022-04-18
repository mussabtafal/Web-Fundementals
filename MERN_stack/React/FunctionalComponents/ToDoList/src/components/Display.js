import React from 'react'

const Display = (props) => {
  return (
    <div>
        {props.tasks.map((task, idx) => <p key = {idx}>{task}</p>)}
    </div>
  )
}

export default Display