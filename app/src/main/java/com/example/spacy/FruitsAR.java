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

public class FruitsAR extends AppCompatActivity {
    //initialize variable
    ViewPager2 vpVertical, vpHorizontal;
    private MediaPlayer mMediaPlayer;

    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) { releaseMediaPlayer();}
    };
    int[] images = {R.drawable.datte, R.drawable.ananas, R.drawable.cerise, R.drawable.citron, R.drawable.figue, R.drawable.fraise, R.drawable.bannane,
                   R.drawable.grenade,R.drawable.abricot, R.drawable.orangee , R.drawable.peche,R.drawable.pomme, R.drawable.raisin, R.drawable.pastheque};

    int[] vocals =  {R.raw.dattear, R.raw.ananasar, R.raw.cerisear, R.raw.citronar, R.raw.figuear, R.raw.fraisear, R.raw.mawza,
            R.raw.grenadear, R.raw.mechmech, R.raw.orangear ,R.raw.khoukh, R.raw.pommear,R.raw.raisinar,  R.raw.pasthequear};

    String[] Names ={"تمر","أناناس","كرز","ليمون","تين","فراولة"," موز","رمان","مشمش","برتقال","خوخ"," تفاح","عنب","بطيخ"};

    MainAdapter5 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_ar);
        ImageView im = findViewById(R.id.speakerfruitar);

        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontalfr);

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

                mMediaPlayer = MediaPlayer.create(FruitsAR.this, vocals[vpHorizontal.getCurrentItem()]);

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
