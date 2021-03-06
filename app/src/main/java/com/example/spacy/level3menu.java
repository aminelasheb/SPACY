package com.example.spacy;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shashank.sony.fancytoastlib.FancyToast;

public class level3menu extends AppCompatActivity {
    private RelativeLayout card11;
    private ImageView card13;
    private String language,languageLearn;
    private TextView QZ, clot,bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String lang=intent.getStringExtra("Lang");
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        language = sharedPreferences.getString("LangApp","/");
        languageLearn = sharedPreferences.getString("LangLearn","/");
        String level=intent.getStringExtra("Level");

        setContentView(R.layout.activity_level3);
        TextView Lang=findViewById(R.id.alphaa) ;
        Lang.setText(lang);

        QZ = findViewById(R.id.quiz13);
        clot = findViewById(R.id.clothes1);
        bd = findViewById(R.id.body1);

        if (language.equals("Français")) {
            QZ.setText("QUIZ");
            clot.setText("Vêtement");
            bd.setText("corps");

        } else if (language.equals("العربية")) {
            QZ.setText("اختبار");
            clot.setText("ملابس");
            bd.setText("جسم"); }
        else if (language.equals("English")) {
        QZ.setText("Quiz");
        clot.setText("Clothes");
        bd.setText("Body");
    }


       RelativeLayout clooth = findViewById(R.id.card12);
        card11 = findViewById(R.id.card11);
        card13 = findViewById(R.id.card13);

        card13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {

                    Intent intentt = new Intent(level3menu.this, Quiz3AN.class);
                    startActivity(intentt);

                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(level3menu.this,Quiz3Fr.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(level3menu.this, Quiz3Ar.class);
                    startActivity(intent);
                }
            }
        });

        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("English")||language.equals("Français") ) {
                    Intent intent = new Intent(level3menu.this, Learn.class);
                    intent.putExtra("Level",level);

                    startActivity(intent);
                }
                if (language.equals("العربية")) {
                    Intent intent = new Intent(level3menu.this, LearnAr.class);
                    intent.putExtra("Level",level);

                    startActivity(intent);
                }
            }
        });
        clooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("English")||language.equals("Français") ) {
                    Intent intent = new Intent(level3menu.this, Learn.class);
                    intent.putExtra("Level","3/2");

                    startActivity(intent);
                }
                if (language.equals("العربية")) {
                    Intent intent = new Intent(level3menu.this, LearnAr.class);
                    intent.putExtra("Level","3/2");

                    startActivity(intent);
                }
            }
        });
    }




}
