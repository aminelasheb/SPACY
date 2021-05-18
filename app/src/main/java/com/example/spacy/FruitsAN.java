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

public class FruitsAN  extends AppCompatActivity {
    //initialize variable
    ViewPager2 vpVertical, vpHorizontal;
    private MediaPlayer mMediaPlayer;

    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) { releaseMediaPlayer();}
    };
    int[] images = {R.drawable.abricot, R.drawable.pomme, R.drawable.bannane, R.drawable.cerise, R.drawable.figue, R.drawable.kiwi, R.drawable.mangue, R.drawable.melon, R.drawable.orangee, R.drawable.poire, R.drawable.peche, R.drawable.ananas,
            R.drawable.grenade, R.drawable.raisin, R.drawable.fraise, R.drawable.pastheque};

    int[] vocals = {R.raw.abricotan, R.raw.apple, R.raw.bannanean, R.raw.cerisean, R.raw.figan,
            R.raw.kiwian, R.raw.mango, R.raw.melonan, R.raw.orangean, R.raw.pear, R.raw.peech, R.raw.pineapple, R.raw.pomegranarte,
            R.raw.raisingrabes, R.raw.strawberry, R.raw.watermelon};

    String[] Names = {"Apricot", "Apple", "Banana", "Cherry", "Fig", "Kiwi", "Mango", "Melon", "Orange", "Pear", "Peach", "Pineapple", "Pomegranate", "Grape",
            "Strawberry", "Watermelon"};

    MainAdapter5 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_an);
        ImageView im = findViewById(R.id.speakerfruitan);

        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontalfag);

        //initialize main adapter
        adapter = new MainAdapter5(images, Names);

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

                mMediaPlayer = MediaPlayer.create(FruitsAN.this, vocals[vpHorizontal.getCurrentItem()]);

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
