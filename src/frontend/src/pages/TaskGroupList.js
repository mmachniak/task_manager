import './TaskGroupList.css';
import Tile from '../components/Tile';
import {useEffect, useState} from "react";

function TaskGroupList() {
    const [taskGroupList, setTaskGroupList] = useState([]);
    useEffect(function () {
        fetch("http://localhost:8080/taskGroup")
            .then(res => res.json())
            .then(json => setTaskGroupList(json.map(el => el.name)));
    }, []);

    return (
      <div className="TaskGroupList">
          {taskGroupList.map(item => <Tile text={item}/>)}
        <Tile text="+"/>
      </div>
    );
  }
  
  export default TaskGroupList;