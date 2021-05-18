package com.example.spacy;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

public class  Jobsar extends AppCompatActivity {//initialize variable
    ViewPager2 vpVertical, vpHorizontal;
    private MediaPlayer mMediaPlayer;

    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    int[] images = {R.drawable.astronome,R.drawable.doctor,R.drawable.infirmiere,R.drawable.prof,R.drawable.policier,
            R.drawable.pompier, R.drawable.architecte,R.drawable.macon,R.drawable.bucheron,R.drawable.chef,
            R.drawable.coiffeur,R.drawable.facteur, R.drawable.agriculteur,R.drawable.pecheur};

    int[] vocals = {R.raw.arbas, R.raw.ardoc, R.raw.armom, R.raw.armm3, R.raw.plc3, R.raw.pmp3, R.raw.arc3, R.raw.mc3
            , R.raw.hatt3, R.raw.khob, R.raw.hala9, R.raw.fac3, R.raw.falh, R.raw.say};


    //Create String array
    String[] Names = {"عالم فضاء", "طبيب" , "ممرضة", "معلم", "شرطي", "رجل اطفاء",
            "مهندس معماري", "بناء","حطاب", "طباخ", "حلاق", "ساعي بريد","فلاح", "صياد"};

    MainAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs_ar);
        ImageView im = findViewById(R.id.speakerj3);


        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontalj3);

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

                mMediaPlayer = MediaPlayer.create(Jobsar.this, vocals[vpHorizontal.getCurrentItem()]);

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


