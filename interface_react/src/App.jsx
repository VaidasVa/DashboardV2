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
import Test from "./components/Test.jsx";


function App() {
    const [value, setValue] = React.useState('1');

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };
    // const secondary = red[500]; // #f44336

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
                    <TabPanel value="dashboard"><Test/></TabPanel>
                    <TabPanel value="links"><Test/></TabPanel>
                    <TabPanel value="todos"><Test/></TabPanel>
                    <TabPanel value="notes"><Test/></TabPanel>
                    <TabPanel value="news"><Test/></TabPanel>
                    <TabPanel value="weather"><Test/></TabPanel>
                    <TabPanel value="calendar"><Test/></TabPanel>

                </TabContext>

            </Box>


        </React.Fragment>
    );
}

export default App
