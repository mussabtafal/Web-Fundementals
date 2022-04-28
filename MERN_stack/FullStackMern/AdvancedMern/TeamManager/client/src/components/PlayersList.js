import React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import DeleteButton from '../components/DeleteButton';

const PlayersList = (props) => {


    return (
        <div>
            <TableContainer component={Paper}>
                <Table sx={{ maxWidth: 800, margin: "20px auto" }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>Player Name</TableCell>
                            <TableCell align="right">Position</TableCell>
                            <TableCell align="right">Action</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {props.players.map((player, idx) => (
                            <TableRow
                                key={idx}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell component="th" scope="row">{player.name}</TableCell>
                                <TableCell align="right">{player.position}</TableCell>
                                <TableCell align="right"><DeleteButton playerId={player._id} playerName={player.name} successCallBack={() => props.removeFromDom(player._id)} /></TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </div>
    )
}

export default PlayersList