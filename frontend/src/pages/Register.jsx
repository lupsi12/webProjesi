import React, { useState } from 'react';
import Layout from "../components/Layout/Layout";
import "../styles/Register.css";
import axios from 'axios';
import { useNavigate } from 'react-router-dom';


const Register = () => {

    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        username: '',
        email: '',
        password: '',
        roles: [],
        comments: []
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleRoleChange = (e) => {
        const { options } = e.target;
        const selectedRoles = [];
        for (let i = 0; i < options.length; i++) {
            if (options[i].selected) {
                selectedRoles.push(options[i].value);
            }
        }
        setFormData({
            ...formData,
            roles: selectedRoles
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Form submission logic here
        console.log(formData);

        axios.post("http://localhost:8080/signup", formData)
        .then(response => {
            console.log(response.data);
            // Başarılı kayıt işlemi sonrası yapılacaklar
            alert("Registration successful!");
            navigate("/")
        })
        .catch(error => {
            console.error(error);
            // Hata yönetimi
            alert("Registration failed!");
        });

    };

    return (
        <Layout>
            <div className="registerContainer">
                <h1 className="registerTitle">Register</h1>
                <form className="registerForm" onSubmit={handleSubmit}>
                    <div className="registerFormGroup">
                        <label htmlFor="username">Username:</label>
                        <input
                            type="text"
                            id="username"
                            name="username"
                            value={formData.username}
                            onChange={handleChange}
                            required
                            className="registerInput"
                        />
                    </div>
                    <div className="registerFormGroup">
                        <label htmlFor="email">Email:</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            value={formData.email}
                            onChange={handleChange}
                            required
                            className="registerInput"
                        />
                    </div>
                    <div className="registerFormGroup">
                        <label htmlFor="password">Password:</label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            value={formData.password}
                            onChange={handleChange}
                            required
                            className="registerInput"
                        />
                    </div>
                    <div className="registerFormGroup">
                        <label htmlFor="roles">Roles:</label>
                        <select
                            id="roles"
                            name="roles"
                            multiple
                            value={formData.roles}
                            onChange={handleRoleChange}
                            required
                            className="registerSelect"
                        >
                            <option value="user">User</option>
                            <option value="admin">Admin</option>
                        </select>
                    </div>
                    <button type="submit" className="registerButton">Register</button>
                </form>
            </div>
        </Layout>
    );
};

export default Register;
