import {useEffect, useState} from "react";
import sharedStyles from "./CSS/shared.module.css"
import app from "../App.jsx";
import cors from "cors"

export default function Todos() {

    const [todos, setTodos] = useState([{
        "noteId":"",
        "todoName": null,
        "completed": false,
        "createdAt": "",
        "updatedAt": "",
        "deletedAt": null,
        "userID": null,
        "parentFolderId": null}]);

    const [folders, setFolders] = useState([])
    //todo get all folders from notes
    // get all folders by ID
    // get all subtasks by Id

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
                getFolders(data)
            }
            )
            .catch((err) => {
                console.log(err.message);
            });
        getFolders()

    }, [])


    function getFolders(todos){

    }

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