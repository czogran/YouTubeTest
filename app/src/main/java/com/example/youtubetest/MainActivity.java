package com.example.youtubetest;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;

public class MainActivity extends YouTubeBaseActivity {

    private static final String TAG = "MyActivity";
    YouTubePlayerView mYouTubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mInitializationListener;
    YouTubePlayer.OnInitializedListener mOnIninitializationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"START");

        btnPlay=(Button) findViewById(R.id.button);
        mYouTubePlayerView=(YouTubePlayerView) findViewById(R.id.test);

        mOnIninitializationListener= new YouTubePlayer.OnInitializedListener()
        {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                btnPlay.setText("PLAY");
                youTubePlayer.loadVideo("W4hTJybfU7s");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                btnPlay.setText("porazka");
                Log.d(TAG,"porazka playing");
            }
        };
    btnPlay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG,"start playing");
            mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(),mOnIninitializationListener);
        }
    });
    }


}
