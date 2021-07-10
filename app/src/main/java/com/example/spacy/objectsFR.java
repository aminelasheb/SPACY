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

public class objectsFR extends AppCompatActivity {
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
//    int[] images = {R.drawable.backpack, R.drawable.chair, R.drawable.drum
//            , R.drawable.hammer, R.drawable.pillow, R.drawable.pc, R.drawable.bed, R.drawable.clock, R.drawable.book, R.drawable.ball, R.drawable.keys, R.drawable.shoes};


    int[] vocals = {R.raw.sacados, R.raw.chaise, R.raw.batterie, R.raw.marteau, R.raw.oreiller, R.raw.ordinateur, R.raw.lit, R.raw.horloge, R.raw.livres, R.raw.ballon, R.raw.cles, R.raw.chaussure
    };

    //Create String array
//    String[] Names = {"Sac a dos", "chaise", "batterie", "marteau", "oreiller", "ordinateur", "lit", "horloge", "livre", "ballon", "clés", "chaussure"};
//
//    MainAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objects_f_r);


        ImageView im = findViewById(R.id.speakerf);


        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontal2f);

//        //initialize main adapter
//        adapter = new MainAdapter3(images, Names);
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
loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(objectsFR.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("Sacados",R.drawable.backpack));
        aymenmodelArrayList.add(new aymenmodel("Chaise",R.drawable.chair));
        aymenmodelArrayList.add(new aymenmodel("Tambours",R.drawable.drum));
        aymenmodelArrayList.add(new aymenmodel("Marteau", R.drawable.hammer));
        aymenmodelArrayList.add(new aymenmodel("Oreiller",R.drawable.pillow));
        aymenmodelArrayList.add(new aymenmodel("L'ordinateur",R.drawable.pc));
        aymenmodelArrayList.add(new aymenmodel("Lit",R.drawable.bed));
        aymenmodelArrayList.add(new aymenmodel("L'horloge",R.drawable.clock));
        aymenmodelArrayList.add(new aymenmodel("Livre",R.drawable.book));
        aymenmodelArrayList.add(new aymenmodel("Balle",R.drawable.ball));
        aymenmodelArrayList.add(new aymenmodel("Clés",R.drawable.keys));
        aymenmodelArrayList.add(new aymenmodel("Chaussures",R.drawable.shoes));



        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}