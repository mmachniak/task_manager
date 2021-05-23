import {Button, Form, Input} from "antd";
import 'antd/dist/antd.css';
import './AddTaskGroup.css';
import axiosApiInstance from "../util/axiosApiInstance";
import {useHistory} from "react-router-dom";

function AddTaskGroup() {
    let history = useHistory();
    function addTaskGroup(jsonObject) {
        axiosApiInstance.post("taskGroup", jsonObject)
            .then(json => {
                history.push("/");
            });
    }
    return (
        <div className="AddTaskGroup">
            <Form onFinish={values => addTaskGroup(values)}>
                <Form.Item name="name"
                           rules={[{required: true, message: "Wprowadź nazwę"}]}>
                    <Input placeholder="Nazwa"/>
                </Form.Item>
                <Form.Item className="btn">
                    <Button type="primary" htmlType="submit" className="login-form-button">
                        Dodaj
                    </Button>
                </Form.Item>
            </Form>
        </div>
    );
}

export default AddTaskGroup;