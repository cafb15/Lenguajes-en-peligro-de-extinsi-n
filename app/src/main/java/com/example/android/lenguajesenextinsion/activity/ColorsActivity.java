package com.example.android.lenguajesenextinsion.activity;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.lenguajesenextinsion.R;
import com.example.android.lenguajesenextinsion.adapter.WordAdapter;
import com.example.android.lenguajesenextinsion.model.Palabra;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Palabra> colorsSpanish = new ArrayList<>();
        colorsSpanish.add(new Palabra("Rojo","weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        colorsSpanish.add(new Palabra("Verde","chokokki", R.drawable.color_green, R.raw.color_green));
        colorsSpanish.add(new Palabra("Marrón","ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        colorsSpanish.add(new Palabra("Gris","ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        colorsSpanish.add(new Palabra("Negro","kululli", R.drawable.color_black, R.raw.color_black));
        colorsSpanish.add(new Palabra("Blanco","kelelli", R.drawable.color_white, R.raw.color_white));
        colorsSpanish.add(new Palabra("Polvo de color amarillo","ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsSpanish.add(new Palabra("Amarillo mostaza","chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter Adapter = new WordAdapter(this, colorsSpanish, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, colorsSpanish.get(position).getPronunciation());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(completionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}