import React, { useEffect, useState } from 'react';



const Pokemon = (props) => {
    const [pokemon, setPokemon] = useState([]);

    useEffect(() => {
        fetch('https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0')
            .then(response => response.json())
            .then(response => setPokemon(response.results))
    }, []);

    return (
        <div>
            {pokemon.length > 0 && pokemon.map((pokemon, index) => {
                return (<div key={index}>{pokemon.name}</div>)
            })}
        </div>
    );
}
export default Pokemon;