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

public class ColorsAr extends AppCompatActivity {
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
   // int[] images = {R.drawable.black, R.drawable.white, R.drawable.yellow
          //  , R.drawable.violet, R.drawable.red, R.drawable.pink, R.drawable.greyy, R.drawable.green, R.drawable.brown, R.drawable.bleu, R.drawable.orange};


    int[] vocals = {R.raw.blackar, R.raw.whitear, R.raw.yellowar, R.raw.purplear, R.raw.redar,
            R.raw.pinkar, R.raw.greyar, R.raw.greenar, R.raw.brownar, R.raw.bleuar, R.raw.orangear};

    //Create String array
    //String[] Names = {"أسود", "أبيض", "أصفر", "بنفسجي", "أحمر", "وردي", "رمادي", "أخضر", "بني", "أزرق", "برتقالي"};

   // MainAdapter4 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_ar);
        ImageView im = findViewById(R.id.speakercolorAr);


        //assign variable

        vpHorizontal = findViewById(R.id.vpp_horizontallll3);

        //initialize main adapter
       // adapter = new MainAdapter4(images, Names);

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
       // CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
       // transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
      //  transformer.addTransformer(new ViewPager2.PageTransformer() {
         //   @Override
         //   public void transformPage(@NonNull View page, float position) {
               // float v = 1 - Math.abs(position);
                //set scale y
              //  page.setScaleY(0.8f + v * 0.2f);
           // }
        //});
        //set page transform
      //  vpHorizontal.setPageTransformer(transformer);
        loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(ColorsAr.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("أسود",R.drawable.black));
        aymenmodelArrayList.add(new aymenmodel("أبيض",R.drawable.white));
        aymenmodelArrayList.add(new aymenmodel("أصفر",R.drawable.yellow));
        aymenmodelArrayList.add(new aymenmodel("بنفسجي", R.drawable.violet));
        aymenmodelArrayList.add(new aymenmodel("أحمر",R.drawable.red));
        aymenmodelArrayList.add(new aymenmodel("وردي",R.drawable.pink));
        aymenmodelArrayList.add(new aymenmodel("رمادي",R.drawable.greyy));
        aymenmodelArrayList.add(new aymenmodel("أخضر",R.drawable.green));
        aymenmodelArrayList.add(new aymenmodel("بني",R.drawable.brown));
        aymenmodelArrayList.add(new aymenmodel("أزرق",R.drawable.bleu));
        aymenmodelArrayList.add(new aymenmodel("برتقالي",R.drawable.orange1));


        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }

}