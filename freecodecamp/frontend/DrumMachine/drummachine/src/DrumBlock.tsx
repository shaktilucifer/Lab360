import React from 'react';
import './Drumblock.css'
export function DrumBlock({drumName, drumSound, colorClass}: DrumBlockProps) {

    const playDrum = () => {
        // play sound
    }

    return (<>
    <button onClick={() => playDrum} className={`block ${colorClass}`}>{drumName},{drumSound}</button>
    </>);
}

interface DrumBlockProps {
    drumName: string;
    drumSound?: string;
    colorClass?: string;
}