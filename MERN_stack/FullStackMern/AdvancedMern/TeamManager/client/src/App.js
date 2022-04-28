import './App.css';
import {
  BrowserRouter,
  Route,
  Routes
} from "react-router-dom";
import Main from "./views/Main";
import Header from './components/Header';
import NewPlayer from './views/NewPlayer';
import GameOne from './components/GameOne';
import GameTwo from './components/GameTwo';
import GameThree from './components/GameThree';


function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/players" element={<Main />} />
          <Route path="/players/addplayer" element={<NewPlayer />} />
          <Route path="/status/game1" element={<GameOne />} />
          <Route path="/status/game2" element={<GameTwo />} />
          <Route path="/status/game3" element={<GameThree />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;


