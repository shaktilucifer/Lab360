import React, { useEffect } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import { PokemonDetail } from './PokemonDetail';


function App() {
  return (
    <div className="App">
        <h2>App Test</h2>
        <PokemonDetail />
    </div>
  );
}

export default App;
