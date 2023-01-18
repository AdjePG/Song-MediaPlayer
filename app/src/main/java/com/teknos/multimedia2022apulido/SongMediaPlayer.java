package com.teknos.multimedia2022apulido;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.teknos.multimedia2022apulido.entities.Song;
import com.teknos.multimedia2022apulido.singleton.Singleton;

import java.io.IOException;

public class SongMediaPlayer extends AppCompatActivity {

    private ConstraintLayout videoLayout;
    private ConstraintLayout audioLayout;
    private VideoView videoView;
    private ImageView imageView;
    private TextView tvActualPos;
    private TextView tvLengthSong;

    private MediaPlayer mediaPlayer;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_media_player);

        Singleton singleton = Singleton.getInstance();
        Song song = singleton.getSong();

        switch (song.getType()) {
            case 'A':
                audioLayout = (ConstraintLayout) findViewById(R.id.audioLayout);
                imageView = (ImageView) findViewById(R.id.imgvSong);
                tvActualPos = (TextView) findViewById(R.id.tvCurrentPos);
                tvLengthSong = (TextView) findViewById(R.id.tvLengthSong);

                audioLayout.setVisibility(View.VISIBLE);
                imageView.setImageResource(song.getImageResource());
                tvLengthSong.setText(song.getLength());

                mediaPlayer = new MediaPlayer();
                handler = new Handler();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                try {
                    mediaPlayer.setDataSource(getApplicationContext(), song.getSource());
                    mediaPlayer.prepare();
                    handler.postDelayed(UpdateMediaPlayerTime, 1000);
                } catch (IOException e) {
                    //
                }
                break;
            case 'V':
                videoLayout = (ConstraintLayout) findViewById(R.id.videoLayout);
                videoView = (VideoView) findViewById(R.id.videoView);

                videoLayout.setVisibility(View.VISIBLE);
                videoView.setVideoURI(song.getSource());

                MediaController mediaController = new MediaController(this);
                videoView.setMediaController(mediaController);
                break;
        }
    }

    public void btnMediaPlayerControl(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                mediaPlayer.start();
                break;
            case R.id.btnPause:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
                break;
            case R.id.btnStop:
                mediaPlayerStop();
                break;
        }
    }

    private void mediaPlayerStop() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            try {
                mediaPlayer.prepare();
                mediaPlayer.seekTo(0);
            } catch (IOException e) {
                //
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayerStop();
        this.finish();
    }

    private Runnable UpdateMediaPlayerTime = new Runnable() {
        @Override
        public void run() {
            int seconds = (mediaPlayer.getCurrentPosition() / 1000 % 60);
            int minutes = (mediaPlayer.getCurrentPosition() / 1000 / 60) - (seconds / 100);

            String duration = String.format("%02d:%02d" , minutes, seconds);

            tvActualPos.setText(duration);
            handler.postDelayed(this, 1000);
        }
    };
}