import {DeleteOutlined} from "@ant-design/icons";
import './Tile.css';

function Tile({text, deleteFunction}) {
    return (
        <div className="Tile">
            <div>{text}
                {deleteFunction != null ?
                    <span className="deleteSpan"><DeleteOutlined onClick={deleteFunction}/></span>
                    : null
                }
            </div>
        </div>
    );
}

export default Tile;