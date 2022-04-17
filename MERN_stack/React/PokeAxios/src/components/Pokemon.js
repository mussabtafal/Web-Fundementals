import React, {useState} from 'react'
import axios from 'axios';

const Pokemon = () => {
    const [pokemons, setPokemons] = useState([])
    const listPokemons = () => {
        axios
        .get('https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0')
        .then(response=>{setPokemons(response.data.results)})
    }
  return (
    <div>
        <button onClick={listPokemons}>Fetch Pokemons</button>
        <ul>
            {pokemons
              ? pokemons.map((pokemon, i) => <li key={i}>{pokemon.name}</li>)
              : ""}
          </ul>
    </div>
  )
}

export default Pokemon