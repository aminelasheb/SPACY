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

public class FruitsFR extends AppCompatActivity {
    //initialize variable
    ViewPager vpVertical, vpHorizontal;
    private MediaPlayer mMediaPlayer;
    private adaptervp adaptervpp;
    private ArrayList<aymenmodel> aymenmodelArrayList;


    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) { releaseMediaPlayer();}
    };
    //int[] images = {R.drawable.abricot, R.drawable.ananas, R.drawable.avocat, R.drawable.bannane, R.drawable.cerise, R.drawable.citron, R.drawable.figue,
                 // R.drawable.fraise, R.drawable.kiwi, R.drawable.grenade, R.drawable.mandarine,R.drawable.framboise, R.drawable.mangue, R.drawable.melon, R.drawable.noixdecoco,
             //    R.drawable.orangee,R.drawable.peche, R.drawable.poire, R.drawable.pomme, R.drawable.raisin, R.drawable.pastheque};

    int[] vocals =  {R.raw.abricot, R.raw.ananas, R.raw.avocat,R.raw.bannane, R.raw.cerise, R.raw.citron, R.raw.figue, R.raw.fraise,
                   R.raw.kiwi, R.raw.grenade, R.raw.mandarine,R.raw.framboise, R.raw.mangue, R.raw.melon, R.raw.noixdecoco, R.raw.orange,R.raw.peche,
                    R.raw.poire, R.raw.pomme, R.raw.raisin, R.raw.pastheque};
  //  String[] Names ={"Abricot","Ananas","Avocat","Banane","Cerise","Citron","Figue","Fraise","Kiwi","Grenade","Mandarine","Framboise","Mangue",
          //  "Melon","Noix De Coco","Orange","Peche","Poire","Pomme","Raisin","Pastheque"};
          //  MainAdapter5 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits_fr);
        ImageView im = findViewById(R.id.speakerfruitfr);

        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontalff);

        //initialize main adapter
        //adapter = new MainAdapter5(images, Names);

        //set clip padding
       // vpHorizontal.setClipToPadding(false);
        //set clip children
       // vpHorizontal.setClipChildren(false);
        //set page limit
       // vpHorizontal.setOffscreenPageLimit(3);
        //set default start position
      //  vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //set adapter on horizontal viewpager
       // vpHorizontal.setAdapter(adapter);

        //initialize composite page transformer
        //CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
       // transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
        //transformer.addTransformer(new ViewPager2.PageTransformer() {
      //      @Override
         //   public void transformPage(@NonNull View page, float position) {
             //   float v = 1 - Math.abs(position);
                //set scale y
              //  page.setScaleY(0.8f + v * 0.2f);
           // }
       // });
        //set page transform
      //  vpHorizontal.setPageTransformer(transformer);
        loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(FruitsFR.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("Abricot",R.drawable.abricot));
        aymenmodelArrayList.add(new aymenmodel("Ananas",R.drawable.ananas));
        aymenmodelArrayList.add(new aymenmodel("Avocat",R.drawable.avocat));
        aymenmodelArrayList.add(new aymenmodel("Banane", R.drawable.bannane));
        aymenmodelArrayList.add(new aymenmodel("Cerise",R.drawable.cerise));
        aymenmodelArrayList.add(new aymenmodel("Citron",R.drawable.citron));
        aymenmodelArrayList.add(new aymenmodel("Figue",R.drawable.figue));
        aymenmodelArrayList.add(new aymenmodel("Fraise",R.drawable.fraise));
        aymenmodelArrayList.add(new aymenmodel("Kiwi",R.drawable.kiwi));
        aymenmodelArrayList.add(new aymenmodel("Grenade",R.drawable.grenade));
        aymenmodelArrayList.add(new aymenmodel("Mandarine",R.drawable.mandarine));
        aymenmodelArrayList.add(new aymenmodel("Framboise",R.drawable.framboise));
        aymenmodelArrayList.add(new aymenmodel("Mangue",R.drawable.mangue));
        aymenmodelArrayList.add(new aymenmodel("Melon",R.drawable.melon));
        aymenmodelArrayList.add(new aymenmodel("Noix De Coco",R.drawable.noixdecoco));
        aymenmodelArrayList.add(new aymenmodel("Orange",R.drawable.orangee));

        aymenmodelArrayList.add(new aymenmodel("Peche",R.drawable.peche));
        aymenmodelArrayList.add(new aymenmodel("pomme",R.drawable.pomme));

        aymenmodelArrayList.add(new aymenmodel("Poire",R.drawable.poire));
        aymenmodelArrayList.add(new aymenmodel("Raisin",R.drawable.raisin));
        aymenmodelArrayList.add(new aymenmodel("Pastheque",R.drawable.pastheque));


        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}
