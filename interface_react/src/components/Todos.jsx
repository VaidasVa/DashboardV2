import {useState} from "react";
import sharedStyles from "./CSS/shared.module.css"

export default function Todos() {

    const [todos, setTodos] = useState([]);

    return (
        <>
            <div className={sharedStyles.banner}>ToDo List</div>
            <div className={sharedStyles.container}>

                Todos page
            </div>
        </>
    )
}