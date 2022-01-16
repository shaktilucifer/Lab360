import React from 'react';
import './Drumblock.css'
export function DrumBlock({drumName, drumSound}: DrumBlockProps) {
    return <div className='block'>{drumName}</div>
}

interface DrumBlockProps {
    drumName: string;
    drumSound?: string;
}