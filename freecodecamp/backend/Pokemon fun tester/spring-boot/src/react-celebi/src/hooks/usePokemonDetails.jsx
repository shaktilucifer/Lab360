import { useCallback } from "react";
import axios from "axios";
import BASE_URL from "../constants/app.conf";
export function usePokemonDetails() {
  return useCallback((pokemonName) =>{
    return axios.get(`${BASE_URL}/pokemon?name=${pokemonName}`);
  })
}
