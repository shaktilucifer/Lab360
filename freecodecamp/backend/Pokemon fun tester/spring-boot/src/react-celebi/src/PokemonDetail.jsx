import React, { useEffect, useState } from "react";
import { usePokemonList } from "./hooks/usePokemonList.jsx";
import "./PokemonDetail.css";

export function PokemonDetail() {
  const {pokemons} = usePokemonList();

  useEffect(() => {}, []);
  return (
    <div>
      {pokemons.map((pokemon) => {
        return <div>{pokemon.name}</div>;
      })}
    </div>
  );
}
