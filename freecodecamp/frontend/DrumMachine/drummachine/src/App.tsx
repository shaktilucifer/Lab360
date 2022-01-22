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
          [...Array(NUM_DRUMS)].map((value, index) => {
              return (<><DrumBlock drumSound={DRUMS[index].audio} colorClass={DRUMS[index]?.color} drumName={DRUMS[index]?.name || 'DRUM0'} key={`drumblock_${index}_${value}`}/></>)
          })
        }
      </div>
    </div>
  );
}

export default App;
