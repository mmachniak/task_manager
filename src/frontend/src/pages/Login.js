import './TaskGroupList.css';
import {Button, Form, Input} from "antd";
import {UserOutlined, LockOutlined} from '@ant-design/icons';
import 'antd/dist/antd.css';
import {useState} from "react";
import {Redirect} from "react-router-dom";

function Login() {

    const [redirect, setRedirect] = useState(false);

    const onFinish = values => {
        async function responseBody() {
            const response = await fetch("http://localhost:8080/auth/login",
                {
                    method: 'POST', body: JSON.stringify(values), headers: {
                        'Content-Type': 'application/json'
                    }
                });
            localStorage.setItem('token', response.headers.get("Authorization"));
            setRedirect(true);
            return response.json();
        }

        return responseBody();
    }

    return (
        <>
            {redirect ? <Redirect /> : null}
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
                <Form.Item>
                    <Button type="primary" htmlType="submit" className="login-form-button">
                        Log in
                    </Button>
                    {/*Or <a href="">register now!</a>*/}
                </Form.Item>
            </Form>
        </>
    );
}

export default Login;