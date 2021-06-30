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

public class NumAn extends AppCompatActivity {
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
          //  , R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten};


    int[] vocals = {R.raw.zerooo, R.raw.oneng, R.raw.twooo, R.raw.threeng, R.raw.fourng,
            R.raw.fiveng, R.raw.sixg, R.raw.sevenng, R.raw.eight, R.raw.ninng, R.raw.tenng};

    //Create String array
   // String[] Names = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

    //MainAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numberseng);
        ImageView im = findViewById(R.id.speakeran);


        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontal3);

        //initialize main adapter
       // adapter = new MainAdapter3(images, Names);

        //set clip padding
       // vpHorizontal.setClipToPadding(false);
        //set clip children
       // vpHorizontal.setClipChildren(false);
        //set page limit
       /// vpHorizontal.setOffscreenPageLimit(3);
        //set default start position
       // vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //set adapter on horizontal viewpager
       // vpHorizontal.setAdapter(adapter);


        //initialize composite page transformer
        //CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
       // transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
      //  transformer.addTransformer(new ViewPager2.PageTransformer() {
          //  @Override
          //  public void transformPage(@NonNull View page, float position) {
            //    float v = 1 - Math.abs(position);
                //set scale y
               // page.setScaleY(0.8f + v * 0.2f);
            //}
       // });
        //set page transform
       // vpHorizontal.setPageTransformer(transformer);
        loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(NumAn.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("Zero",R.drawable.zero));
        aymenmodelArrayList.add(new aymenmodel("One",R.drawable.one));
        aymenmodelArrayList.add(new aymenmodel("Two",R.drawable.two));
        aymenmodelArrayList.add(new aymenmodel("Three", R.drawable.threee));
        aymenmodelArrayList.add(new aymenmodel("Four",R.drawable.four));
        aymenmodelArrayList.add(new aymenmodel("Five",R.drawable.five));
        aymenmodelArrayList.add(new aymenmodel("Six",R.drawable.six));
        aymenmodelArrayList.add(new aymenmodel("Seven",R.drawable.seven));
        aymenmodelArrayList.add(new aymenmodel("Eight",R.drawable.eight));
        aymenmodelArrayList.add(new aymenmodel("Nine",R.drawable.nine));
        aymenmodelArrayList.add(new aymenmodel("Ten",R.drawable.ten));




        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}
