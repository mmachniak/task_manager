import './TaskGroupList.css';
import {Button, Form, Input} from "antd";
import {LockOutlined, UserOutlined} from '@ant-design/icons';
import 'antd/dist/antd.css';
import './Login.css';
import {useState} from "react";
import {Redirect} from "react-router-dom";
import axiosApiInstance from '../util/axiosApiInstance';

function Login() {

    const [redirect, setRedirect] = useState(false);

    const onFinish = values => {
        axiosApiInstance.post("auth/login", JSON.stringify(values))
            .then(json => {
                localStorage.setItem('token', json.token);
                setRedirect(true);
            });
    }

    return (
        <div className="Login">
            {redirect ? <Redirect/> : null}
            <Form name="normal_login" className="login-form" onFinish={onFinish}>
                <Form.Item name="username"
                           rules={[{required: true, message: "Please input your UserName!"}]}>
                    <Input prefix={<UserOutlined className="site-form-item-icon"/>} placeholder="Username"/>
                </Form.Item>
                <Form.Item
                    name="password"
                    rules={[{required: true, message: 'Please input your Password!'},]}>
                    <Input
                        prefix={<LockOutlined className="site-form-item-icon"/>}
                        type="password"
                        placeholder="Password"
                    />
                </Form.Item>
                <Form.Item className="btn">
                    <Button type="primary" htmlType="submit" className="login-form-button">
                        Log in
                    </Button>
                </Form.Item>
            </Form>
        </div>
    );
}

export default Login;