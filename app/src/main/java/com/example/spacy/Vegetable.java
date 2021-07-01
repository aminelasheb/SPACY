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

public class Vegetable extends AppCompatActivity {
    //initialize variable
    private ViewPager vpHorizontal;
    private MediaPlayer mMediaPlayer;
    private adaptervp adaptervpp;
    private ArrayList<aymenmodel> aymenmodelArrayList;

    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) { releaseMediaPlayer();}
    };
   // int[] images = {R.drawable.ail, R.drawable.lifte, R.drawable.carotte, R.drawable.concombre,R.drawable.laitue, R.drawable.leek,
          //  R.drawable.maiis, R.drawable.obergine, R.drawable.onion, R.drawable.poivron ,R.drawable.pommedeterre, R.drawable.champignon,
          //  R.drawable.tomatte};

    int[] vocals = {R.raw.ailan, R.raw.betteravean, R.raw.carottean, R.raw.concombrean, R.raw.laituean, R.raw.leekan,
            R.raw.maiisan, R.raw.oberginean, R.raw.onionan, R.raw.pepperan , R.raw.pommedeterrean, R.raw.shampignonan,
            R.raw.tomatean};
    //String[] Names ={"Garlic","Turnip","Carrot","Cucumber","Lettuce","Leek","Corn","Eggplant","Onion","Pepper","Potato","Mushroom","Tomato"};
   // MainAdapter5 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable);
        ImageView im = findViewById(R.id.speakervegetable);

        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontal5v);

        //initialize main adapter
       // adapter = new MainAdapter5(images, Names);

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
          //  public void transformPage(@NonNull View page, float position) {
           //     float v = 1 - Math.abs(position);
                //set scale y
              //  page.setScaleY(0.8f + v * 0.2f);
            //}
      //  });
        //set page transform
       // vpHorizontal.setPageTransformer(transformer);
        loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(Vegetable.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("Garlic",R.drawable.ail));
        aymenmodelArrayList.add(new aymenmodel("Carrot",R.drawable.carotte));
        aymenmodelArrayList.add(new aymenmodel("Cucumber", R.drawable.concombre));
        aymenmodelArrayList.add(new aymenmodel("Lettuce",R.drawable.laitue));
        aymenmodelArrayList.add(new aymenmodel("Leek",R.drawable.leek));
        aymenmodelArrayList.add(new aymenmodel("Corn",R.drawable.maiis));
        aymenmodelArrayList.add(new aymenmodel("Eggplant",R.drawable.obergine));
        aymenmodelArrayList.add(new aymenmodel("Onion",R.drawable.onion));
        aymenmodelArrayList.add(new aymenmodel("Pepper",R.drawable.poivron));
        aymenmodelArrayList.add(new aymenmodel("Potato",R.drawable.pommedeterre));
        aymenmodelArrayList.add(new aymenmodel("Mushroom",R.drawable.champignon));
        aymenmodelArrayList.add(new aymenmodel("Tomato",R.drawable.tomatte));


        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}