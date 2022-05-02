import axios from "axios";
import React, { useEffect, useState } from "react";
import "./PokemonDetail.css";
export function PokemonDetail() {
    const [pokemons, setPokemons] = useState([]);
    useEffect(() => {
      axios.get('http://localhost:8080/pokemons').then((response) => {
          setPokemons(response.data);
      });
  }, []);
  return (
    <div>
        {pokemons.map((pokemon)=> {
            return <div>{pokemon.name}</div>
        })}
    </div>
  );
}
