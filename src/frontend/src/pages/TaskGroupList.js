import './TaskGroupList.css';
import Tile from '../components/Tile';
import axiosApiInstance from "../util/axiosApiInstance";
import {useEffect, useState} from "react";


function TaskGroupList() {
    const [data, setData] = useState([]);
    useEffect(() => {
        axiosApiInstance.get("taskGroup").then(json => {
            setData(json);
        })
    }, []);
    return (
        <div className="TaskGroupList">
            {data.map(item => <Tile key={item.id} text={item.name}/>)}
            <Tile text="+"/>
        </div>
    );
}

export default TaskGroupList;