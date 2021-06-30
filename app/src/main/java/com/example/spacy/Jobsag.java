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

public class Jobsag extends AppCompatActivity {//initialize variable
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
  //  int[] images = {R.drawable.astronome,R.drawable.doctor,R.drawable.infirmiere,R.drawable.prof,R.drawable.policier,
         //   R.drawable.pompier, R.drawable.architecte,R.drawable.macon,R.drawable.bucheron,R.drawable.chef,
          //  R.drawable.coiffeur,R.drawable.facteur, R.drawable.agriculteur,R.drawable.pecheur};

    int[] vocals = {R.raw.astr, R.raw.doc, R.raw.nrc, R.raw.tch, R.raw.plc, R.raw.frft, R.raw.artan, R.raw.buil
            , R.raw.lumbr, R.raw.chefan, R.raw.hair, R.raw.pst, R.raw.frm, R.raw.snn};


    //Create String array
   // String[] Names = {"astronomer", "doctor" , "nurse", "teacher", "policemen", "firefighter",
        //    "architect", "builder","lumberjack", "chef", "hairdresser", "postman","farmer", "sinner"};

    //MainAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs_ag);
        ImageView im = findViewById(R.id.speakerje1);


        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontalje1);

        //initialize main adapter
        //adapter = new MainAdapter3(images, Names);

        //set clip padding
      //  vpHorizontal.setClipToPadding(false);
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
     //   transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
      //  transformer.addTransformer(new ViewPager2.PageTransformer() {
         //   @Override
        //    public void transformPage(@NonNull View page, float position) {
          //      float v = 1 - Math.abs(position);
                //set scale y
          //      page.setScaleY(0.8f + v * 0.2f);
         //   }
    //    });
        //set page transform
        //vpHorizontal.setPageTransformer(transformer);
        loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(Jobsag.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("astronomer",R.drawable.astronome));
        aymenmodelArrayList.add(new aymenmodel("doctor",R.drawable.doctor));
        aymenmodelArrayList.add(new aymenmodel("nurse",R.drawable.infirmiere));
        aymenmodelArrayList.add(new aymenmodel("teacher", R.drawable.prof));
        aymenmodelArrayList.add(new aymenmodel("policemen",R.drawable.policier));
        aymenmodelArrayList.add(new aymenmodel("firefighter",R.drawable.pompier));
        aymenmodelArrayList.add(new aymenmodel("architect",R.drawable.architecte));
        aymenmodelArrayList.add(new aymenmodel("builder",R.drawable.macon));
        aymenmodelArrayList.add(new aymenmodel("lumberjack",R.drawable.bucheron));
        aymenmodelArrayList.add(new aymenmodel("chef",R.drawable.chef));
        aymenmodelArrayList.add(new aymenmodel("hairdresser",R.drawable.coiffeur));
        aymenmodelArrayList.add(new aymenmodel("postman",R.drawable.facteur));
        aymenmodelArrayList.add(new aymenmodel("farmer",R.drawable.agriculteur));
        aymenmodelArrayList.add(new aymenmodel("sinner",R.drawable.pecheur));


        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }

}
