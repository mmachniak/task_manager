import './TaskGroupList.css';
import Tile from '../components/Tile';
import {useQuery} from "../util/query";


function TaskGroupList() {
    const {data} = useQuery("http://localhost:8080/taskGroup", []);
    console.log(data);
    return (
      <div className="TaskGroupList">
          {data.map(item => item.name).map(item => <Tile text={item}/>)}
        <Tile text="+"/>
      </div>
    );
  }
  
  export default TaskGroupList;