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

public class clothes_ang extends AppCompatActivity {
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
  //  int[] images = {R.drawable.shirt1, R.drawable.pantalon ,R.drawable.boot1
       //     , R.drawable.caskette, R.drawable.chapeau, R.drawable.gloves1, R.drawable.glasses,
        //    R.drawable.skirt, R.drawable.veste1, R.drawable.cost1, R.drawable.bag, R.drawable.watches};



    int[] vocals = {R.raw.shirt, R.raw.pant, R.raw.boot, R.raw.casqq, R.raw.cap, R.raw.gloves,
            R.raw.glasses, R.raw.skirt, R.raw.jacket, R.raw.costt, R.raw.ring,R.raw.watch
    };

   // //Create String array
   // String[] Names = {"tee-shirt", "pant", "pant", "casquette", "cap", "Gloves", "Glasses","Skirt",
           // "jacket", "costume", "ring","watch"};

  // MainAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_ang);
        ImageView im = findViewById(R.id.speaker22);


        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontalvp);

        //initialize main adapter
       // adapter = new MainAdapter3(images, Names);

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
        loadcards();

        //initialize composite page transformer
       // CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
      //  transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
      //  transformer.addTransformer(new ViewPager2.PageTransformer() {
         //   @Override
         //   public void transformPage(@NonNull View page, float position) {
          //      float v = 1 - Math.abs(position);
                //set scale y
            //    page.setScaleY(0.8f + v * 0.2f);
           // }
       // });
        //set page transform
     //   vpHorizontal.setPageTransformer(transformer);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(clothes_ang.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("tee-shirt",R.drawable.shirt));
        aymenmodelArrayList.add(new aymenmodel("pant",R.drawable.pantalon));
        aymenmodelArrayList.add(new aymenmodel("boot",R.drawable.boot1));
        aymenmodelArrayList.add(new aymenmodel("casquette", R.drawable.caskette));
        aymenmodelArrayList.add(new aymenmodel("cap",R.drawable.chapeau));
        aymenmodelArrayList.add(new aymenmodel("Gloves",R.drawable.gloves1));
        aymenmodelArrayList.add(new aymenmodel("Glasses",R.drawable.glasses));
        aymenmodelArrayList.add(new aymenmodel("Skirt",R.drawable.skirt));
        aymenmodelArrayList.add(new aymenmodel("jacket",R.drawable.veste1));
        aymenmodelArrayList.add(new aymenmodel("costume",R.drawable.cost1));
        aymenmodelArrayList.add(new aymenmodel("ring",R.drawable.bag));
        aymenmodelArrayList.add(new aymenmodel("watch",R.drawable.watches));



        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}

