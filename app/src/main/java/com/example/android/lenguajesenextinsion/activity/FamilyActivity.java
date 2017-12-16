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

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Palabra> familySpanish = new ArrayList<Palabra>();
        familySpanish.add(new Palabra("Padre","әpә", R.drawable.family_father, R.raw.family_father));
        familySpanish.add(new Palabra("Madre","әṭa", R.drawable.family_mother, R.raw.family_mother));
        familySpanish.add(new Palabra("Hijo","angsi", R.drawable.family_son, R.raw.family_son));
        familySpanish.add(new Palabra("Hija","tune", R.drawable.family_son, R.raw.family_daughter));
        familySpanish.add(new Palabra("Hermano mayor","taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        familySpanish.add(new Palabra("Hermano menor","chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familySpanish.add(new Palabra("Hermana mayor","teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        familySpanish.add(new Palabra("Hermana menor","kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familySpanish.add(new Palabra("Abuela","ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        familySpanish.add(new Palabra("Abuelo","paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter Adapter = new WordAdapter(this, familySpanish, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, familySpanish.get(position).getPronunciation());
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