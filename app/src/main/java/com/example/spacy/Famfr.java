package com.example.spacy;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Famfr extends AppCompatActivity {//initialize variable
    private ViewPager vpHorizontal;
    private MediaPlayer mMediaPlayer;
    private adaptervp adaptervpp;
    private ArrayList<aymenmodel> aymenmodelArrayList;
    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
  //  int[] images = {R.drawable.grapa,R.drawable.grama,R.drawable.dad,R.drawable.mam,R.drawable.bigbro,
           // R.drawable.sis, R.drawable.baby,R.drawable.ancl,R.drawable.ant,R.drawable.cons};

    int[] vocals = {R.raw.grp2, R.raw.grm2, R.raw.dad2, R.raw.mom2, R.raw.bgb2, R.raw.sis2, R.raw.bbb2, R.raw.ancl2
            , R.raw.ant2, R.raw.csns2};


    //Create String array
   // String[] Names = {"grand-père", "grand-mère" , "papa" ,"maman", "grand-frère", "sœur",
          //  "petit frère", "oncle", "tante", "cousins"};

    //MainAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fam_fr);
        ImageView im = findViewById(R.id.speakerje1);


        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontalje1);

        //initialize main adapter
       // adapter = new MainAdapter3(images, Names);

        //set clip padding
       // vpHorizontal.setClipToPadding(false);
        //set clip children
       // vpHorizontal.setClipChildren(false);
        //set page limit
       // vpHorizontal.setOffscreenPageLimit(3);
        //set default start position
      //  vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //set adapter on horizontal viewpager
       // vpHorizontal.setAdapter(adapter);


        //initialize composite page transformer
       // CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
      //  transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
       // transformer.addTransformer(new ViewPager2.PageTransformer() {
        //    @Override
        //    public void transformPage(@NonNull View page, float position) {
            //    float v = 1 - Math.abs(position);
                //set scale y
             //   page.setScaleY(0.8f + v * 0.2f);
           // }
        //});
        //set page transform
       // vpHorizontal.setPageTransformer(transformer);
        loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(Famfr.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("grand-père",R.drawable.grapa));
        aymenmodelArrayList.add(new aymenmodel("grand-mère",R.drawable.grama));
        aymenmodelArrayList.add(new aymenmodel("papa",R.drawable.dad));
        aymenmodelArrayList.add(new aymenmodel("maman", R.drawable.mam));
        aymenmodelArrayList.add(new aymenmodel("grand-frère",R.drawable.bigbro));
        aymenmodelArrayList.add(new aymenmodel("sœur",R.drawable.sis));
        aymenmodelArrayList.add(new aymenmodel("petit frère",R.drawable.baby));
        aymenmodelArrayList.add(new aymenmodel("oncle",R.drawable.ancl));
        aymenmodelArrayList.add(new aymenmodel("tante",R.drawable.antt));
        aymenmodelArrayList.add(new aymenmodel("cousins",R.drawable.cons));

        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}
