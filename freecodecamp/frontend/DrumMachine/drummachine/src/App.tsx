import React from 'react';
import logo from './logo.svg';
import './App.css';
import { DrumBlock } from './DrumBlock';
import { DRUMS, NUM_DRUMS } from './constants/appConstant';

function App() {
  return (
    <div className="App">
      <div className="App-header">
        {
          [...Array(NUM_DRUMS)].map(index => {
              return <DrumBlock drumName={DRUMS[index]?.name || 'DRUM0'} key={`drumblock_${index}`}/>
          })
        }
      </div>
    </div>
  );
}

export default App;
