package com.example.spacy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.HashMap;

public class Quiz extends AppCompatActivity {

    private ImageView Questionimagee;
    private TextView optionA, optionB, optionC, optionD;
    private ImageView optionAi, optionBi, optionCi, optionDi;
    private TextView questionNumber, question, score;
    private TextView checkout1, checkout2;
    private View optionT, optionI;
    boolean Reponse = false;
    boolean correctanswer;
    boolean verifier,verifier1,verifier2,verifier3,verifier4,verifier5,verifier6,verifier7,verifier8;
String id ;
    boolean OptionAa,OptionBb,OptionCc,OptionDd,OptionAii,OptionBii,OptionCii,OptionDii ;
    ImageButton next;
    int currentIndex;
    int nbrquestion,c;
    int userscore = 0;
    int i;
    private MediaPlayer mMediaPlayer;
    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
    int qn = 1;
    ProgressBar progressBar;

    int currentQuestion, currentOptionA, currentOptionB, currentOptionC, currentOptionD, currentAnswer;


    private final answerClass[] questionBank = new answerClass[]{

            new answerClass(1, R.string.question1, R.string.question1_A, R.string.question1_B
                    , R.string.question1_C, R.string.question1_D, R.string.answer1),
            new answerClass(3, R.raw.benglish, R.string.question9_A, R.string.question9_B
                    , R.string.question9_C, R.string.question9_D, R.string.answer9),
            new answerClass(1, R.string.question2, R.string.question2_A, R.string.question2_B
                    , R.string.question2_C, R.string.question2_D, R.string.answer2),
            new answerClass(2, R.drawable.two, R.string.question6_A, R.string.question6_B
                    , R.string.question6_C, R.string.question6_D, R.string.answer6),
            new answerClass(1, R.string.question3, R.string.question3_A, R.string.question3_B
                    , R.string.question3_C, R.string.question3_D, R.string.answer3),
            new answerClass(5, R.raw.zerooo, R.drawable.zero, R.drawable.one
                    , R.drawable.seven, R.drawable.eight, R.drawable.zero),
            new answerClass(2, R.drawable.threee, R.string.question7_A, R.string.question7_B
                    , R.string.question7_C, R.string.question7_D, R.string.answer7),
            new answerClass(1, R.string.question5, R.string.question5_A, R.string.question5_B
                    , R.string.question5_C, R.string.question5_D, R.string.answer5),
            new answerClass(2, R.drawable.lettera, R.string.question8_A, R.string.question8_B
                    , R.string.question8_C, R.string.question8_D, R.string.answer8),
            new answerClass(3, R.raw.ninng, R.string.question10_A, R.string.question10_B
                    , R.string.question10_C, R.string.question10_D, R.string.answer10),

// 1 : Question text and replies text
            // 2 : Question image and replies text
            // 3 : Question vocal and replies text

            //4 : Question text and replies images
            // 5 : Question vocal and replies images

    };

    final int PROGRESS_BAR = (int) Math.ceil(100 / questionBank.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


//        questionNumber.setText(qn+"/"+questionBank.length+"Question");
//        score.setText("Score :"+userscore+"/"+questionBank.length);

        next=findViewById(R.id.nextbutton1);
        optionA = findViewById(R.id.Option1);
        optionB = findViewById(R.id.Option2);
        optionC = findViewById(R.id.Option3);
        optionD = findViewById(R.id.Option4);
        optionAi = findViewById(R.id.imageView1i);
        optionBi = findViewById(R.id.imageView2i);
        optionCi = findViewById(R.id.imageView3i);
        optionDi = findViewById(R.id.imageView4i);
        optionT = findViewById(R.id.TextOptions);
        optionI = findViewById(R.id.optioni);

        question = findViewById(R.id.Question);
        Questionimagee = findViewById(R.id.imagee);
        questionNumber = findViewById(R.id.QuestionNumber);
        score = findViewById(R.id.score);
        progressBar = findViewById(R.id.progress_bar);
        checkout1 = findViewById(R.id.select_option);
        checkout2 = findViewById(R.id.CorrectAnswer);

        if ((questionBank[currentIndex].getQc() == 1) || (questionBank[currentIndex].getQc() == 4)) {
            if (Questionimagee.getVisibility() != View.GONE) {
                Questionimagee.setVisibility(View.GONE);
            }
            if (question.getVisibility() == View.GONE) {
                question.setVisibility(View.VISIBLE);
            }

            currentQuestion = questionBank[currentIndex].getQuestionid();
            question.setText(currentQuestion);
        } else if (questionBank[currentIndex].getQc() == 2) {
            if (Questionimagee.getVisibility() == View.GONE) {
                Questionimagee.setVisibility(View.VISIBLE);
            }
            if (question.getVisibility() != View.GONE) {
                question.setVisibility(View.GONE);
            }
            currentQuestion = questionBank[currentIndex].getQuestionid();

            Questionimagee.setImageResource(currentQuestion);

        } else {
            Questionimagee.setImageResource(R.drawable.play);
            if (Questionimagee.getVisibility() == View.GONE) {
                Questionimagee.setVisibility(View.VISIBLE);
            }
            if (question.getVisibility() != View.GONE) {
                question.setVisibility(View.GONE);
            }
            Questionimagee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Questionimagee.animate().rotationBy(360).setDuration(1000);
                    releaseMediaPlayer();
                    mMediaPlayer = MediaPlayer.create(Quiz.this, questionBank[currentIndex].getQuestionid());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }
            });


        }

        currentOptionA = questionBank[currentIndex].getOptionA();
        currentOptionB = questionBank[currentIndex].getOptionB();
        currentOptionC = questionBank[currentIndex].getOptionC();
        currentOptionD = questionBank[currentIndex].getOptionD();

        if ((questionBank[currentIndex].getQc() == 1) || (questionBank[currentIndex].getQc() == 2) || (questionBank[currentIndex].getQc() == 3)) {
            if (optionT.getVisibility() == View.GONE) {
                optionT.setVisibility(View.VISIBLE);
            }
            if (optionI.getVisibility() != View.GONE) {
                optionI.setVisibility(View.GONE);
            }


            optionA.setText(currentOptionA);
            optionB.setText(currentOptionB);
            optionC.setText(currentOptionC);
            optionD.setText(currentOptionD);
        } else {
            if (optionI.getVisibility() == View.GONE) {
                optionI.setVisibility(View.VISIBLE);
            }
            if (optionT.getVisibility() != View.GONE) {
                optionT.setVisibility(View.GONE);
            }
            optionAi.setImageResource(currentOptionA);
            optionBi.setImageResource(currentOptionB);
            optionCi.setImageResource(currentOptionC);
            optionDi.setImageResource(currentOptionD);

        }

        score.setText("Score :" + userscore + "/" + questionBank.length);
        questionNumber.setText(qn + "/" + questionBank.length + " Question");


        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Reponse == false) {
                    Reponse = true;
                    optionA.setBackgroundColor(0xFF323360);
                    verifier=true;
                    verifier1=false; verifier2=false; verifier3=false; verifier4=false;
                    verifier5=false; verifier6=false; verifier7=false;
                   // boolean resultt = checkAnswer(currentOptionA);
                    //if (resultt) {
                    //    userscore=userscore ;
                        //optionA.setBackgroundColor(0xFF00FF00);
                        //OptionAa = true;
                    //} else {
                        //optionA.setBackgroundColor(0xFFFF0000);
                      //  OptionAa=false;
                    //}


                }

            }
        });


        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Reponse == false) {
                    Reponse = true;
                    optionB.setBackgroundColor(0xFF323360);
                    verifier1=true;
                    verifier=false; verifier2=false; verifier3=false; verifier4=false;
                    verifier5=false; verifier6=false; verifier7=false;

                   // boolean resulttt = checkAnswer(currentOptionB);
                    //if (resulttt) {
                      //  userscore=userscore-1 ;
                        //optionB.setBackgroundColor(0xFF00FF00);
                       // OptionBb = true;
                    //} else {
                        //optionB.setBackgroundColor(0xFFFF0000);
                      //  OptionBb = false;
                    //}



                }
            }
        });


        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Reponse == false) {
                    Reponse = true;
                    optionC.setBackgroundColor(0xFF323360);
                    verifier2=true;
                    verifier=false; verifier1=false; verifier3=false; verifier4=false;
                    verifier5=false; verifier6=false; verifier7=false;

                    //boolean resultttt = checkAnswer(currentOptionC);
                    //if (resultttt) {
                      //  userscore=userscore-1 ;
                        //optionC.setBackgroundColor(0xFF00FF00);
                        //OptionCc = true;
                    //} else {
                        //optionC.setBackgroundColor(0xFFFF0000);
                      //  OptionAa = false;
                    //}


                }
            }
        });


        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Reponse == false) {
                    Reponse = true;
                    optionD.setBackgroundColor(0xFF323360);
                    verifier3=true;
                    verifier=false; verifier1=false; verifier2=false; verifier4=false;
                    verifier5=false; verifier6=false; verifier7=false;

                  //  userscore=userscore-1;
                   // if (OptionDd==false){
                     //   userscore=userscore+1;
                   // }

                }
            }
        });

        optionAi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Reponse == false) {
                    Reponse = true;
                    optionAi.setBackgroundColor(0xFF323360);
                    verifier4=true;
                    verifier=false; verifier1=false; verifier3=false; verifier2=false;
                    verifier5=false; verifier6=false; verifier7=false;

                    boolean resultt4 = checkAnsweri(currentOptionA);
                    if (resultt4) {
                        userscore=userscore-1 ;
                        // optionAi.setBackgroundColor(0xFF00FF00);
                        OptionAii = true;
                    } else {
                        //optionAi.setBackgroundColor(0xFFFF0000);
                        OptionAii = false;
                    }

                    checkAnsweri(currentOptionA);

                }

            }

        });


        optionBi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Reponse == false) {
                    Reponse = true;
                    optionBi.setBackgroundColor(0xFF323360);
                    verifier5=true;
                    verifier=false; verifier1=false; verifier3=false; verifier4=false;
                    verifier2=false; verifier6=false; verifier7=false;

                    boolean resultt5 = checkAnsweri(currentOptionB);
                    if (resultt5) {
                        userscore=userscore-1 ;
                        //optionBi.setBackgroundColor(0xFF00FF00);
                        OptionBii = true;
                    } else {
                        //optionBi.setBackgroundColor(0xFFFF0000);
                        OptionBii = false;
                    }

                    checkAnsweri(currentOptionB);
                    userscore=userscore-1 ;
                }
            }
        });


        optionCi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Reponse == false) {
                    Reponse = true;
                    optionCi.setBackgroundColor(0xFF323360);
                    verifier6=true;
                    verifier=false; verifier1=false; verifier3=false; verifier4=false;
                    verifier5=false; verifier2=false; verifier7=false;

                    boolean resultt6 = checkAnsweri(currentOptionC);
                    if (resultt6) {
                        userscore=userscore-1 ;
                        //optionCi.setBackgroundColor(0xFF00FF00);
                        OptionCii = true;
                    } else {
                        //optionCi.setBackgroundColor(0xFFFF0000);
                        OptionCii = false;
                    }

                    checkAnsweri(currentOptionC);
                    userscore=userscore-1 ;
                }
            }
        });


        optionDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Reponse == false) {
                    Reponse = true;
                    optionDi.setBackgroundColor(0xFF323360);
                    verifier7=true;
                    verifier=false; verifier1=false; verifier3=false; verifier4=false;
                    verifier5=false; verifier6=false; verifier2=false;

                    userscore=userscore-1;
                    if (OptionDii==false){
                        userscore=userscore+1;
                    }
                    checkAnsweri(currentOptionD);
                    userscore=userscore-1 ;
                }

            }


        });



    }

    private void updateQuestionn() {

        boolean correctansweri = checkAnsweri(currentOptionA);
        boolean correctanswerib = checkAnsweri(currentOptionB);
        boolean correctansweric = checkAnsweri(currentOptionC);
        boolean correctanswerid = checkAnsweri(currentOptionD);
        boolean correctanswer = checkAnswer(currentOptionA);
        boolean correctanswerb = checkAnswer(currentOptionB);
        boolean correctanswerc = checkAnswer(currentOptionC);
        boolean correctanswerd = checkAnswer(currentOptionD);

        if (verifier) {
            boolean result = checkAnswer(currentOptionA);
            if (result) {
                optionA.setBackgroundColor(0xFF00FF00);
                userscore=userscore-1;
                OptionAa = true;
            } else {
                optionA.setBackgroundColor(0xFFFF0000);
                OptionAa = false;
            }
            checkAnswer(currentOptionA);
        }



        if (verifier1) {
            boolean result1 = checkAnswer(currentOptionB);
            if (result1) {
                optionB.setBackgroundColor(0xFF00FF00);
                OptionBb = true;
                userscore=userscore-1;
            } else {
                optionB.setBackgroundColor(0xFFFF0000);
                OptionBb = false;
            }
            checkAnswer(currentOptionB);
        }
        if (verifier2) {
            boolean result2 = checkAnswer(currentOptionC);
            if (result2) {

                optionC.setBackgroundColor(0xFF00FF00);
                userscore=userscore-1;
                OptionCc = true;
            } else {
                optionC.setBackgroundColor(0xFFFF0000);
                OptionCc = false;
            }
            checkAnswer(currentOptionC);
        }
        if (verifier3) {
            boolean result3 = checkAnswer(currentOptionD);
            if (result3) {
                userscore=userscore-1;
                optionD.setBackgroundColor(0xFF00FF00);
                OptionDd = true;
            } else {
                optionD.setBackgroundColor(0xFFFF0000);
                OptionDd = false;
            }
            checkAnswer(currentOptionD);
        }
        if (verifier4) {
            boolean result4 = checkAnsweri(currentOptionA);
            if (result4) {
                userscore=userscore-1;
                OptionAii = true;
                optionAi.setBackgroundColor(0xFF00FF00);
            } else {
                OptionAii = false;
                optionAi.setBackgroundColor(0xFFFF0000);

            }
        }
        if (verifier5) {
            boolean result5 = checkAnsweri(currentOptionB);
            if (result5) {
                userscore=userscore-1;
                OptionBii = true;
                optionBi.setBackgroundColor(0xFF00FF00);
            } else {
                OptionBii = false;
                optionBi.setBackgroundColor(0xFFFF0000);

            }
        }
        if (verifier6) {
            boolean result6 = checkAnsweri(currentOptionC);
            if (result6) {
                userscore=userscore-1;
                OptionCii = true;
                optionCi.setBackgroundColor(0xFF00FF00);
            } else {
                OptionCii = false;
                optionCi.setBackgroundColor(0xFFFF0000);

            }
        }
        if (verifier7) {
            boolean result7 = checkAnsweri(currentOptionD);
            if (result7) {
                userscore=userscore-1;
                OptionDii = true;
                optionDi.setBackgroundColor(0xFF00FF00);
            } else {
                OptionDii = false;
                optionDi.setBackgroundColor(0xFFFF0000);

            }
        }

        if (correctanswer == true){
               userscore=userscore-1 ;
               optionA.setBackgroundColor(0xFF00FF00);
           }
        if (correctanswerb == true){
            userscore=userscore-1 ;

            optionB.setBackgroundColor(0xFF00FF00);
        }
        if (correctanswerc == true){
            userscore=userscore-1 ;

            optionC.setBackgroundColor(0xFF00FF00);
        }
        if (correctanswerd == true){
            userscore=userscore-1 ;

            optionD.setBackgroundColor(0xFF00FF00);
        }
        if (correctansweri == true){
            userscore=userscore-1 ;

            optionAi.setBackgroundColor(0xFF00FF00);
        }
        if (correctanswerib == true){
            userscore=userscore-1 ;

            optionBi.setBackgroundColor(0xFF00FF00);
        }
        if (correctansweric == true){
            userscore=userscore-1 ;

            optionCi.setBackgroundColor(0xFF00FF00);
        }
        if (correctanswerid == true){
            userscore=userscore-1 ;

            optionDi.setBackgroundColor(0xFF00FF00);
        }


    }




    private void updateQuestion() {
        Reponse=false;
        optionA.setBackgroundColor(1);
        optionB.setBackgroundColor(1);
        optionC.setBackgroundColor(1);
        optionD.setBackgroundColor(1);
        optionAi.setBackgroundColor(1);
        optionBi.setBackgroundColor(1);
        optionCi.setBackgroundColor(1);
        optionDi.setBackgroundColor(1);





        currentIndex = (currentIndex + 1) % questionBank.length;
        if (currentIndex == 0) {

            SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
            String GM = sharedPreferences.getString("GM","/") ;
            if (GM.equals("MAIL")||GM.equals("GOOGLE")) {
                if (GM.equals("MAIL")) {id=FirebaseAuth.getInstance().getCurrentUser().getUid() ;}
                else if (GM.equals("GOOGLE")) {id = sharedPreferences.getString("acct", "/"); ;}
            HashMap<String , Object> map = new HashMap<>();
            map.put("Anglais" ,userscore+"");
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(id);
            reference.updateChildren(map) ; }
            else if (GM.equals("LATER")) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Anglais1", userscore+"");
                editor.commit();
            }
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your score: " + userscore + "/" + questionBank.length);
            alert.setPositiveButton("Back to app ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });

            alert.setNegativeButton("Repeat Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    userscore = 0;
                    qn = 1;
                    progressBar.setProgress(0);
                    score.setText("Score :" + userscore + "/" + questionBank.length);
                    questionNumber.setText(qn + "/" + questionBank.length + " Question");


                }
            });
            alert.show();
        }
        currentOptionA = questionBank[currentIndex].getOptionA();
        currentOptionB = questionBank[currentIndex].getOptionB();
        currentOptionC = questionBank[currentIndex].getOptionC();
        currentOptionD = questionBank[currentIndex].getOptionD();

        if ((questionBank[currentIndex].getQc() == 1) || (questionBank[currentIndex].getQc() == 4)) {
            if (Questionimagee.getVisibility() != View.GONE) {
                Questionimagee.setVisibility(View.GONE);
            }
            if (question.getVisibility() == View.GONE) {
                question.setVisibility(View.VISIBLE);
            }

            currentQuestion = questionBank[currentIndex].getQuestionid();
            question.setText(currentQuestion);
        } else if (questionBank[currentIndex].getQc() == 2) {
            if (Questionimagee.getVisibility() == View.GONE) {
                Questionimagee.setVisibility(View.VISIBLE);
            }
            if (question.getVisibility() != View.GONE) {
                question.setVisibility(View.GONE);
            }
            currentQuestion = questionBank[currentIndex].getQuestionid();

            Questionimagee.setImageResource(currentQuestion);

        } else {
            Questionimagee.setImageResource(R.drawable.play);
            if (Questionimagee.getVisibility() == View.GONE) {
                Questionimagee.setVisibility(View.VISIBLE);
            }
            if (question.getVisibility() != View.GONE) {
                question.setVisibility(View.GONE);
            }
            Questionimagee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Questionimagee.animate().rotationBy(360).setDuration(1000);
                    releaseMediaPlayer();
                    mMediaPlayer = MediaPlayer.create(Quiz.this, questionBank[currentIndex].getQuestionid());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }
            });


        }


        if ((questionBank[currentIndex].getQc() == 1) || (questionBank[currentIndex].getQc() == 2) || (questionBank[currentIndex].getQc() == 3)) {
            if (optionT.getVisibility() == View.GONE) {
                optionT.setVisibility(View.VISIBLE);
            }
            if (optionI.getVisibility() != View.GONE) {
                optionI.setVisibility(View.GONE);
            }


            optionA.setText(currentOptionA);
            optionB.setText(currentOptionB);
            optionC.setText(currentOptionC);
            optionD.setText(currentOptionD);
        } else {
            if (optionI.getVisibility() == View.GONE) {
                optionI.setVisibility(View.VISIBLE);
            }
            if (optionT.getVisibility() != View.GONE) {
                optionT.setVisibility(View.GONE);
            }
            optionAi.setImageResource(currentOptionA);
            optionBi.setImageResource(currentOptionB);
            optionCi.setImageResource(currentOptionC);
            optionDi.setImageResource(currentOptionD);

        }

        if (qn < questionBank.length) {
            qn = qn + 1;
            questionNumber.setText(qn + "/" + questionBank.length + "Question");
        }

        score.setText("Score :" + userscore + "/" + questionBank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);



    }



    private boolean checkAnswer(int currentSelection) {

        int currentAnswer = questionBank[currentIndex].getAnswerid();
        checkout1.setText(currentSelection);
        checkout2.setText(currentAnswer);

        if (checkout1.getText().toString().trim().equals(checkout2.getText().toString().trim())) {
//            Toast toast = Toast.makeText(this, "Right ✅!", FancyToast.LENGTH_LONG);
//            toast.show();
            //FancyToast.makeText(this, "Right ✅!", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
            userscore = userscore +1;
            return true;
        } else {
//        {                 Toast toast = Toast.makeText(this, "Wrong ❌!", FancyToast.LENGTH_LONG);
//            toast.show();

            //FancyToast.makeText(this, "Wrong ❌!", FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
            return false;
        }
    }

    private boolean checkAnsweri(int currentSelection) {

        int currentAnswer = questionBank[currentIndex].getAnswerid();
//        checkout1.setText(currentSelection);
//        checkout2.setText(currentAnswer);

        if (currentSelection == currentAnswer) {
//            Toast toast = Toast.makeText(this, "Right ✅!", FancyToast.LENGTH_LONG);
//            toast.show();
            //FancyToast.makeText(this, "Right ✅!", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
            userscore=userscore+1 ;
            return true;
        } else{
//        {                 Toast toast = Toast.makeText(this, "Wrong ❌!", FancyToast.LENGTH_LONG);
//            toast.show();

            //FancyToast.makeText(this, "Wrong ❌!", FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();

            return false;
        }
    }



    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }


    public void updateQuestion(View view) {

        updateQuestion();




    }
    public void updateQuestionn(View view) {
        updateQuestionn();




    }
}
