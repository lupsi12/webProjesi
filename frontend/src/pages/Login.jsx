import React, { useState } from "react";
import Layout from "../components/Layout/Layout";
import "../Styles/Login.css"; // CSS dosyasını import ediyoruz
import Cookies from 'js-cookie';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = () => {

    const navigate = useNavigate();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = (event) => {
        event.preventDefault();
        // Giriş işlemi burada yapılabilir
        console.log("Username:", username);
        console.log("Password:", password);
        const loginJson = {
            username: username,
            password: password
        }

        axios.post("http://localhost:8080/login", loginJson)
            .then(response => {
                console.log(response.data);
                // Başarılı kayıt işlemi sonrassı yapılacaklar
                alert("Login successful!");
                // Kullanıcı adını çerezlerde sakla
                Cookies.set('email', response.data.email, { expires: 7 }); // 7 gün süreyle saklanır
                if(response.data.roles[0]==="admin")
                    navigate("/admin")
                else if(response.data.roles[0]==="user")
                    navigate("/user")
            })
            .catch(error => {
                console.error(error);
                // Hata yönetimi
                alert("Login failed!");
            });


    };

    return (
        <Layout>
            <div className="login-container">
                <h2>Login</h2>
                <form onSubmit={handleLogin}>
                    <div className="form-group">
                        <label htmlFor="username">Username:</label>
                        <input
                            type="text"
                            id="username"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password:</label>
                        <input
                            type="password"
                            id="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>
                    <button type="submit" className="login-button">Login</button>
                </form>
            </div>
        </Layout>
    );
};

export default Login;