import React from "react";
import "./Drumblock.css";
import audioMp3 from "./sounds/good-open-hat-sample-a-key-01-Kl9.mp3";
export function DrumBlock({ drumName, drumSound, colorClass }: DrumBlockProps) {
  const playDrum = () => {
    // play sound
    console.log("plau sounds;");
    var music = new Audio(audioMp3);
    music.play();
  };

  return (
    <div>
      <button onClick={playDrum} className={`block ${colorClass}`}>
        {drumName},{drumSound}
      </button>
    </div>
  );
}

interface DrumBlockProps {
  drumName: string;
  drumSound?: string;
  colorClass?: string;
}
