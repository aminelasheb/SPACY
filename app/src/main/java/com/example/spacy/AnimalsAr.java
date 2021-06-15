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

public class AnimalsAr extends AppCompatActivity {
    //initialize variable
   ViewPager ViewPagervpVertical, vpHorizontal;
    private MediaPlayer mMediaPlayer;
    private adaptervp adaptervpp;
    private ArrayList<aymenmodel> aymenmodelArrayList;


    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
//    int[] images = {R.drawable.cat, R.drawable.dog, R.drawable.elepant
//            , R.drawable.fox, R.drawable.horse, R.drawable.lion, R.drawable.monkey, R.drawable.panda, R.drawable.snake,
//            R.drawable.rabbit,};


        int[] vocals = {R.raw.catar, R.raw.dogar, R.raw.elephantar, R.raw.foxar,
            R.raw.horsear, R.raw.lionar, R.raw.monkeyar, R.raw.pandaar, R.raw.snakear,

            R.raw.rabitar};

    //Create String array
//    String[] Names = {"قط", "كلب", "فيل", "ثعلب", "حصان", "أسد", "قرد", "باندا", "ثعبان", "أرنب"};

//    MainAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_ar);
        ImageView im = findViewById(R.id.speakerfrf1);


        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontal2f);
        loadcards();
        //initialize main adapter
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

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(AnimalsAr.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("قط",R.drawable.cat));
        aymenmodelArrayList.add(new aymenmodel("كلب",R.drawable.dog));
        aymenmodelArrayList.add(new aymenmodel("فيل",R.drawable.elepant));
        aymenmodelArrayList.add(new aymenmodel("ثعلب", R.drawable.fox));
        aymenmodelArrayList.add(new aymenmodel("حصان",R.drawable.horse));
        aymenmodelArrayList.add(new aymenmodel("أسد",R.drawable.lion));
        aymenmodelArrayList.add(new aymenmodel("قرد",R.drawable.monkey));
        aymenmodelArrayList.add(new aymenmodel("باندا",R.drawable.panda));
        aymenmodelArrayList.add(new aymenmodel("ثعبان",R.drawable.snake));
        aymenmodelArrayList.add(new aymenmodel("باندا",R.drawable.rabbit));



        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}
