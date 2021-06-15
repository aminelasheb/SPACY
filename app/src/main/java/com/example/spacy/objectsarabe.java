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

public class objectsarabe extends AppCompatActivity {
    //initialize variable
    ViewPager vpVertical, vpHorizontal2;
    private MediaPlayer mMediaPlayer;
    private adaptervp adaptervpp1;
    private ArrayList<aymenmodel> aymenmodelArrayList1;


    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
//
//    int[] images = {R.drawable.backpack, R.drawable.chair, R.drawable.drum
//            , R.drawable.hammer, R.drawable.pillow, R.drawable.pc, R.drawable.bed, R.drawable.clock, R.drawable.book, R.drawable.ball, R.drawable.keys, R.drawable.shoes};


    int[] vocals = {R.raw.ha9iba, R.raw.korsi, R.raw.table, R.raw.mitra9a, R.raw.wisada, R.raw.hasoub, R.raw.sarir, R.raw.sa3a, R.raw.kitab, R.raw.kora, R.raw.mafati7, R.raw.hidae
    };

//    //Create String array
//    String[] Names = {"حقيبة ظهر", "كرسي", "طبل", "مطرقة", "وسادة", "حاسوب", "سرير", "ساعة", "كتاب", "كرة", "مفاتيح", "حذاء"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectsarabe);

        ImageView im = findViewById(R.id.speaker);


        //assign variable

        vpHorizontal2 = findViewById(R.id.vp_horizontal2f2n);

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
loadcards();
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(objectsarabe.this, vocals[vpHorizontal2.getCurrentItem()]);

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

        aymenmodelArrayList1=new ArrayList<>();

        aymenmodelArrayList1.add(new aymenmodel("حقيبة ظهر",R.drawable.backpack));
        aymenmodelArrayList1.add(new aymenmodel("كرسي",R.drawable.chair));
        aymenmodelArrayList1.add(new aymenmodel("طبل",R.drawable.drum));
        aymenmodelArrayList1.add(new aymenmodel("مطرقة", R.drawable.hammer));
        aymenmodelArrayList1.add(new aymenmodel("وسادة",R.drawable.pillow));
        aymenmodelArrayList1.add(new aymenmodel("حاسوب",R.drawable.pc));
        aymenmodelArrayList1.add(new aymenmodel("سرير",R.drawable.bed));
        aymenmodelArrayList1.add(new aymenmodel("ساعة",R.drawable.clock));
        aymenmodelArrayList1.add(new aymenmodel("كتاب",R.drawable.book));
        aymenmodelArrayList1.add(new aymenmodel("كرة",R.drawable.ball));
        aymenmodelArrayList1.add(new aymenmodel("مفاتيح",R.drawable.keys));
        aymenmodelArrayList1.add(new aymenmodel("حذاء",R.drawable.shoes));


        adaptervpp1=new adaptervp(this,aymenmodelArrayList1);

        vpHorizontal2.setAdapter(adaptervpp1);

        vpHorizontal2.setPadding(50,400,50,0);

    }

}