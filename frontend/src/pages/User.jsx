import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Layout from "../components/Layout/Layout";
import "../styles/User.css";
import Cookies from 'js-cookie';
import Divider from '@mui/material/Divider';
import { useNavigate } from 'react-router-dom';

const User = () => {
    const navigate = useNavigate();
    const [users, setUsers] = useState([]);
    const [cookieValue, setCookieValue] = useState('');
    const [commentData, setCommentData] = useState({
        comments: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCommentData({
            ...commentData,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (users.length > 0) {
            const userId = users[0].id;
            axios.patch(`http://localhost:8080/user/${userId}`, commentData)
                .then(response => {
                    console.log(response.data);
                    setUsers([response.data]);
                    alert("Comment successful!");
                    navigate("/user");
                })
                .catch(error => {
                    console.error(error);
                    alert("Comment failed!");
                });
        } else {
            console.error("No user found to update");
        }
    };

    useEffect(() => {
        const value = Cookies.get('email');
        if (value) {
            setCookieValue(value);
        }

        axios.get(`http://localhost:8080/user?email=${value}`)
            .then(response => {
                setUsers(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);

    if (users.length === 0 || users[0].roles[0] !== 'user') {
        return (
            <Layout>
                <div>
                    User not found
                </div>
            </Layout>
        );
    }

    return (
        <Layout>
            <div className="userContainer">
                <h1 className="userTitle">User Information</h1>
                <div className="userList">
                    {users.map((user) => (
                        <div key={user.id} className="userListItem">
                            <p><strong>Username:</strong> {user.username}</p>
                            <p><strong>Email:</strong> {user.email}</p>
                            <p><strong>id:</strong> {user.id}</p>
                            <p><strong>Roles:</strong> {user.roles.join(', ')}</p>
                            {user.comments && user.comments.map((comment, index) => (
                                <div key={index} className="commentContainer">
                                    <p><strong>Comment:</strong> {comment}</p>
                                    <Divider />
                                </div>
                            ))}
                        </div>
                    ))}
                </div>

                <form className="commentForm" onSubmit={handleSubmit}>
                    <div className="commentFormGroup">
                        <label htmlFor="comment">Comment:</label>
                        <input
                            type="text"
                            id="comment"
                            name="comments"
                            value={commentData.comments}
                            onChange={handleChange}
                            required
                            className="commentInput"
                        />
                    </div>
                    <button type="submit" className="commentButton">Comment</button>
                </form>
            </div>
        </Layout>
    );
};

export default User;
