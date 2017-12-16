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

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Palabra> phrasesSpanish = new ArrayList<Palabra>();
        phrasesSpanish.add(new Palabra("¿A dónde vas?","minto wuksus", R.raw.phrase_where_are_you_going));
        phrasesSpanish.add(new Palabra("¿Cuál es su nombre?","tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phrasesSpanish.add(new Palabra("Me llamo...","oyaaset...", R.raw.phrase_my_name_is));
        phrasesSpanish.add(new Palabra("¿Cómo te sientes?","michәksәs?", R.raw.phrase_how_are_you_feeling));
        phrasesSpanish.add(new Palabra("Me siento bien.","kuchi achit", R.raw.phrase_im_feeling_good));
        phrasesSpanish.add(new Palabra("¿Vienes?","әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrasesSpanish.add(new Palabra("Si, voy para allá.","hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phrasesSpanish.add(new Palabra("Ya voy.","әәnәm", R.raw.phrase_im_coming));
        phrasesSpanish.add(new Palabra("Vámonos.","yoowutis", R.raw.phrase_lets_go));
        phrasesSpanish.add(new Palabra("Ven aca.","әnni'nem", R.raw.phrase_come_here));

        WordAdapter Adapter = new WordAdapter(this, phrasesSpanish, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, phrasesSpanish.get(position).getPronunciation());
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