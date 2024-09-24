import {useEffect, useState} from "react";
import sharedStyles from "./CSS/shared.module.css"
import styles from "./CSS/todos.module.css"
import Accordion from '@mui/material/Accordion';
import AccordionActions from '@mui/material/AccordionActions';
import AccordionSummary from '@mui/material/AccordionSummary';
import AccordionDetails from '@mui/material/AccordionDetails';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import Button from '@mui/material/Button';

export default function Todos() {

    const [todos, setTodos] = useState([]);

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
            }
            )
            .catch((err) => {
                console.log(err.message);
            });
    }, [])

    return (
<div>
            <div className={sharedStyles.banner}>ToDo List</div>
            <div className={sharedStyles.container}>
               {todos.length > 0 ? (
                    todos.map(todo => (
                        <Accordion key={todo.noteId} className={"styles.accordion"}>
                            <AccordionSummary expandIcon={<ExpandMoreIcon />} id={todo.noteId}>
                                {todo.todoName}
                            </AccordionSummary>
                            <AccordionDetails>
                                {todo.subtasks.length > 0 ? (
                                    <div>
                                        <p>Subtasks:</p>
                                        <ul>
                                            {todo.subtasks.map(subtask => (
                                                <li key={subtask.subtaskId}>{subtask.title}</li>
                                            ))}
                                        </ul>
                                    </div>
                                ) : (
                                    <p>No Subtasks</p>
                                )}
                            </AccordionDetails>
                        </Accordion>
                    ))
                ) : (
                    <p>No todos available</p>
                )
                }
            </div>
</div>
    )
}