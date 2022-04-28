import React, { useState, useEffect } from 'react';
import axios from 'axios';
import PlayersList from '../components/PlayersList';
import { Link } from 'react-router-dom'


const Main = () => {
    const [players, setPlayers] = useState([]);
    const [loaded, setLoaded] = useState(false)

    useEffect(() => {
        axios
            .get("http://localhost:8000/api/players")
            .then((res) => {
                setPlayers(res.data);
                setLoaded(true);
            })
            .catch((err) => console.log(err));
    }, []);

    const removeFromDom = playerId => {
        setPlayers(players.filter(player => player._id !== playerId));
    }
    return (
        <>
            <Link to="/players">List</Link>
            |
            <Link to="/players/addplayer">Add Player</Link>
            {loaded && <PlayersList players={players} removeFromDom={removeFromDom} />}
        </>
    )
}

export default Main