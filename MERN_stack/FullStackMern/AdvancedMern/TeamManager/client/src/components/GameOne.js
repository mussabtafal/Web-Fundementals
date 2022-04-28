import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Button from '@mui/material/Button'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Link } from 'react-router-dom';

const GameOne = (props) => {
    const [players, setPlayers] = useState([]);


    useEffect(() => {
        axios
            .get("http://localhost:8000/api/players")
            .then((res) => {
                setPlayers(res.data);
            })
            .catch((err) => console.log(err));
    }, []);

    const statusUpdate = (player, i, status) => {
        let updatedPlayer = {};
        updatedPlayer = { ...player, gameOne: status };
        axios
            .put(`http://localhost:8000/api/players/${player._id}`, updatedPlayer)
            .then((res) => {
                updatePlayerInDom(i, status);
                console.log(res);
            })
            .catch((err) => {
                console.error(err);
            });
    };
    const updatePlayerInDom = (i, status) => {
        let playerToChange = players[i];
        playerToChange.gameOne = status;
        const newPlayers = [...players];
        newPlayers[i] = playerToChange;
        setPlayers(newPlayers);
    };
    return (
        <div>
            <Link to="/status/game1">
                Game 1
            </Link>
            |
            <Link to="/status/game2">
                Game 2
            </Link>
            |
            <Link to="/status/game3">
                Game 3
            </Link>
            <TableContainer component={Paper}>
                <Table sx={{ maxWidth: 800, margin: "20px auto" }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>Player Name</TableCell>
                            <TableCell align="center">Action</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {players.map((player, idx) => (
                            <TableRow
                                key={idx}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell component="th" scope="row">{player.name}</TableCell>
                                <TableCell align="right">
                                    <Button onClick={() => statusUpdate(player, idx, "playing")} variant={
                                        player.gameOne === "playing"
                                            ? "contained"
                                            : "outlined"
                                    } color="success">Playing</Button>
                                    <Button onClick={() => statusUpdate(player, idx, "notplaying")} variant={
                                        player.gameOne === "notplaying"
                                            ? "contained"
                                            : "outlined"
                                    } color="error" >Not Playing</Button>
                                    <Button onClick={() => statusUpdate(player, idx, "undecided")} variant={
                                        player.gameOne === "undecided"
                                            ? "contained"
                                            : "outlined"
                                    } color="warning" >Undecided</Button>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </div>
    )
}

export default GameOne;