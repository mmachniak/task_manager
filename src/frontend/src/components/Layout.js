import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import {ErrorHandler} from "./ErrorHandler";
import WithAxios from "../util/WithAxios";
import {Menu} from "antd";
import Icon from "@ant-design/icons";
import Header from "./Header";

function Layout({children}) {
    return (
        <div className="Layout">
            <Router>
                <ErrorHandler>
                    <WithAxios>
                        <Header />
                        {children}
                    </WithAxios>
                </ErrorHandler>
            </Router>
        </div>
    );
}

export default Layout;
