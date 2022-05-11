import React, { useEffect, useState } from "react";
import { usePokemonList } from "./hooks/usePokemonList.jsx";
import "./PokemonDetail.css";
import Card from 'react-bootstrap/Card';
import { usePokemonDetails } from "./hooks/usePokemonDetails.jsx";

export function PokemonDetail({name}) {
  const { pokemons } = usePokemonList();
  const [pokemon, setPokemon] = useState();
  const getPokemonDetail = usePokemonDetails();
  useEffect(() => {
    getPokemonDetail(name)
    .then((response: any) => {
      setPokemon(response);
    });
  }, [name])

  const formatType = (types) => {
     return types.join(', ')
  }

  return (
    <div>
      {pokemons.map((pokemon) => {
        return (
          <Card className="pokemonCard">
            <Card.Body>
                {pokemon.name} ==
                {formatType(pokemon.type)}
                <p>
                HitPoints: {pokemon.hitPoints} - 
                Special Defense: {pokemon.specialDefense} - 
                Defense: {pokemon.defense} - 
                Attack: {pokemon.attack} - 
                Special Attack: {pokemon.specialAttack} - 
                Speed: {pokemon.speed}
                </p>
            </Card.Body>
          </Card>
        );
      })}
    </div>
  );
}
