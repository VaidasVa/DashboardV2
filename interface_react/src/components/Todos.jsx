import {useEffect, useState} from "react";
import sharedStyles from "./CSS/shared.module.css"
import app from "../App.jsx";
import cors from "cors"

export default function Todos() {

    const [todos, setTodos] = useState([]);
    const corsOptions = {
        origin: "http://localhost:8089"
    };

    Todos.use(cors(corsOptions));

    useEffect(() => {
        fetch("http://localhost:8089/api/v1/todos/", {
            method: "get",
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then((data) => data.json())
            .then((data) => {
                console.log(data);
                setTodos(data);
            })
            .catch((err) => {
                console.log(err.message);
            });
    }, [])

    return (
        <>
            <div className={sharedStyles.banner}>ToDo List</div>
            <div className={sharedStyles.container}>

                Todos page

                <div>

                </div>
            </div>
        </>
    )
}