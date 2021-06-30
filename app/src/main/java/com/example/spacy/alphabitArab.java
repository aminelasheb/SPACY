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

public class alphabitArab extends AppCompatActivity {
    //initialize variable
   ViewPager vpVertical, vpHorizontal;
    private adaptervp adaptervpp1;
    private ArrayList<aymenmodel> aymenmodelArrayList;
    int[] vocals = {R.raw.alifara, R.raw.baaara, R.raw.taaara, R.raw.thaaara, R.raw.jimara, R.raw.haara, R.raw.khaara,
            R.raw.dalara, R.raw.dhalara, R.raw.raaara, R.raw.zayara, R.raw.sinara, R.raw.chineara, R.raw.sadara,
            R.raw.dhaara, R.raw.ttara, R.raw.dhaara, R.raw.ayenara, R.raw.ghayenara, R.raw.faaara, R.raw.kafara,
            R.raw.kafeara, R.raw.lamara, R.raw.mimara, R.raw.nonara,R.raw.haara, R.raw.wawara, R.raw.yaara,};


//    MainAdapter2 adapter;
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
        loadcards();

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
    private void loadcards(){

        aymenmodelArrayList=new ArrayList<>();

        aymenmodelArrayList.add(new aymenmodel("", R.drawable.alif2021));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.baa2021));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.taa2021));
        aymenmodelArrayList.add(new aymenmodel("", R.drawable.ttaa2021));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.jim2021));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.haa2021));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.khaa2021));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.douaa1215));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.diab56655));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.roro5565));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.zincvchewiya2332));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.sin5453));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.chin254));
        aymenmodelArrayList.add(new aymenmodel("", R.drawable.sad52));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.ddad547));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.ttta587));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.dadno545));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.abass554));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.ghin455));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.faa5245));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.kkada54));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.kahfj56));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.lala154));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.mim345));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.naa));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.haap));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.waw5653));
        aymenmodelArrayList.add(new aymenmodel("",R.drawable.yay4665));



        adaptervpp1=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp1);

        vpHorizontal.setPadding(50,400,50,0);

    }
}