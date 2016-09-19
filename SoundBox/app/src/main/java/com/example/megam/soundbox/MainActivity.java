package com.example.megam.soundbox;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button playButton;
    private MediaPlayer mediaPlayer;
    private Button prevButton;
    private Button nextButton;
    private TextView text;
    private LinkedList songs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.drake);

        text = (TextView) findViewById(R.id.artistName);

        playButton = (Button) findViewById(R.id.playButton);
        prevButton =(Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        playButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.playButton:
                //play music
                if(mediaPlayer.isPlaying()) {
                    pauseMusic();
                }
                else{
                    playMusic();
                }
                break;
            case R.id.prevButton:
                prevMusic();
                break;
            case R.id.nextButton:
                nextMusic();
                break;
        }
    }

    public void playMusic(){
        if(mediaPlayer != null){
            mediaPlayer.start();
            text.setText("Music Playing!");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));
        }
    }

    public  void pauseMusic(){
        if(mediaPlayer != null){
            mediaPlayer.pause();
            text.setText("Music Paused!");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));
        }
    }

    public void prevMusic(){
        if(mediaPlayer != null){
            mediaPlayer.pause();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(this, R.raw.over);
            playMusic();
        }
    }

    public void nextMusic(){
        if(mediaPlayer != null){
            mediaPlayer.pause();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(this, R.raw.trophies);
            playMusic();
        }
    }

    @Override
    protected void onDestroy(){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }
}
