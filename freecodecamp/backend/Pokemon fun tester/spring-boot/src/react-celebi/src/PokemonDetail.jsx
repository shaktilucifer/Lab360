import React, { useEffect } from 'react';
import ReactAudioPlayer from 'react-audio-player';
import ReactPlayer from 'react-player'
import {Howl, Howler} from 'howler';
import { Media, Player, controls, utils } from 'react-media-player'
const {
  PlayPause,
  CurrentTime,
  Progress,
  SeekBar,
  Duration,
  MuteUnmute,
  Volume,
  Fullscreen,
} = controls
const { keyboardControls } = utils
export function PokemonDetail() {
    useEffect(() => {
        console.log('useeffect');

    }, [])
    return (
    <div>
         <audio
        controls
        src="">
            Your browser does not support the
            <code>audio</code> element.
    </audio>
    <ReactAudioPlayer
  src="my_audio_file.ogg"
  autoPlay
  controls
/>
<Media>
        {mediaProps => (
          <div
            className="media"
            onKeyDown={keyboardControls.bind(null, mediaProps)}
          >
            <Player src="" className="media-player" />
            <div className="media-controls">
              <PlayPause />
              <CurrentTime />
              <SeekBar />
              <Duration />
              <MuteUnmute />
              <Volume />
              <Fullscreen />
            </div>
          </div>
        )}
      </Media>
</div>);
}