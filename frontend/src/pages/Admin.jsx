import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Layout from "../components/Layout/Layout";
import "../Styles/Admin.css";
import Cookies from 'js-cookie';

const Admin = () => {
    const [admin, setAdmin] = useState([]);
    const [users, setUsers] = useState([]);
    const [showAdminDetails, setShowAdminDetails] = useState(false);
    const [cookieValue, setCookieValue] = useState('');

    useEffect(() => {
        const value = Cookies.get('email');
        if (value) {
            setCookieValue(value);
        }

        axios.get("http://localhost:8080/user?email=" + value)
            .then(response => {
                setAdmin(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);

    const fetchUsers = () => {
        axios.get("http://localhost:8080/user", { withCredentials: true })
            .then(response => {
                setUsers(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    };

    const handleAdminClick = () => {
        setShowAdminDetails(true);
        fetchUsers();
    };
    if (admin.length === 0  || admin[0].roles[0] !== 'admin') {
        return (
            <Layout>
                <div>
                    admin not found
                </div>
            </Layout>
        ); // Eğer admin bilgisi yoksa veya admin rolü "admin" değilse bileşeni gösterme
    }
    return (
        <Layout>
            <div className="adminContainer">
                <h1 className="adminTitle" onClick={handleAdminClick} style={{ cursor: 'pointer' }}>
                    Admin Information
                </h1>
                {showAdminDetails && (
                    <>
                        {admin.length > 0 ? (
                                admin.map((admin) => (
                                    <div key={admin.id} className="userListItem">
                                        <p><strong>Username:</strong> {admin.username}</p>
                                        <p><strong>Email:</strong> {admin.email}</p>
                                        <p><strong>ID:</strong> {admin.id}</p>
                                        <p><strong>Roles:</strong> {admin.roles.join(', ')}</p>
                                        {}
                                    </div>
                                ))
                            ) : (
                                <p>Loading admin ...</p>
                            )}




                        <h2 className="userListTitle">User List</h2>
                        <div className="userList">
                           
                            {((admin.length>0) && (users.length > 0)) ? (
                                users.map((user) => (
                                    <div key={user.id} className="userListItem">
                                        <p><strong>Username:</strong> {user.username}</p>
                                        <p><strong>Email:</strong> {user.email}</p>
                                        <p><strong>ID:</strong> {user.id}</p>
                                        <p><strong>Roles:</strong> {user.roles.join(', ')}</p>
                                        {}
                                    </div>
                                ))
                            ) : (
                                <p>Loading user list...</p>
                            )}
                        
                        </div>
                    </>
                )}
                
            </div>
        </Layout>
    );
};

export default Admin;
