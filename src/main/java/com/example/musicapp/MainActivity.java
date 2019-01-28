package com.example.musicapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int CurrentPausePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pause = (Button) findViewById(R.id.btn_pause);
        play =  (Button) findViewById(R.id.btn_play);
        stop =   (Button) findViewById(R.id.btn_stop);

        pause.setOnClickListener(this);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btn_pause:
                if(mediaPlayer!=null){
                    mediaPlayer.pause();
                    CurrentPausePosition=mediaPlayer.getCurrentPosition();
                }

                break;

            case R.id.btn_play:
                if(mediaPlayer==null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ringtone);
                    mediaPlayer.start();
                }

                else if(mediaPlayer!=null){
                    mediaPlayer.seekTo(CurrentPausePosition);
                    mediaPlayer.start();
                }
                break;

            case R.id.btn_stop:
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }
                break;
        }
    }
}
