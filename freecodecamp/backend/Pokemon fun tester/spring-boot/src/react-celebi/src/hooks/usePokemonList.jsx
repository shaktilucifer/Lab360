import { useMemo, useEffect, useState } from "react";
import axios from "axios";

export function usePokemonList() {
  const [pokemons, setPokemons] = useState([]);
  useEffect(() => {
    axios.get("http://localhost:8080/pokemons").then((response) => {
      setPokemons(response.data);
    });
  }, []);

  return {
    pokemons
  };
}
