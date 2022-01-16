import React from 'react';
import logo from './logo.svg';
import './App.css';
import { DrumBlock } from './DrumBlock';
import { NUM_DRUMS } from './constants/appConstant';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        {
          [...Array(NUM_DRUMS)].map(index => {
              return <DrumBlock key={`drumblock_${index}`}/>
          })
        }
      </header>
    </div>
  );
}

export default App;
