import React, {useState} from 'react'

const Form = (props) => {
    const [newColor, setNewColor] = useState("");
    const [size, setSize] = useState(200);
    
    function submitBox(event) {
      event.preventDefault();
      props.newBox({color: newColor, size: size});
      setNewColor("");
    }
  return (
    <form onSubmit={(event) => submitBox(event)}>
        <div>
            <label>Color</label>
            <input onChange={(event) => {setNewColor(event.target.value)}} type="text" value={newColor}/>
        </div>
        <div>
            <label>Size</label>
            <input onChange={(event) => {setSize(event.target.value)}} type="number" value={size}/>
        </div>
        <button>Add</button>
    </form>
  )
}

export default Form