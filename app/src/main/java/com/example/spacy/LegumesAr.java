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

public class LegumesAr extends AppCompatActivity {
    //initialize variable
    //initialize variable
    private ViewPager vpHorizontal;
    private MediaPlayer mMediaPlayer;
    private adaptervp adaptervpp;
    private ArrayList<aymenmodel> aymenmodelArrayList;

    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) { releaseMediaPlayer();}
    };
    //int[] images = {R.drawable.petitpois, R.drawable.obergine, R.drawable.onion, R.drawable.brocoli,R.drawable.carotte, R.drawable.champignon,
        //    R.drawable.felfel, R.drawable.laitue, R.drawable.concombre, R.drawable.lifte ,
         //   R.drawable.maiis, R.drawable.pommedeterre,R.drawable.ail, R.drawable.tomatte};

    int[] vocals = {R.raw.baazilaa, R.raw.badhinjan, R.raw.bassal, R.raw.brookli,R.raw.carottear, R.raw.champignonar, R.raw.felfel ,
        R.raw.khass, R.raw.kheyar, R.raw.lifte,R.raw.maiisar, R.raw.pommedeterrear,R.raw.thoum, R.raw.tomattear};
   // String[] Names = {" بازلاء","باذنجان","بصل","بروكلي","جزر","فطر","فلفل","خس","خيار","لفت","ذرة","بطاطا","ثوم","طماطم"};

   // MainAdapter5 adapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legumesar);
        ImageView im = findViewById(R.id.speakerlegumesar);

        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontalla);

        //initialize main adapter
       // adapter = new MainAdapter5(images, Names);

        //set clip padding
       // vpHorizontal.setClipToPadding(false);
        //set clip children
       // vpHorizontal.setClipChildren(false);
        //set page limit
      //  vpHorizontal.setOffscreenPageLimit(3);
      //  vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //set adapter on horizontal viewpager
      //  vpHorizontal.setAdapter(adapter);

        //initialize composite page transformer
      //  CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
      //  transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
       //transformer.addTransformer(new ViewPager2.PageTransformer() {
//@Override
//public void transformPage(@NonNull View page, float position) {
       // float v = 1 - Math.abs(position);
        //set scale y
      //  page.setScaleY(0.8f + v * 0.2f);
      //  }
      //  });
        //set page transform
      //  vpHorizontal.setPageTransformer(transformer);
    loadcards();
        im.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        releaseMediaPlayer();

        mMediaPlayer = MediaPlayer.create(LegumesAr.this, vocals[vpHorizontal.getCurrentItem()]);

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
        aymenmodelArrayList.add(new aymenmodel("بازلاء",R.drawable.petitpois));
        aymenmodelArrayList.add(new aymenmodel("باذنجان",R.drawable.obergine));
        aymenmodelArrayList.add(new aymenmodel("بصل",R.drawable.onion));
        aymenmodelArrayList.add(new aymenmodel("بروكلي",R.drawable.brocoli));
        aymenmodelArrayList.add(new aymenmodel("جزر", R.drawable.carotte));
        aymenmodelArrayList.add(new aymenmodel("فطر",R.drawable.champignon));
        aymenmodelArrayList.add(new aymenmodel("فلفل",R.drawable.felfel));
        aymenmodelArrayList.add(new aymenmodel("خس",R.drawable.laitue));
        aymenmodelArrayList.add(new aymenmodel("خيار",R.drawable.concombre));
        aymenmodelArrayList.add(new aymenmodel("لفت",R.drawable.lifte ));
        aymenmodelArrayList.add(new aymenmodel("ذرة",R.drawable.maiis));
        aymenmodelArrayList.add(new aymenmodel("بطاطا",R.drawable.pommedeterre));
        aymenmodelArrayList.add(new aymenmodel("ثوم",R.drawable.ail));
        aymenmodelArrayList.add(new aymenmodel("طماطم",R.drawable.tomatte));


        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
}
