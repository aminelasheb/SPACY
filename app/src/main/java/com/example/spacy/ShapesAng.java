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

public class ShapesAng extends AppCompatActivity {
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
  //  int[] images = {R.drawable.square, R.drawable.triangle, R.drawable.circle
          //  , R.drawable.rectangle, R.drawable.oval, R.drawable.star, R.drawable.rhombus, R.drawable.pentagon, R.drawable.hexagon, R.drawable.heart};


    int[] vocals = {R.raw.square, R.raw.triangle, R.raw.circle, R.raw.rectangle, R.raw.oval,
            R.raw.star, R.raw.rohmbus, R.raw.pentagon, R.raw.hexagon, R.raw.heart};

    //Create String array
  //  String[] Names = {"Square", "Triangle", "Circle", "Rectangle", "Oval", "Star", "Rohmbus", "Pentagon", "Hexagon", "Heart"};

   // MainAdapter5 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes_ang);
        ImageView im = findViewById(R.id.speakershape);


        //assign variable

        vpHorizontal = findViewById(R.id.vpp_horizontals3);

        //initialize main adapter
      //  adapter = new MainAdapter5(images, Names);

        //set clip padding
       // vpHorizontal.setClipToPadding(false);
        //set clip children
       // vpHorizontal.setClipChildren(false);
        //set page limit
       // vpHorizontal.setOffscreenPageLimit(3);
        //set default start position
       // vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //set adapter on horizontal viewpager
        //vpHorizontal.setAdapter(adapter);


        //initialize composite page transformer
        //CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
       // transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
       // transformer.addTransformer(new ViewPager2.PageTransformer() {
           // @Override
           // public void transformPage(@NonNull View page, float position) {
              //  float v = 1 - Math.abs(position);
                //set scale y
              //  page.setScaleY(0.8f + v * 0.2f);
          //  }
       // });
        //set page transform
       // vpHorizontal.setPageTransformer(transformer);
        loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(ShapesAng.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("Square",R.drawable.square));
        aymenmodelArrayList.add(new aymenmodel("Triangle",R.drawable.triangle));
        aymenmodelArrayList.add(new aymenmodel("Circle",R.drawable.circle));
        aymenmodelArrayList.add(new aymenmodel("Rectangle", R.drawable.rectangle));
        aymenmodelArrayList.add(new aymenmodel("Oval",R.drawable.oval));
        aymenmodelArrayList.add(new aymenmodel("Star",R.drawable.star));
        aymenmodelArrayList.add(new aymenmodel("Rohmbus",R.drawable.rhombus));
        aymenmodelArrayList.add(new aymenmodel("Pentagon",R.drawable.pentagon));
        aymenmodelArrayList.add(new aymenmodel("Hexagon",R.drawable.hexagon));
        aymenmodelArrayList.add(new aymenmodel("Heart",R.drawable.heart));



        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}