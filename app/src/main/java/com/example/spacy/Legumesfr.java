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

public class Legumesfr extends AppCompatActivity {
    //initialize variable
    private ViewPager vpHorizontal;
    private MediaPlayer mMediaPlayer;
    private adaptervp adaptervpp;
    private ArrayList<aymenmodel> aymenmodelArrayList;

    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) { releaseMediaPlayer();}
    };
  //  int[] images = {R.drawable.tomatte, R.drawable.pommedeterre, R.drawable.poivron, R.drawable.onion,R.drawable.obergine, R.drawable.maiis,
         //   R.drawable.courgette, R.drawable.concombre, R.drawable.choufleur, R.drawable.champignon ,R.drawable.carotte, R.drawable.brocoli,
          //  R.drawable.betterave, R.drawable.artichaut, R.drawable.petitpois, R.drawable.ail,R.drawable.laitue};

    int[] vocals = {R.raw.tomatte, R.raw.pommedeterre, R.raw.poivron, R.raw.onion, R.raw.obergine, R.raw.courgette,
            R.raw.fenouil, R.raw.concombre, R.raw.choufleur, R.raw.champignon , R.raw.carotte, R.raw.brocoli,
            R.raw.betterave ,R.raw.artichaut, R.raw.maiis, R.raw.petitpois, R.raw.aiie, R.raw.laitue};

  //  String[] Names ={"Tommate","Pomme de terre","Poivron","Onion","Obergine","Mais","Courgette","Concombre","Chou-fleur","Champignon",
      //      "Carotte","Brocoli","Betterave","Artichaut","Petit pois","Ail","Laitue"};

  //  MainAdapter5 adapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legume);
        ImageView im = findViewById(R.id.speakerlegumesfr);

        //assign variable

        vpHorizontal = findViewById(R.id.vp_horizontallf);

        //initialize main adapter
     //   adapter = new MainAdapter5(images, Names);

        //set clip padding
       // vpHorizontal.setClipToPadding(false);
        //set clip children
       // vpHorizontal.setClipChildren(false);
        //set page limit
        //vpHorizontal.setOffscreenPageLimit(3);
        //set default start position
       // vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //set adapter on horizontal viewpager
       // vpHorizontal.setAdapter(adapter);

        //initialize composite page transformer
     //   CompositePageTransformer transformer = new CompositePageTransformer();
        //add margin between page
       // transformer.addTransformer(new MarginPageTransformer(8));
        //increase selected page size
       // transformer.addTransformer(new ViewPager2.PageTransformer() {
//@Override
//public void transformPage(@NonNull View page, float position) {
        //float v = 1 - Math.abs(position);
        //set scale y
        //page.setScaleY(0.8f + v * 0.2f);
     //   }
      //  });
        //set page transform
     //   vpHorizontal.setPageTransformer(transformer);
    loadcards();
        im.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        releaseMediaPlayer();

        mMediaPlayer = MediaPlayer.create(Legumesfr.this, vocals[vpHorizontal.getCurrentItem()]);

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

        aymenmodelArrayList.add(new aymenmodel("Tommate",R.drawable.tomatte));
        aymenmodelArrayList.add(new aymenmodel("Pomme de terre",R.drawable.pommedeterre));
        aymenmodelArrayList.add(new aymenmodel("Poivron",R.drawable.poivron));
        aymenmodelArrayList.add(new aymenmodel("Onion", R.drawable.onion));
        aymenmodelArrayList.add(new aymenmodel("Obergine",R.drawable.obergine));
        aymenmodelArrayList.add(new aymenmodel("Mais",R.drawable.maiis));
        aymenmodelArrayList.add(new aymenmodel("Courgette",R.drawable.courgette));
        aymenmodelArrayList.add(new aymenmodel("Concombre",R.drawable.concombre));
        aymenmodelArrayList.add(new aymenmodel("Chou-fleur",R.drawable.choufleur));
        aymenmodelArrayList.add(new aymenmodel("Champignon",R.drawable.champignon));
        aymenmodelArrayList.add(new aymenmodel("Carotte",R.drawable.carotte));
        aymenmodelArrayList.add(new aymenmodel("Brocoli",R.drawable.brocoli));
        aymenmodelArrayList.add(new aymenmodel("Betterave",R.drawable.betterave));
        aymenmodelArrayList.add(new aymenmodel("Artichaut",R.drawable.artichaut));
        aymenmodelArrayList.add(new aymenmodel("Petit pois",R.drawable.petitpois));
        aymenmodelArrayList.add(new aymenmodel("Ail",R.drawable.ail));
        aymenmodelArrayList.add(new aymenmodel("Laitue",R.drawable.laitue));

        adaptervpp=new adaptervp(this,aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50,400,50,0);

    }
        }
