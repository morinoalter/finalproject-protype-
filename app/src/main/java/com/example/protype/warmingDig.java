package com.example.protype;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class warmingDig extends AppCompatActivity {
    private AudioManager am;
    private MediaPlayer mp;
    private Button closeDig;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warming);
        am=(AudioManager)getApplicationContext().getSystemService(Context.AUDIO_SERVICE);

        //
        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        am.setStreamVolume(AudioManager.STREAM_MUSIC,7,AudioManager.FLAG_PLAY_SOUND);
        mp=MediaPlayer.create(this,
                              R.raw.music );
        mp.start();

        closeDig=findViewById(R.id.button2);
        closeDig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                      mp.pause();
                      finish();
            }
        });
    }


}
