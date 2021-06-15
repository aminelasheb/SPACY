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

public class ShapesFr extends AppCompatActivity {
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
 //   int[] images = {R.drawable.square, R.drawable.triangle, R.drawable.circle
          //  , R.drawable.rectangle, R.drawable.oval, R.drawable.star, R.drawable.rhombus, R.drawable.pentagon, R.drawable.hexagon, R.drawable.heart};


    int[] vocals = {R.raw.carree, R.raw.trianglee, R.raw.cercle, R.raw.rectanglee, R.raw.ovale,
            R.raw.etoile, R.raw.losange, R.raw.pentagone, R.raw.hexagone, R.raw.coeur};

    //Create String array
   // String[] Names = {"Carrée", "Triangle", "Cercle", "Rectangle", "Ovale", "Etoile", "Losange", "Pentagone", "Hexagone", "Coeur"};

   // MainAdapter5 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes_fr);
        ImageView im = findViewById(R.id.speakerforme);


        //assign variable

        vpHorizontal = findViewById(R.id.vpp_horizontalss3);

        //initialize main adapter
        //adapter = new MainAdapter5(images, Names);

        //set clip padding
       // vpHorizontal.setClipToPadding(false);
        //set clip children
        //vpHorizontal.setClipChildren(false);
        //set page limit
       // vpHorizontal.setOffscreenPageLimit(3);
        //set default start position
        //vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //set adapter on horizontal viewpager
       // vpHorizontal.setAdapter(adapter);


        //initialize composite page transformer
        //CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
       // transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
       // transformer.addTransformer(new ViewPager2.PageTransformer() {
         //   @Override
          //  public void transformPage(@NonNull View page, float position) {
            //    float v = 1 - Math.abs(position);
                //set scale y
             //   page.setScaleY(0.8f + v * 0.2f);
           // }
      //  });
        //set page transform
      //  vpHorizontal.setPageTransformer(transformer);
        loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(ShapesFr.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("Carrée",R.drawable.square));
        aymenmodelArrayList.add(new aymenmodel("Triangle",R.drawable.triangle));
        aymenmodelArrayList.add(new aymenmodel("Cercle",R.drawable.circle));
        aymenmodelArrayList.add(new aymenmodel("Rectangle", R.drawable.rectangle));
        aymenmodelArrayList.add(new aymenmodel("Ovale",R.drawable.oval));
        aymenmodelArrayList.add(new aymenmodel("Star",R.drawable.star));
        aymenmodelArrayList.add(new aymenmodel("Etoile",R.drawable.rhombus));
        aymenmodelArrayList.add(new aymenmodel("Pentagone",R.drawable.pentagon));
        aymenmodelArrayList.add(new aymenmodel("Hexagone",R.drawable.hexagon));
        aymenmodelArrayList.add(new aymenmodel("Coeur",R.drawable.heart));

        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}