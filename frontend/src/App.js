import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Admin from "./pages/Admin";
import Login from "./pages/Login";
import Register from "./pages/Register";
import User from "./pages/User";
import Logout from "./pages/Logout";

function App() {
    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/admin" element={<Admin/>}/>
                    <Route path="/" element={<Login/>}/>
                    <Route path="/register" element={<Register/>}/>
                    <Route path="/user" element={<User/>}/>
                    <Route path="/logout" element={<Logout/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;