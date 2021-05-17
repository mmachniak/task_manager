import './TaskGroupList.css';
import Tile from '../components/Tile';
import axiosApiInstance from "../util/axiosApiInstance";
import {useEffect, useState} from "react";
import {useParams} from 'react-router-dom';
import './TaskList.css';


function TaskList() {
    const [data, setData] = useState([]);
    const {id : taskGroupId} = useParams();
    useEffect(() => {
        axiosApiInstance.get(`taskGroup/${taskGroupId}/task`).then(json => {
            setData(json);
        });
    }, [setData]);
    const deleteFunction = (id) => {
        return () => axiosApiInstance.delete(`taskGroup/${id}`)
            .then(() => setData(data.filter(value => value.id !== id)));
    };

    return (
        <div className="TaskList">
            {data.map(item => <Tile key={item.id} text={item.description} deleteFunction={deleteFunction(item.id)}/>)}
            <Tile text="+"/>
        </div>
    );
}

export default TaskList;