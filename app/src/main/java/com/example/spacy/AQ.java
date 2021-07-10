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
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

public class AQ extends AppCompatActivity {
    private RelativeLayout card5_6;
    private ImageView card6_6;
    private String language,languageLearn;
    private TextView QZ, ALPH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String lang=intent.getStringExtra("Lang");
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        language = sharedPreferences.getString("LangApp","/");
        languageLearn = sharedPreferences.getString("LangLearn","/");

        String level=intent.getStringExtra("Level");



        setContentView(R.layout.activity_a_q);
        TextView Lang=findViewById(R.id.alphaa) ;
        Lang.setText(lang);
        QZ = findViewById(R.id.quizz6);
        ALPH = findViewById(R.id.animals6);

        if (language.equals("Français")) {
            QZ.setText("QUIZ");
            ALPH.setText("Animaux");

        } else if (language.equals("العربية")) {
            QZ.setText("اختبار");
            ALPH.setText("الحيوانات");
        } else if (language.equals("English")) {
            QZ.setText("Quiz");
            ALPH.setText("Animlals");
        }



        card6_6 = findViewById(R.id.poo6);
        card5_6 = findViewById(R.id.animals);

        card5_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("English")||language.equals("Français") ) {
                    Intent intent = new Intent(AQ.this, Learn.class);
                    intent.putExtra("Level",level);

                    startActivity(intent);
                }
                if (language.equals("العربية")) {
                    Intent intent = new Intent(AQ.this, LearnAr.class);
                    intent.putExtra("Level",level);

                    startActivity(intent);
                }
            }
        });

        card6_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(AQ.this, Quiz6An.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(AQ.this, Quiz6Fr.class);
                    startActivity(intent);
                }
                if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(AQ.this, Quiz6Ar.class);
                    startActivity(intent);
                }
            }

        });


    }
}