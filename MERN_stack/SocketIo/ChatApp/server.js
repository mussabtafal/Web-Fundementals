const express = require('express');
const app = express();

const server = app.listen(8000, () =>
    console.log('The server is all fired up on port 8000')
);

const io = require('socket.io')(server, { cors: true });

io.on("connection", socket => {
    console.log(socket.id);
    console.log("Nice to meet you, Shake Hand ?");
    socket.emit("Greeting", "Hi everyone");

    socket.on("new-client-logon", (data) => {
        console.log(data);
        console.log(data.sender);
        io.emit("message-from-server", { "msgData": data });
    })

    socket.on("new-client-msg", (data) => {
        console.log(data);
        io.emit("message-from-server", { "msgData": data });
    })
})

