import React from 'react';
import './App.css';
import MyNewComponent from './components/MyNewComponent';

function App() {
  return (
    <div className="App">
        <MyNewComponent lastName={"Doe"} firstName={"Jane"} age={45} hairColor={"Black"} />
        <MyNewComponent lastName={"Smith"} firstName={"John"} age={88} hairColor={"Brown"} />
        <MyNewComponent lastName={"Fillmore"} firstName={"Millard"} age={50} hairColor={"Brown"} />
        <MyNewComponent lastName={"Smith"} firstName={"Maria"} age={62} hairColor={"Brown"} />
    </div>
  );
}

export default App;
