import { useEffect, useState } from "react";
import axios from "axios";
import BASE_URL from "../constants/app.conf";
export function usePokemonList() {
  const [pokemons, setPokemons] = useState([]);
  useEffect(() => {
    axios.get(`${BASE_URL}/pokemons`).then((response) => {
      setPokemons(response.data);
    });
  }, []);

  return {
    pokemons
  };
}
