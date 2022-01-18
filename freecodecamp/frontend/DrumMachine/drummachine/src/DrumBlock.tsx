import React from 'react';
import './Drumblock.css'
export function DrumBlock({drumName, drumSound, colorClass}: DrumBlockProps) {
    return <div className='block'>{drumName},{drumSound}</div>
}

interface DrumBlockProps {
    drumName: string;
    drumSound?: string;
    colorClass?: string;
}