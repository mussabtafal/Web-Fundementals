import "./App.css";
import {
  BrowserRouter,
  Route,
  Routes
} from "react-router-dom";
import React from 'react'
import AuthorUpdate from "../src/components/AuthorUpdate";
import NewAuthor from '../src/components/NewAuthor';
import Main from "./views/Main";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <h4>Favorite Authors</h4>
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/new" element={<NewAuthor />} />
          <Route path="/edit/:id" element={<AuthorUpdate />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;