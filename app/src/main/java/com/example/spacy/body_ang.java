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

public class body_ang extends AppCompatActivity {
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
  //  int[] images = {R.drawable.head1, R.drawable.face, R.drawable.hair4, R.drawable.eye, R.drawable.nose, R.drawable.orl,
       //     R.drawable.bouch, R.drawable.mainn, R.drawable.bras, R.drawable.jambe1, R.drawable.mollet, R.drawable.pied,};


    int[] vocals = {R.raw.head, R.raw.face, R.raw.hair, R.raw.eye, R.raw.nose, R.raw.ear, R.raw.mouth, R.raw.hand
            , R.raw.arm, R.raw.leg, R.raw.calf, R.raw.foot,};
  //  String[] Names = {"head", "face", "hair", "Eye", "nose", "ear", "mouth", "hand", "arm", "leg", "calf", "foot"};


     //   MainAdapter3 adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_body_ang);
            ImageView im = findViewById(R.id.speaker36);


            //assign variable

            vpHorizontal = findViewById(R.id.vp_horizontal36);

            //initialize main adapter
            //adapter = new MainAdapter3(images, Names);

            //set clip padding
          //  vpHorizontal.setClipToPadding(false);
            //set clip children
          //  vpHorizontal.setClipChildren(false);
            //set page limit
           // vpHorizontal.setOffscreenPageLimit(3);
            //set default start position
           // vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
            //set adapter on horizontal viewpager
          //  vpHorizontal.setAdapter(adapter);


            //initialize composite page transformer
          //  CompositePageTransformer transformer = new CompositePageTransformer();
            //add margin between page
           // transformer.addTransformer(new MarginPageTransformer(8));
            //increase selected page size
           // transformer.addTransformer(new ViewPager2.PageTransformer() {
             //   @Override
            //    public void transformPage(@NonNull View page, float position) {
                //    float v = 1 - Math.abs(position);
                    //set scale y
                 //   page.setScaleY(0.8f + v * 0.2f);
               // }
           // });
            //set page transform
          //  vpHorizontal.setPageTransformer(transformer);
            loadcards();
            im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    releaseMediaPlayer();

                    mMediaPlayer = MediaPlayer.create(body_ang.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("head",R.drawable.head1));
        aymenmodelArrayList.add(new aymenmodel("face",R.drawable.face));
        aymenmodelArrayList.add(new aymenmodel("hair",R.drawable.hair4));
        aymenmodelArrayList.add(new aymenmodel("Eye", R.drawable.eye));
        aymenmodelArrayList.add(new aymenmodel("nose",R.drawable.nose));
        aymenmodelArrayList.add(new aymenmodel("Ear",R.drawable.orl));
        aymenmodelArrayList.add(new aymenmodel("mouth",R.drawable.bouch));
        aymenmodelArrayList.add(new aymenmodel("hand",R.drawable.mainn));
        aymenmodelArrayList.add(new aymenmodel("arm",R.drawable.bras));
        aymenmodelArrayList.add(new aymenmodel("leg",R.drawable.jambe1));
        aymenmodelArrayList.add(new aymenmodel("calf",R.drawable.mollet));
        aymenmodelArrayList.add(new aymenmodel("foot",R.drawable.pied));



        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }

    }


