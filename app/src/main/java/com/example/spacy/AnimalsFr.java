package com.example.spacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AnimalsFr extends AppCompatActivity {
    //initialize variable
    ViewPager2 vpVertical, vpHorizontal;
    private MediaPlayer mMediaPlayer;

    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    int[] images = {R.drawable.cat, R.drawable.cow, R.drawable.dog, R.drawable.elepant
            , R.drawable.fox, R.drawable.giraffe, R.drawable.gorilla, R.drawable.horse, R.drawable.lion, R.drawable.monkey, R.drawable.rabbit, R.drawable.snake};


    int[] vocals = {R.raw.catfr, R.raw.cowfr, R.raw.dogfr, R.raw.elephantfr, R.raw.foxfr, R.raw.girafefr,
            R.raw.gorillafr, R.raw.horsefr, R.raw.lionfr, R.raw.monkeyfr, R.raw.rabitfr, R.raw.snakefr,};

    //Create String array
    String[] Names = {"Chat", "Vache", "Chien", "Elephant", "Renard", "Girafe", "Gorille", "Cheval", "Lion", "Singe", "Lappin", "Serpant",};

    MainAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_fr);
        ImageView im = findViewById(R.id.speakerfrfa);


        //assign variable

        vpHorizontal = findViewById(R.id.vpp_horizontal3fa);

        //initialize main adapter
        adapter = new MainAdapter3(images, Names);

        //set clip padding
        vpHorizontal.setClipToPadding(false);
        //set clip children
        vpHorizontal.setClipChildren(false);
        //set page limit
        vpHorizontal.setOffscreenPageLimit(3);
        //set default start position
        vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //set adapter on horizontal viewpager
        vpHorizontal.setAdapter(adapter);


        //initialize composite page transformer
        CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
        transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float v = 1 - Math.abs(position);
                //set scale y
                page.setScaleY(0.8f + v * 0.2f);
            }
        });
        //set page transform
        vpHorizontal.setPageTransformer(transformer);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(AnimalsFr.this, vocals[vpHorizontal.getCurrentItem()]);

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }


    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
