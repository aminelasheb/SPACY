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

public class clothes_ar extends AppCompatActivity {
    //initialize variable
    ViewPager vpVertical, vpHorizontal;
    private MediaPlayer mMediaPlayer;
    private adaptervp adaptervpp1;
    private ArrayList<aymenmodel> aymenmodelArrayList1;


    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    //int[] images = {R.drawable.shirt1, R.drawable.pantalon ,R.drawable.boot1
          //  , R.drawable.caskette, R.drawable.chapeau, R.drawable.gloves1, R.drawable.glasses,
         //   R.drawable.skirt, R.drawable.veste1, R.drawable.cost1, R.drawable.bag, R.drawable.watches};

    int[] vocals = {R.raw.kamis, R.raw.serwal, R.raw.hidaa, R.raw.kobaa, R.raw.kobaa, R.raw.kofazat,
            R.raw.nadarat, R.raw.tanora, R.raw.miitaf, R.raw.badlat, R.raw.khatem,R.raw.saaa
    };

    //Create String array
   // String[] Names = {"قميص", "سروال", "حذاء", "قبعة", "قبعة", "قفازات", "نظارات","تنورة", "معطف", "بدلة", "خاتم","ساعة"};
   // MainAdapter3 adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_ar);

        ImageView im = findViewById(R.id.speaker88);


        //assign variable

        vpHorizontal = findViewById(R.id.horizo66);

        //initialize main adapter
      //  adapter = new MainAdapter3(images, Names);

        //set clip padding
      //  vpHorizontal.setClipToPadding(false);
        //set clip children
       // vpHorizontal.setClipChildren(false);
        //set page limit
      //  vpHorizontal.setOffscreenPageLimit(3);
        //set default start position
       // vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //set adapter on horizontal viewpager
       // vpHorizontal.setAdapter(adapter);


        //initialize composite page transformer
       // CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
       // transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
        //transformer.addTransformer(new ViewPager2.PageTransformer() {
         //   @Override
          //  public void transformPage(@NonNull View page, float position) {
           //     float v = 1 - Math.abs(position);
                //set scale y
             //   page.setScaleY(0.8f + v * 0.2f);
         //   }
      //  });
        //set page transform
      //  vpHorizontal.setPageTransformer(transformer);
        loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(clothes_ar.this, vocals[vpHorizontal.getCurrentItem()]);

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }   @Override
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

        aymenmodelArrayList1=new ArrayList<>();

        aymenmodelArrayList1.add(new aymenmodel("قميص",R.drawable.shirt));
        aymenmodelArrayList1.add(new aymenmodel("سروال",R.drawable.pantalon));
        aymenmodelArrayList1.add(new aymenmodel("حذاء",R.drawable.boot1));
        aymenmodelArrayList1.add(new aymenmodel("قبعة", R.drawable.caskette));
        aymenmodelArrayList1.add(new aymenmodel("قبعة",R.drawable.chapeau));
        aymenmodelArrayList1.add(new aymenmodel("قفازات",R.drawable.gloves1));
        aymenmodelArrayList1.add(new aymenmodel("نظارات",R.drawable.glasses));
        aymenmodelArrayList1.add(new aymenmodel("تنورة",R.drawable.skirt));
        aymenmodelArrayList1.add(new aymenmodel("معطف",R.drawable.veste1));
        aymenmodelArrayList1.add(new aymenmodel("بدلة",R.drawable.cost1));
        aymenmodelArrayList1.add(new aymenmodel("خاتم",R.drawable.bag));
        aymenmodelArrayList1.add(new aymenmodel("ساعة",R.drawable.watches));


        adaptervpp1=new adaptervp(this,aymenmodelArrayList1);

        vpHorizontal.setAdapter(adaptervpp1);

        vpHorizontal.setPadding(50,400,50,0);

    }

}
