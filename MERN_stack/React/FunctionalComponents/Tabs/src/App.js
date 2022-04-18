import './App.css';
import Tab from "./components/Tab";

function App() {
  const tabData = [{ name: "Tab1", content: "Tab1 content showing here" },
  { name: "Tab2", content: "Tab2 content showing here" },
  { name: "Tab3", content: "Tab3 content showing here" }]
  return (
    <div className="App">
      <Tab tabData={tabData} />
    </div>
  );
}

export default App;
