import "../../styles/Header.css"; // CSS dosyasını import ediyoruz
import React from "react";

const Header = () => {
    return (
        <header className="header">
            <div className="header-container">
                <h1 className="logo">MyApp</h1>
                <nav className="nav">
                    <ul className="nav-list">
                        <li className="nav-item"><a href="/">Login</a></li>
                        <li className="nav-item"><a href="/register">Register</a></li>
                        <li className="nav-item"><a href="/user">User</a></li>
                        <li className="nav-item"><a href="/admin">Admin</a></li>

                        <li className="nav-item"><a href="/logout">Logout</a></li>
                    </ul>
                </nav>
            </div>
        </header>
    );
};

export default Header;