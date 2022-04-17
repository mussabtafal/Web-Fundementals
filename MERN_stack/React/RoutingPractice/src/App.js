import './App.css';
import {
  BrowserRouter,
  Switch,
  Route,
} from "react-router-dom";
import Home from './components/Home';
import Text from './components/Text';

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/home"><Home /></Route>
        <Route exact path="/:param"><Text /></Route>
        <Route exact path="/:param/:color/:bgColor"><Text /></Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
