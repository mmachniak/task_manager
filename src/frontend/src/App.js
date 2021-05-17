import './App.css';
import TaskGroupList from "./pages/TaskGroupList";
import {Switch, BrowserRouter as Router, Route} from "react-router-dom";
import Login from "./pages/Login";
import {ErrorHandler} from "./components/ErrorHandler";
import WithAxios from "./util/WithAxios";
import TaskList from "./pages/TaskList";

function App() {
    return (
        <div className="App">
            <Router>
                <ErrorHandler>
                    <WithAxios>
                        <Switch>
                            <Route exac path="/login">
                                <Login/>
                            </Route>
                            <Route path="/taskGroup/:id/tasks">
                                <TaskList/>
                            </Route>
                            <Route path="/taskGroups">
                                <TaskGroupList/>
                            </Route>
                            <Route path="/">
                                <TaskGroupList/>
                            </Route>
                        </Switch>
                    </WithAxios>
                </ErrorHandler>
            </Router>
        </div>
    );
}

export default App;
