import React, { useEffect, useState } from "react";
import { usePokemonList } from "./hooks/usePokemonList.jsx";
import "./PokemonDetail.css";
import Card from 'react-bootstrap/Card';

export function PokemonDetail() {
  const { pokemons } = usePokemonList();

  const formatType = (types) => {
     return types.join(', ')
  }

  useEffect(() => {}, []);
  return (
    <div>
      {pokemons.map((pokemon) => {
        return (
          <Card className="pokemonCard">
            <Card.Body>
                {pokemon.name} ==
                {formatType(pokemon.type)}
                <p>{pokemon.hitPoints} - {pokemon.specialDefense} - {pokemon.defense} - {pokemon.attack} - {pokemon.specialAttack} - {pokemon.speed}</p>
            </Card.Body>
          </Card>
        );
      })}
    </div>
  );
}
