import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Cookies from 'js-cookie';

const Logout = () => {
    const navigate = useNavigate();

    useEffect(() => {
        // Çerezleri temizle
        Cookies.remove('email');

        // Giriş sayfasına yönlendir
        navigate("/");
    }, [navigate]);

    return (
        <div>
            <h2>Logging out...</h2>
        </div>
    );
};

export default Logout;
