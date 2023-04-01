package hcmute.edu.vn.mediaplayer.TranQuocTuan20110595;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create an instance of MediaPlayer for audio playback
        final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);

        // register all the buttons using their appropriate IDs
        Button bPlay = findViewById(R.id.playButton);
        Button bPause = findViewById(R.id.pauseButton);
        Button bStop = findViewById(R.id.stopButton);

        // handle the start button to start the audio playback
        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start method is used to start playing the audio file
                mediaPlayer.start();
            }
        });

        // handle the pause button to put the MediaPlayer instance at the Pause state
        bPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pause() method can be used to pause the MediaPlayer instance
                mediaPlayer.pause();
            }
        });

        // handle the stop button to stop playing and prepare the MediaPlayer instance
        // for the next instance of play
        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stop() method is used to completely stop playing the MediaPlayer instance
                mediaPlayer.stop();

                // after stopping the MediaPlayer instance it is again need to be prepared for the next instance of playback
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}