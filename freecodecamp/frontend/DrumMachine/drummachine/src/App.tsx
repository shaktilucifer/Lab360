import React from 'react';
import './App.css';
import { DrumBlock } from './DrumBlock';
import { Drums, DRUMS, NUM_DRUMS } from './constants/appConstant';

function App() {
  return (
    <div className="App">
      <div className="App-header">
        {
          DRUMS.map((value: Drums, index) => {
            if (index > NUM_DRUMS) {
              return false;
            }
              return (<><DrumBlock drumSound={value.audio} colorClass={value.color} drumName={value.name} key={`drumblock_${index}_${value}`}/></>)
          })
        }
      </div>
    </div>
  );
}

export default App;
