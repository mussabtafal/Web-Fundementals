import React, { Component } from 'react';

class MyNewComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            age: this.props.age
        };
    }
    
    increaseBirthday = () => {
        this.setState(
            {age: this.state.age + 1}
        )
    }

    render() {
        return (
            <>
            <div>=============================================</div>
            <div >
                <h1>{this.props.lastName}, {this.props.firstName}</h1>
                <p>Age: {this.state.age}</p>
                <p>Hair Color: {this.props.hairColor}</p>
                <button onClick = {this.increaseBirthday}> Birthday button for {this.props.firstName} </button>
            </div>
        </>
        );
    }
}

export default MyNewComponent;