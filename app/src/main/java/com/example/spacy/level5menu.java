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

public class level5menu extends AppCompatActivity {
    private RelativeLayout card115;
    private ImageView card135;
    private String language,languageLearn;
    private TextView QZ, FRT,VGT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String lang=intent.getStringExtra("Lang");
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        language = sharedPreferences.getString("LangApp","/");
        languageLearn = sharedPreferences.getString("LangLearn","/");

        setContentView(R.layout.activity_level5menu);
        TextView Lang=findViewById(R.id.alphaa) ;
        Lang.setText(lang);

        QZ = findViewById(R.id.quiz135);
        FRT = findViewById(R.id.fruit1);
        VGT = findViewById(R.id.vegetable1);

        if (language.equals("Français")) {
            QZ.setText("QUIZ");
            FRT.setText("Fruits");
            VGT.setText("Légumes");

        } else if (language.equals("العربية")) {
            QZ.setText("اختبار");
            FRT.setText("الفواكه");
            VGT.setText("الخضر");
        }else if (language.equals("English")) {
            QZ.setText("Quiz");
            FRT.setText("Fruit");
            VGT.setText("Vegetables");
        }



        RelativeLayout Quiiiz = findViewById(R.id.card125);
        card115 = findViewById(R.id.card115);
        card135 = findViewById(R.id.card135);

        Quiiiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {

                    Intent intentt = new Intent(level5menu.this, Vegetable.class);
                    startActivity(intentt);

                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(level5menu.this,Legumesfr.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(level5menu.this, LegumesAr.class);
                    startActivity(intent);
                }
            }
        });

        card115.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(level5menu.this, FruitsAN.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(level5menu.this, FruitsFR.class);
                    startActivity(intent);
                }
                if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(level5menu.this, FruitsAR.class);
                    startActivity(intent);
                }
            }
        });
        card135.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(level5menu.this, Quiz5AN.class);
                    intent.putExtra("language", language);

                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(level5menu.this, Quiz5FR.class);
                    startActivity(intent);
                }
                if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(level5menu.this, Quiz5AR.class);
                    startActivity(intent);
                }

            }
        });
    }




}
