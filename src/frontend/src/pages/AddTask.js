import {Button, Form, Input} from "antd";
import 'antd/dist/antd.css';
import './AddTask.css';
import axiosApiInstance from "../util/axiosApiInstance";
import {useHistory, useParams} from "react-router-dom";

function AddTask() {
    let history = useHistory();
    const {id} = useParams();
    function addTask(jsonObject) {
        axiosApiInstance.post("taskGroup/" + id + "/task", jsonObject)
            .then(json => {
                history.push("/taskGroup/" + id + "/tasks");
            });
    }
    return (
        <div className="AddTask">
            <Form onFinish={values => addTask(values)}>
                <Form.Item name="description"
                           rules={[{required: true, message: "Wprowadź zadanie"}]}>
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

export default AddTask;