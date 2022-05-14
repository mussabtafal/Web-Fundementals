import './App.css';
import Main from './views/Main';
import {
  BrowserRouter,
  Route,
  Routes
} from "react-router-dom";
import FoodDetail from './components/FoodDetail';
import NewFood from './components/NewFood';
import UpdateFood from './components/UpdateFood';
import Header from '../src/components/Header';
import FoodList from '../src/views/FoodList';

function App() {
  return (
    <div className="App">
      <Header/>
      <BrowserRouter>
        <div className="App">
          <Routes>
            <Route path="/dashboard" element={<Main />} />
            <Route path="/list" element={<FoodList />} />
            <Route path="/detail/:id" element={<FoodDetail />} />
            <Route path="/edit/:id" element={<UpdateFood />} />
            <Route path="/form" element={<NewFood />} />
          </Routes>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
