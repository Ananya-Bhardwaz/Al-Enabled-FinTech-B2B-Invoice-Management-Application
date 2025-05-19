import Header from "./components/Header";
import { Datagrid } from "./components/Datagrid";

import "./App.css";
import ToolBar from "./components/ToolBar";



function App() {
  return (
    <div className="body">
      <Header />
      <ToolBar/>
      <Datagrid/>
    </div>
  );
}

export default App;
