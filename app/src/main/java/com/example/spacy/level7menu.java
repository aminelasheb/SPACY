package com.example.spacy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class level7menu extends AppCompatActivity {
    private CardView card5_6;
    private CardView card6_6;
    private String language,languageLearn;
    private TextView QZ, ALPH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level7menu);
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        language = sharedPreferences.getString("LangApp","/");
        languageLearn = sharedPreferences.getString("LangLearn","/");
        Intent intent = getIntent();
        String lang=intent.getStringExtra("Lang");
        TextView Lang=findViewById(R.id.alpha) ;
        Lang.setText(lang);


        QZ = findViewById(R.id.quizz6r);
        ALPH = findViewById(R.id.alpha6r);

        if (language.equals("Français")) {
            QZ.setText("QUIZ");
            ALPH.setText("OBJECTS");

        } else if (language.equals("العربية")) {
            QZ.setText("اختبار");
            ALPH.setText("الاشياء");
        } else if (language.equals("English")) {
        QZ.setText("Quiz");
        ALPH.setText("Objects");
    }


        card6_6 = findViewById(R.id.card6r);
        card5_6 = findViewById(R.id.card8r);

        card6_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {

                    Intent intentt = new Intent(level7menu.this, objectsAn.class);
                    startActivity(intentt);

                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(level7menu.this, objectsFR.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(level7menu.this, objectsarabe.class);
                    startActivity(intent);
                }
            }
        });

        card5_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (languageLearn.equals("An")) {
                    Intent intent = new Intent(level7menu.this, quiz7_ang.class);
                    startActivity(intent);
                } else if (languageLearn.equals("Fr")) {
                    Intent intent = new Intent(level7menu.this, quiz7_fr.class);
                    startActivity(intent);
                }
                if (languageLearn.equals("Ar")) {
                    Intent intent = new Intent(level7menu.this, quiz7_arabe.class);
                    startActivity(intent);
                }
            }
        });
    }


}
