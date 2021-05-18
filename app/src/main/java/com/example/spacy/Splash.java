package com.example.spacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spacy.R;

public class Splash extends AppCompatActivity {

    //variables
    private static final int splash_screen = 6000;
    Animation top_anim, bottom_anim;
    ImageView astr;
    TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        astr = findViewById(R.id.astro);
        name = findViewById(R.id.name);
        astr.setAnimation(bottom_anim);
        name.setAnimation(top_anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, AFA.class);
                startActivity(intent);
                finish();//matkhalich el user yerja3 lel splash screen ki yerja3
            }
        }, splash_screen);
    }

}