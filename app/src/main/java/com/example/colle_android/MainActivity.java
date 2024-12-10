package com.example.colle_android;

import android.os.Bundle;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButton(R.id.buttonA, R.raw.note_a);
        setupButton(R.id.buttonB, R.raw.note_b);
        setupButton(R.id.buttonC, R.raw.note_c);
        setupButton(R.id.buttonD, R.raw.note_d);
        setupButton(R.id.buttonE, R.raw.note_e);
        setupButton(R.id.buttonF, R.raw.note_f);
        setupButton(R.id.buttonG, R.raw.note_g);

    }

    private void setupButton(int buttonId, int soundResId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> playSound(soundResId));
    }

    private void playSound(int soundResId) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, soundResId);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
