import './TaskGroupList.css';
import Tile from '../components/Tile';

function TaskGroupList() {
    const taskGroupList = [
        'Promocja Santander',
        'Promocja GetIn Bank',
        'Promocja Milenium'
    ];
    return (
      <div className="TaskGroupList">
          {taskGroupList.map(item => <Tile text={item}/>)}
        <Tile text="+"/>
      </div>
    );
  }
  
  export default TaskGroupList;