import goodOpenHat from '../sounds/good_open_hat.mp3';
import sharpOpenHat from '../sounds/sharp_open_hat.mp3';
import subtleHiHat from '../sounds/subtle_hi_hat.mp3';

export const NUM_DRUMS = 6;

export enum DRUM_COLORS {
    WISTERIA = 'wisteria', 
    MIDNIGHT = 'midnight-blue',
    BELIZE = 'belize',
}

export const DRUMS = [
    {name: 'drum1', color: DRUM_COLORS.BELIZE, audio: goodOpenHat},
    {name: 'drum2', color: DRUM_COLORS.MIDNIGHT, audio: sharpOpenHat},
    {name: 'drum3', color: DRUM_COLORS.WISTERIA, audio: subtleHiHat}, 
    {name: 'drum4', color: DRUM_COLORS.MIDNIGHT, audio: sharpOpenHat},
    {name: 'drum5', color: DRUM_COLORS.WISTERIA, audio: subtleHiHat},
    {name: 'drum6', color: DRUM_COLORS.BELIZE, audio: goodOpenHat}
]

