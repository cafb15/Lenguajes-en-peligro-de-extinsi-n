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

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Palabra> numbersSpanish = new ArrayList<>();
        numbersSpanish.add(new Palabra("Uno","Lutti", R.drawable.number_one, R.raw.number_one));
        numbersSpanish.add(new Palabra("Dos","otiiko", R.drawable.number_two, R.raw.number_two));
        numbersSpanish.add(new Palabra("Tres","tolookosu", R.drawable.number_three, R.raw.number_three));
        numbersSpanish.add(new Palabra("Cuatro","oyyisa", R.drawable.number_four, R.raw.number_four));
        numbersSpanish.add(new Palabra("Cinco","massokka", R.drawable.number_five, R.raw.number_five));
        numbersSpanish.add(new Palabra("Seis","temmokka", R.drawable.number_six, R.raw.number_six));
        numbersSpanish.add(new Palabra("Siete","kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbersSpanish.add(new Palabra("Ocho","kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbersSpanish.add(new Palabra("Nueve","wo’e", R.drawable.number_nine, R.raw.number_nine));
        numbersSpanish.add(new Palabra("Diez","na’aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter Adapter = new WordAdapter(this, numbersSpanish, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, numbersSpanish.get(position).getPronunciation());
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