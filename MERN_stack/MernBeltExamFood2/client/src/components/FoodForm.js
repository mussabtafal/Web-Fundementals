import React, { useState } from 'react'

const FoodForm = (props) => {
    const { initialName, initialImg, initialKitchen, initialRecipe, onSubmitProp } = props;
    const [name, setName] = useState(initialName);
    const [img, setImg] = useState(initialImg);
    const [kitchen, setkitchen] = useState(initialKitchen);
    const [recipe, setRecipe] = useState(initialRecipe);

    const handleSubmit = e => {
        e.preventDefault();
        onSubmitProp(name, img, kitchen, recipe );
        setName("");
        setImg("");
        setkitchen("");
        setRecipe("");
    }
    return (
        <div className='d-flex'>
            <form onSubmit={handleSubmit}>
                <div className='row'>
                    <div className='col-6'>
                        <div className='row justify-content-center' >
                            <div className='col-12'>
                                <div className="form-floating mb-3">
                                    <input type="text" onChange={e => setName(e.target.value)} value={name} className="form-control" id="floatingInput" placeholder="name@example.com" />
                                    <label htmlFor="floatingInput">Food Name</label>
                                </div>
                            </div>
                        </div>
                        <div className='row justify-content-center'>
                            <div className='col-12'>
                                <div className="form-floating mb-3">
                                    <input type="text" className="form-control" onChange={e => setImg(e.target.value)} value={img} id="floatingInput" placeholder="name@example.com" />
                                    <label htmlFor="floatingInput">Img Url</label>
                                </div>
                            </div>
                        </div>
                        <div className='row justify-content-center'>
                            <div className='col-12'>
                                <div className="form-floating mb-3">
                                    <input type="text" className="form-control" onChange={e => setkitchen(e.target.value)} value={kitchen} id="floatingInput" placeholder="name@example.com" />
                                    <label htmlFor="floatingInput">Kitchen</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className='col-6'>
                        <div className="form-floating">
                            <textarea className="form-control" onChange={e => setRecipe(e.target.value)} value={recipe} placeholder="Leave a comment here" id="floatingTextarea2" style={{height: "100px"}}></textarea>
                            <label htmlFor="floatingTextarea2">Recipe</label>
                        </div>
                    </div>
                </div>
                <button type="submit" className="btn btn-info col-6"> ➕ Add/Update Food</button>
            </form>
        </div>
    )
}

export default FoodForm