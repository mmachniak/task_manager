import './TaskGroupList.css';
import Tile from '../components/Tile';
import axiosApiInstance from "../util/axiosApiInstance";
import {useEffect, useState} from "react";


function TaskGroupList() {
    const [data, setData] = useState([]);
    useEffect(() => {
        axiosApiInstance.get("taskGroup").then(json => {
            setData(json);
        });
    }, [setData]);
    const deleteFunction = (id) => {
        return () => axiosApiInstance.delete(`taskGroup/${id}`)
            .then(() => setData(data.filter(value => value.id !== id)));
    };

    return (
        <div className="TaskGroupList">
            {data.map(item => <Tile key={item.id} text={item.name} deleteFunction={deleteFunction(item.id)}/>)}
            <Tile text="+"/>
        </div>
    );
}

export default TaskGroupList;