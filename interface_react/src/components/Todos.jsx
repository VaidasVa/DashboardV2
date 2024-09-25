import {useEffect, useState} from "react";
import sharedStyles from "./CSS/shared.module.css"
import styles from "./CSS/todos.module.css"
import {Checkbox, IconButton, List, ListItem, ListItemText, SpeedDial, SpeedDialAction,TextField} from "@mui/material"
import ModeEditIcon from "@mui/icons-material/ModeEdit"
import SouthIcon from '@mui/icons-material/South';
import EastIcon from '@mui/icons-material/East';
import DeleteOutlineIcon from '@mui/icons-material/DeleteOutline';
import MoreHorizIcon from '@mui/icons-material/MoreHoriz';
import AddIcon from '@mui/icons-material/Add';
import RemoveIcon from '@mui/icons-material/Remove';

export default function Todos() {

    const [todos, setTodos] = useState([]);
    const actions = [
        { icon: <AddIcon />, name: 'Add subtask' },
        { icon: <DeleteOutlineIcon />, name: 'Delete' },
        { icon: <ModeEditIcon />, name: 'Edit' }
    ];
    const [visibility, setVisibility] = useState(false);
    const [selectedToDp, setSelectedToDp] = useState();


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
                setTodos(data.reverse());
            }
            )
            .catch((err) => {
                console.log(err.message);
            });
    }, [])


    // add snackbar on completion
    return (
        <div>
            <div className={sharedStyles.banner}>ToDo List</div>
            <div className={sharedStyles.container}>
                {todos.length > 0 ? (
                    todos.map(todo => (
                        <List className={"styles.todoList"} key={todo.noteId} sx={{ width: '100%', maxWidth: 360, margin: '0', padding: '0' }} >
                            <ListItem id={todo.noteId}
                                      sx={{margin:"-5px 0px", padding:"0"}}
                                secondaryAction={
                                    <div className={styles.secondaryAction}>
                                        <SpeedDial ariaLabel="SpeedDial basic example " icon={<MoreHorizIcon />} direction="left"
                                               aria-setsize={"10px"}
                                        FabProps={{ sx: {width: '40px', height: '40px', bgcolor: 'transparent', boxShadow:"none",
                                                '&:hover': { bgcolor: 'rgba(9, 121, 121, 0.1)' }
                                               }}}>
                                        {actions.map((action, index) => (
                                            <SpeedDialAction
                                                onClick={() => console.log(todo.noteId)}
                                            key={action.name} icon={action.icon} tooltipTitle={action.name}/> ))}
                                    </SpeedDial>
                                    </div>
                                }>

                                {todo.subtasks.length > 0 ? (
                                    <IconButton onClick={() => {
                                        setSelectedToDp("sub"+todo.noteId)
                                        document.getElementById("sub"+todo.noteId).style.display = visibility ? 'none' : 'block';
                                        setVisibility(!visibility)
                                }}>
                                        {visibility ? <EastIcon/> :  <SouthIcon/> }
                                    </IconButton>) : (
                                    <IconButton disabled={true} sx={{color:"rgba(0,0,0,0)"}}>
                                        <RemoveIcon/>
                                    </IconButton>)
                                }

                                <Checkbox />
                                <ListItemText primary={`${todo.todoName}`}  />
                            </ListItem>

                            {todo.subtasks.length > 0 ? (
                                <List className={"styles.subtask"} id={"sub"+todo.noteId}
                                      sx={{padding: "0", margin:"-12px", display: '${visibility}'}}>
                                    {todo.subtasks.map(subtask => (
                                        <ListItem key={subtask.subtaskId} sx={{margin:"-10px", disableGutters:true , padding: "0 90px", display: '${visibility}'}} >
                                            <Checkbox />
                                            <ListItemText primary={subtask.title}  sx={{padding: "0"}} />
                                        </ListItem>
                                    ))}
                                    <IconButton sx={{marginLeft:"80px"}}>
                                        <AddIcon onClick={() => {
                                            setSelectedToDp(todo.noteId)
                                            console.log(selectedToDp);
                                            // let newItem = '<TextField id="standard-basic" label="Standard" variant="standard" />'
                                            // document.getElementById("sub"+todo.noteId).append(newItem);
                                        }}>

                                        </AddIcon></IconButton>
                                </List>
                            ) : null}

                        </List>

                    ))
                ) : (
                    <p>No todos available</p>
                )}
            </div>
        </div>
    );
}