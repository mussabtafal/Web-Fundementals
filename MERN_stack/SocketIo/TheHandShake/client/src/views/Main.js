import React, { useState, useEffect } from 'react'
import Chat from '../components/Chat';
import UserForm from '../components/UserForm';
import io from 'socket.io-client';


const Main = () => {
    const [socket] = useState(() => io(':8000'));
    const [messages, setMessages] = useState([]);
    const [user, setUser] = useState(null);

    useEffect(() => {
        socket.on('message-from-server', msg => {
            console.log(msg);
            console.log(messages);
            setMessages(prevMessages => {
                return [...prevMessages, msg.msgData];
            })
        });
        return () => socket.disconnect(true);
    }, []);

    const changeUser = (name) => {
        setUser(name);
    };
    return (
        <>
            {!user && <UserForm changeUser={changeUser} />}
            {user && <Chat user={user} messages={messages} socket={socket} />}
        </>
    );
}

export default Main