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

public class CSQ extends AppCompatActivity {
    private RelativeLayout card21;
    private RelativeLayout card22;
    private ImageView SCQUIZ;
    private String language,languageLearn ;
    private TextView QZ, CL, SH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String lang=intent.getStringExtra("Lang");
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        language = sharedPreferences.getString("LangApp","/");
        languageLearn = sharedPreferences.getString("LangLearn","/");

        setContentView(R.layout.activity_c_s_q);
        TextView Lang=findViewById(R.id.alpha) ;
        Lang.setText(lang);
        QZ = findViewById(R.id.quizz2);
        CL = findViewById(R.id.colors2);
        SH = findViewById(R.id.shapes);

        if (language.equals("Français")) {
            QZ.setText("QUIZ");
            CL.setText("Couleurs");
            SH.setText("Formes");

        } else if (language.equals("العربية")) {
            QZ.setText("اختبار");
            CL.setText("الألوان");
            SH.setText("الأشكال");
        } else if (language.equals("English")) {
        QZ.setText("Quiz");
        CL.setText("Colors");
        SH.setText("Shapes");
    }


    SCQUIZ = findViewById(R.id.poo2);

        card21 = findViewById(R.id.colors);
        card22 = findViewById(R.id.shape);

        card21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(CSQ.this, ColorsAn.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(CSQ.this, ColorsFr.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(CSQ.this, ColorsAr.class);
                    startActivity(intent);
                }
            }
        });

        card22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(CSQ.this, ShapesAng.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(CSQ.this, ShapesFr.class);
                    startActivity(intent);
                }
                if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(CSQ.this, ShapesAr.class);
                    startActivity(intent);
                }
            }

        });

        SCQUIZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(CSQ.this, SCQUIZAn.class);
                    intent.putExtra("language", language);

                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(CSQ.this, CSQUIZFr.class);
                    startActivity(intent);
                }
                if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(CSQ.this, CSQUIZAr.class);
                    startActivity(intent);
                }

            }
        });


    }
}