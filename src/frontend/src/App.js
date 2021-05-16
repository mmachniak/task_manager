import './App.css';
import TaskGroupList from "./pages/TaskGroupList";
import {Switch, BrowserRouter as Router, Route} from "react-router-dom";
import Login from "./pages/Login";
import {ErrorHandler} from "./components/ErrorHandler";

function App() {
    return (
        <div className="App">
            <Router>
                <ErrorHandler>
                    <Switch>
                        <Route exac path="/login">
                            <Login/>
                        </Route>
                        <Route path="/">
                            <TaskGroupList/>
                        </Route>
                    </Switch>
                </ErrorHandler>
            </Router>
        </div>
    );
}

export default App;
