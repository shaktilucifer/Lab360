import axios from "axios";
import React, { useEffect, useState } from "react";
import "./PokemonDetail.css";
export function PokemonDetail() {
  let pokemon = {};
  useEffect(() => {
      axios.get('http://localhost:8080/pokemons').then((response) => console.log(response));
    pokemon = {
      pokemonName: "pikachu",
      pokemonType: ["electric", "fairy"],
      hitpoints: 100,
    };
  });
  return (
    <div>
      <div>{pokemon.pokemonName}</div>
      <div>{pokemon.pokemonType}</div>
      <div>{pokemon.hitpoints}</div>
    </div>
  );
}
