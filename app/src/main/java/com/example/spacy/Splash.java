package com.example.spacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacy.R;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Splash extends AppCompatActivity {

    //variables
    private static final int splash_screen = 6000;
    Animation top_anim, bottom_anim;
    ImageView astr;
    TextView name;
    private  String language;


    SharedPreferences MyPre;
    String New ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MyPre = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if (!sharedPreferences.getString("newwww","yy").equals("no")) {

            if(getResources().getConfiguration().locale.getDefault().getDisplayLanguage().equals("English")) {


                language = "English";
                New = "no";


            }
            else if(getResources().getConfiguration().locale.getDefault().getDisplayLanguage().equals("français")){
                language =  "Français";
                New = "no";

            }
            else {  Toast toast = Toast.makeText(Splash.this ,"you can change language of application from settings", FancyToast.LENGTH_LONG);
                toast.show();

            }

            SharedPreferences.Editor editor = MyPre.edit();
            editor.putString("LangApp", language);
            editor.putString("newwww", New)  ;
            editor.commit(); }
        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        astr = findViewById(R.id.astro);
        name = findViewById(R.id.name);
        astr.setAnimation(bottom_anim);
        name.setAnimation(top_anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,login.class);
                startActivity(intent);
                finish();//matkhalich el user yerja3 lel splash screen ki yepressi return
            }
        }, splash_screen);
    }

}