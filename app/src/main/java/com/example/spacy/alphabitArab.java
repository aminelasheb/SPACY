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

public class alphabitArab extends AppCompatActivity {
    //initialize variable
    ViewPager2 vpVertical, vpHorizontal;
    int[] images = {R.drawable.alif2021, R.drawable.baa2021, R.drawable.taa2021, R.drawable.ttaa2021,
            R.drawable.jim2021, R.drawable.haa2021, R.drawable.khaa2021, R.drawable.douaa1215, R.drawable.diab56655,
            R.drawable.roro5565, R.drawable.zincvchewiya2332, R.drawable.sin5453, R.drawable.chin254, R.drawable.sad52,
            R.drawable.ddad547, R.drawable.ttta587, R.drawable.dadno545, R.drawable.abass554, R.drawable.ghin455,
            R.drawable.faa5245, R.drawable.kkada54, R.drawable.kahfj56, R.drawable.lala154, R.drawable.mim345,
            R.drawable.haa545, R.drawable.waw5653, R.drawable.yay4665};

    int[] vocals = {R.raw.alif, R.raw.baa, R.raw.taa, R.raw.thaa, R.raw.gim, R.raw.ha, R.raw.khaa,
            R.raw.da, R.raw.dha, R.raw.ra, R.raw.za, R.raw.sin, R.raw.ch, R.raw.sad,
            R.raw.dhae, R.raw.taee, R.raw.dhaad, R.raw.aa, R.raw.gha, R.raw.ff, R.raw.kaaf,
            R.raw.kaaf, R.raw.la, R.raw.mim, R.raw.hae, R.raw.wa, R.raw.ya,};


    MainAdapter2 adapter;
    private MediaPlayer mMediaPlayer;

    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabit_arab);
        ImageView im = findViewById(R.id.speakeraar);

        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontal3);

        //initialize main adapter
        adapter = new MainAdapter2(images);

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

                mMediaPlayer = MediaPlayer.create(alphabitArab.this, vocals[vpHorizontal.getCurrentItem()]);

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