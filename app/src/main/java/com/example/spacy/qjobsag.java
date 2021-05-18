package com.example.spacy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class qjobsag extends AppCompatActivity {

    ImageView iv_button, iv_arrow;
    TextView tv_points;
    ProgressBar progressBar;

    Handler handler;
    Runnable runnable;

    Random r;

    private final static int STATE_AST = 1;
    private final static int STATE_POL = 2;
    private final static int STATE_POM = 3;
    private final static int STATE_DOC = 4;

    int buttonState = STATE_AST;
    int arrowState = STATE_AST;

    int currentTime = 4000;
    int startTime = 4000;

    int currentPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qjobs_ag);

        iv_button = findViewById(R.id.iv_button);
        iv_arrow = findViewById(R.id.iv_arrow);
        tv_points = findViewById(R.id.tv_points);
        progressBar = findViewById(R.id.progressBar);

        //set the intial progressbar timr to 4s
        progressBar.setMax(startTime);
        progressBar.setProgress(startTime);

        //display the starting points
        tv_points.setText("Points:  "+currentPoints);

        //generate random arrow at the start of the game
        r = new Random();
        arrowState = r.nextInt(4)+1;
        setarrowImage(arrowState);

        iv_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonImage(setButtonPosition(buttonState));
            }
        });

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                //show the progress
             currentTime = currentTime -100;
             progressBar.setProgress(currentTime);
              if (currentTime>0){
                  handler.postDelayed(runnable,100);
              } else {
                  if (buttonState == arrowState){
                      currentPoints = currentPoints+1;
                      tv_points.setText("Points:  "+currentPoints);

                      startTime = startTime-100;
                      if (startTime<1000){
                          startTime = 2000;
                      }
                      progressBar.setMax(startTime);
                      currentTime = startTime;
                      progressBar.setProgress(currentTime);

                      arrowState = r.nextInt(4)+1;
                      setarrowImage(arrowState);

                      handler.postDelayed(runnable,100);
                  } else {
                      /*iv_button.setEnabled(false);
                      Toast.makeText(qjobsag.this, "Game Over",Toast.LENGTH_SHORT).show();*/
                      AlertDialog.Builder alert = new AlertDialog.Builder(qjobsag.this);
                      alert.setTitle("Game Over");
                      alert.setCancelable(false);
                      alert.setMessage("Your score: " + currentPoints );
                      alert.setPositiveButton("Back ", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialogInterface, int i) {
                              finish();
                          }
                      });
                      alert.setNegativeButton("Cancel", null);
                      alert.show();
                  }
              }
            }
        };

        //start the game loop
        handler.postDelayed(runnable,100);

    }

    // display the arrow according to num
    private void setarrowImage(int state) {
        switch (state) {
            case STATE_AST:
                iv_arrow.setImageResource(R.drawable.astronome);
                arrowState = STATE_AST;
                break;
            case STATE_POL:
                iv_arrow.setImageResource(R.drawable.policier);
                arrowState = STATE_POL;
                break;
            case STATE_POM:
                iv_arrow.setImageResource(R.drawable.pompier);
                arrowState = STATE_POM;
                break;
            case STATE_DOC:
                iv_arrow.setImageResource(R.drawable.doctor);
                arrowState = STATE_DOC;
                break;
        }
    }

    //rotate the button when clicked
        private void setRotation(final ImageView image ,final int drawable) {
        //rotated 90d
            RotateAnimation rotationAnimation = new RotateAnimation(0, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotationAnimation.setDuration(100);
            rotationAnimation.setInterpolator(new LinearInterpolator());
            rotationAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    image.setImageResource(drawable);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            image.startAnimation(rotationAnimation);
        }
        private int setButtonPosition(int position){
          position = position + 1;
          if (position==5){
              position = 1;
              }
          return position;
        }

        private void setButtonImage(int state ){
            switch (state) {
                case STATE_AST:
                    setRotation(iv_button, R.drawable.rocket);
                    buttonState = STATE_AST;
                    break;
                case STATE_POL:
                    setRotation(iv_button, R.drawable.policecar);
                    buttonState = STATE_POL;
                    break;
                case STATE_POM:
                    setRotation(iv_button, R.drawable.pomp);
                    buttonState = STATE_POM;
                    break;
                case STATE_DOC:
                    setRotation(iv_button, R.drawable.emmblence);
                    buttonState = STATE_DOC;
                    break;
            }
        }

    }

