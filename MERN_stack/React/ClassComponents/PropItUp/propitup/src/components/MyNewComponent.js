import React, { Component } from 'react';

class MyNewComponent extends Component {
    render() {
        const { firstName, lastName, age, hair} = this.props;
        return (
            <div>
                <h1>{ firstName}, { lastName }</h1>
                <p>Age: { age }</p>
                <p>Hair Color: { hair }</p>
            </div>
        );
    }
}

export default MyNewComponent;