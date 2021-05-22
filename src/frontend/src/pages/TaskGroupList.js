import './TaskGroupList.css';
import Tile from '../components/Tile';
import axiosApiInstance from "../util/axiosApiInstance";
import {useEffect, useState} from "react";
import {useHistory} from "react-router-dom";


function TaskGroupList() {
    const [data, setData] = useState([]);
    let history = useHistory();
    useEffect(() => {
        axiosApiInstance.get("taskGroup").then(json => {
            setData(json);
        });
    }, [setData]);
    const deleteFunction = (id) => {
        return () => axiosApiInstance.delete(`taskGroup/${id}`)
            .then(() => setData(data.filter(value => value.id !== id)));
    };

    const navigateToTaskList = (id) => {
        return () => history.push(`/taskGroup/${id}/tasks`)
    }

    return (
        <div className="TaskGroupList">
            {data.map(item => <Tile key={item.id} text={item.name} deleteFunction={deleteFunction(item.id)} onClick={navigateToTaskList(item.id)}/>)}
            <Tile text="+"/>
        </div>
    );
}

export default TaskGroupList;