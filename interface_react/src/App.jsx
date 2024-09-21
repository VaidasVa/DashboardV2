import './App.css'
import * as React from "react";
import Box from "@mui/material/Box";
import TabContext from "@mui/lab/TabContext";
import TabList from "@mui/lab/TabList";
import Tab from "@mui/material/Tab";
import DashboardIcon from "@mui/icons-material/Dashboard";
import LanguageIcon from "@mui/icons-material/Language";
import ListAltIcon from "@mui/icons-material/ListAlt";
import {CalendarMonth, EventNote, Feed, WbSunny} from "@mui/icons-material";
import TabPanel from "@mui/lab/TabPanel";
import Links from "./components/Links.jsx";
import Main from "./components/Main.jsx";
import Todos from "./components/Todos.jsx";
import Notes from "./components/Notes.jsx";
import News from "./components/News.jsx";
import Weather from "./components/Weather.jsx";
import Calendar from "./components/Calendar.jsx";


function App() {
    const [value, setValue] = React.useState("dashboard");

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };


    return (
        <React.Fragment>
            <Box sx={{width: '100%', typography: 'body1'}}>
                <TabContext value={value}>
                    <Box sx={{borderBottom: 1, borderColor: 'divider'}}>
                        <TabList onChange={handleChange} aria-label="lab label API tabs example"
                                 centered
                                 inkBarStyle={{background: 'blue'}}
                                 sx={{
                                     backgroundColor: "#f0f0f0", // Change to your desired color
                                 }}>
                            <Tab icon={<DashboardIcon/>} aria-label="dashboard" value="dashboard"/>
                            <Tab icon={<LanguageIcon/>} aria-label="links" value="links"/>
                            <Tab icon={<ListAltIcon/>} aria-label="todos" value="todos"/>
                            <Tab icon={<EventNote/>} aria-label="notes" value="notes"/>
                            <Tab icon={<Feed/>} aria-label="news" value="news"/>
                            <Tab icon={<WbSunny/>} aria-label="weather" value="weather"/>
                            <Tab icon={<CalendarMonth/>} aria-label="calendar" value="calendar"/>
                        </TabList>
                    </Box>
                    <TabPanel value="dashboard"><Main/></TabPanel>
                    <TabPanel value="links"><Links/></TabPanel>
                    <TabPanel value="todos"><Todos/></TabPanel>
                    <TabPanel value="notes"><Notes/></TabPanel>
                    <TabPanel value="news"><News/></TabPanel>
                    <TabPanel value="weather"><Weather/></TabPanel>
                    <TabPanel value="calendar"><Calendar/></TabPanel>

                </TabContext>

            </Box>


        </React.Fragment>
    );
}

export default App
