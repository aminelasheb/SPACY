package com.example.spacy;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class afamqar extends AppCompatActivity {

    TextView textScreenff, textQuestionff, textTitleff, textBtn;
    ImageView bigboss;
    Animation smalltobig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aftercsquizar);

        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

        textQuestionff = (TextView) findViewById(R.id.textQuestionff);
        textScreenff = (TextView) findViewById(R.id.textScreenff);
        textTitleff = (TextView) findViewById(R.id.textTitleff);


        bigboss = (ImageView) findViewById(R.id.bigboss);
        bigboss.startAnimation(smalltobig);


        textQuestionff.setTypeface(typeface);
        textScreenff.setTypeface(typeface);
        textTitleff.setTypeface(typeface);


        textTitleff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(afamqar.this, FamqAr.class);
                startActivity(intent);
            }
        });
    }
}

