import React, { useEffect } from 'react';
import './App.css';
import { PokemonDetail } from './PokemonDetail';
import 'bootstrap/dist/css/bootstrap.min.css';
import { PokemonList } from './PokemonList';

function App() {
  return (
    <div className="App">
        <h2>PokeDex</h2>
        <PokemonDetail />
        <PokemonList />
    </div>
  );
}

export default App;
