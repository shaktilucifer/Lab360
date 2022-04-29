import React, { useEffect } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';


function App() {

  useEffect(() => {
    axios.get('localhost:8080/pokemons').then((response) => console.log(response)).catch((error) => console.log(error));9
  }, []); 

  return (
    <div className="App">
        <h2>App Test</h2>
    </div>
  );
}

export default App;
