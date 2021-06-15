package com.example.spacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class AlphabitFr extends AppCompatActivity {
    //initialize variable
    ViewPager vpVertical, vpHorizontal;
    private MediaPlayer mMediaPlayer;
    private adaptervp adaptervpp;
    private ArrayList<aymenmodel> aymenmodelArrayList;
    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };


    int[] vocals = {R.raw.afr, R.raw.bfr, R.raw.cfr, R.raw.dfr, R.raw.efr, R.raw.ffr, R.raw.gfr, R.raw.hfr
            , R.raw.ifr, R.raw.jfr, R.raw.kfr, R.raw.lfr, R.raw.mfr, R.raw.nfr, R.raw.ofr, R.raw.pfr, R.raw.qfr, R.raw.rfr
            , R.raw.sfr, R.raw.tfr, R.raw.ufr, R.raw.vfr, R.raw.wfr, R.raw.xfr, R.raw.yfr, R.raw.zfr,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabit_fr);
        ImageView im = findViewById(R.id.speakerafr);

        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontal1);
        loadcards();
//
//        //initialize main adapter
//        adapter = new MainAdapter2(images);
//
//        //set clip padding
//        vpHorizontal.setClipToPadding(false);
//        //set clip children
//        vpHorizontal.setClipChildren(false);
//        //set page limit
//        vpHorizontal.setOffscreenPageLimit(3);
//        //set default start position
//        vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
//        //set adapter on horizontal viewpager
//        vpHorizontal.setAdapter(adapter);
//
//
//        //initialize composite page transformer
//        CompositePageTransformer transformer = new CompositePageTransformer();
//        //add margin between page
//        transformer.addTransformer(new MarginPageTransformer(8));
//        //increase selected page size
//        transformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float v = 1 - Math.abs(position);
//                //set scale y
//                page.setScaleY(0.8f + v * 0.2f);
//            }
//        });
//        //set page transform
//        vpHorizontal.setPageTransformer(transformer);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(AlphabitFr.this, vocals[vpHorizontal.getCurrentItem()]);

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
    private void loadcards(){

        aymenmodelArrayList=new ArrayList<>();

        aymenmodelArrayList.add(new aymenmodel("",R.drawable.let0a));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.b));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.c));
        aymenmodelArrayList.add(new aymenmodel("", R.drawable.lettd));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.elett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.flett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.glett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.hlett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.ilett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.jlett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.klett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.llett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.mlett));
        aymenmodelArrayList.add(new aymenmodel("", R.drawable.nlett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.olett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.plett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.qlett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.rlett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.slett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.tlett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.ulett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.vlett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.slett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.tlett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.ulett));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.vlett));






        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}