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

public class ColorsFr extends AppCompatActivity {
    //initialize variable
    ViewPager2 vpVertical, vpHorizontal;
    private MediaPlayer mMediaPlayer;

    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    int[] images = {R.drawable.black, R.drawable.white, R.drawable.yellow
            , R.drawable.violet, R.drawable.red, R.drawable.pink, R.drawable.pink, R.drawable.green, R.drawable.brown, R.drawable.bleu, R.drawable.orange};


    int[] vocals = {R.raw.noir, R.raw.blanc, R.raw.jaune, R.raw.violet, R.raw.rouge,
            R.raw.rose, R.raw.gris, R.raw.vert, R.raw.marron, R.raw.bleufr, R.raw.orangeee};

    //Create String array
    String[] Names = {"Noir", "Blanc", "Jaune", "Violet", "Rouge", "Rose", "Gris", "Vert", "Marron", "Bleu", "Orange"};

    MainAdapter4 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_fr);
        ImageView im = findViewById(R.id.speakercouleur);


        //assign variable

        vpHorizontal = findViewById(R.id.vpp_horizontalll3);

        //initialize main adapter
        adapter = new MainAdapter4(images, Names);

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

                mMediaPlayer = MediaPlayer.create(ColorsFr.this, vocals[vpHorizontal.getCurrentItem()]);

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
