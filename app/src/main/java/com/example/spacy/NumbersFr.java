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

public class NumbersFr extends AppCompatActivity {
    //initialize variable
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
   // int[] images = {R.drawable.zero, R.drawable.one, R.drawable.two, R.drawable.threee
        //    , R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten};


    int[] vocals = {R.raw.f00, R.raw.f01, R.raw.f02, R.raw.f03, R.raw.f04, R.raw.f05, R.raw.f06, R.raw.f07
            , R.raw.f08, R.raw.f09, R.raw.f10};

    //Create String array
    //String[] Names = {"Zéro", "Un", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix"};

   // MainAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbersfr);
        ImageView im = findViewById(R.id.speakerfr);


        //assign variable

        vpHorizontal = findViewById(R.id.vpp_horizontal3);

        //initialize main adapter
     //   adapter = new MainAdapter3(images, Names);

        //set clip padding
      // vpHorizontal.setClipToPadding(false);
        //set clip children
       // vpHorizontal.setClipChildren(false);
        //set page limit
       // vpHorizontal.setOffscreenPageLimit(3);
        //set default start position
       // vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //set adapter on horizontal viewpager
       // vpHorizontal.setAdapter(adapter);


        //initialize composite page transformer
      //  CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
       // transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
       // transformer.addTransformer(new ViewPager2.PageTransformer() {
        //    @Override
          //  public void transformPage(@NonNull View page, float position) {
           //     float v = 1 - Math.abs(position);
                //set scale y
             //   page.setScaleY(0.8f + v * 0.2f);
           // }
        //});
      //  //set page transform
      //  vpHorizontal.setPageTransformer(transformer);
        loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(NumbersFr.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("Zéro",R.drawable.zero));
        aymenmodelArrayList.add(new aymenmodel("Un",R.drawable.one));
        aymenmodelArrayList.add(new aymenmodel("Deux",R.drawable.two));
        aymenmodelArrayList.add(new aymenmodel("Trois", R.drawable.threee));
        aymenmodelArrayList.add(new aymenmodel("Quatre",R.drawable.four));
        aymenmodelArrayList.add(new aymenmodel("Cinq",R.drawable.five));
        aymenmodelArrayList.add(new aymenmodel("Six",R.drawable.six));
        aymenmodelArrayList.add(new aymenmodel("Sept",R.drawable.seven));
        aymenmodelArrayList.add(new aymenmodel("Huit",R.drawable.eight));
        aymenmodelArrayList.add(new aymenmodel("Neuf",R.drawable.nine));
        aymenmodelArrayList.add(new aymenmodel("Dix",R.drawable.ten));


        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}
