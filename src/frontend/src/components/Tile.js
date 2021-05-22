import {DeleteOutlined} from "@ant-design/icons";
import './Tile.css';

function Tile({text, deleteFunction, onClick}) {
    let deleteElementFunction = (event) => {
        console.log(event);
        event.stopPropagation();
        deleteFunction();
    };
    return (
        <div className="Tile" onClick={onClick}>
            <div>{text}
                {deleteFunction != null ?
                    <span className="deleteSpan"><DeleteOutlined onClick={event => deleteElementFunction(event)}/></span>
                    : null
                }
            </div>
        </div>
    );
}

export default Tile;