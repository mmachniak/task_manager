import './App.css';
import TaskGroupList from "./pages/TaskGroupList";
import {Route, Switch} from "react-router-dom";
import Login from "./pages/Login";
import TaskList from "./pages/TaskList";
import Layout from "./components/Layout";
import AddTaskGroup from './pages/AddTaskGroup';

function App() {
    return (
        <div className="App">
            <Layout>
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
                    <Route path="/addTaskGroup">
                        <AddTaskGroup/>
                    </Route>
                    <Route path="/">
                        <TaskGroupList/>
                    </Route>
                </Switch>
            </Layout>
        </div>
    );
}

export default App;
