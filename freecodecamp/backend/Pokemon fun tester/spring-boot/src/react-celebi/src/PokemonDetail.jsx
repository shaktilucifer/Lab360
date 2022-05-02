import axios from "axios";
import React, { useEffect, useState } from "react";
import "./PokemonDetail.css";
export function PokemonDetail() {
  const pokemon = {};
  useEffect(() => {
    //   axios.get('')
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
