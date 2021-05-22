package com.example.spacy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class learnFragment extends Fragment {


    //    MeowBottomNavigation MeowBottomNavigationview;
    Animation ast;
    private CardView cardLevel1, cardLevel6, cardLevel2, cardLevel7,cardLevel3, cardLevel5 ,cardLevel4 ;
    private TextView text;
    private ImageView imageView;
    private TextView textView;
    TextView Mes, Mesa, L1, L2, L3, L4, L5, L6, L7;
    String language;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learn, container, false);
        Mes = view.findViewById(R.id.mess);
        Mesa = view.findViewById(R.id.mesa);
        L1 = view.findViewById(R.id.l1);
        L2 = view.findViewById(R.id.l2);
        L3 = view.findViewById(R.id.l3);
        L4 = view.findViewById(R.id.l4);
        L5 = view.findViewById(R.id.l5);
        L6 = view.findViewById(R.id.l6);
        L7 = view.findViewById(R.id.l7);


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        language = sharedPreferences.getString("LangApp","/");

        if (language.equals("العربية")) {
            Mes.setText("اهلاا");
            Mesa.setText("اختر مستوى \n و ابدا التعلم");
            L1.setText("المستوى 1");
            L2.setText("المستوى 2");
            L3.setText("المستوى 3");
            L4.setText("المستوى 4");
            L5.setText("المستوى 5");
            L6.setText("المستوى 6");
            L7.setText("المستوى 7");

        } else if (language.equals("Français")) {
            Mes.setText("Saluut");
            Mesa.setText("Choisissez un niveau \n Et commencez à apprendre");
            L1.setText("Niveau 1");
            L2.setText("Niveau 2");
            L3.setText("Niveau 3");
            L4.setText("Niveau 4");
            L5.setText("Niveau 5");
            L6.setText("Niveau 6");
            L7.setText("Niveau 7");


        } else {
        Mes.setText("Hello there !!");
        Mesa.setText("Choose a level \n And start learning");
        L1.setText("Level 1");
        L2.setText("Level 2");
        L3.setText("Level 3");
        L4.setText("Level 4");
        L5.setText("Level 5");
        L6.setText("Level 6");
        L7.setText("Level 7");


    }

        //initialize your view here for use view.findViewById("your view id")
        cardLevel1 = getView().findViewById(R.id.card1);
        cardLevel6 = getView().findViewById(R.id.card6);
        cardLevel7 = getView().findViewById(R.id.mycard);
        cardLevel3 = getView().findViewById(R.id.card3);
        cardLevel2 = getView().findViewById(R.id.card2);
        cardLevel4 = getView().findViewById(R.id.card4);

        cardLevel5=getView().findViewById(R.id.card5);
        ast = AnimationUtils.loadAnimation(getActivity(), R.anim.astro);
        imageView = getView().findViewById(R.id.astro2);
        imageView.setAnimation(ast);
//        MeowBottomNavigationview = (MeowBottomNavigation) getView().findViewById(R.id.bottom_navigation);
//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) MeowBottomNavigationview.getLayoutParams();
//        layoutParams.setBehavior(new ScrollHandler());

        textView = getView().findViewById(R.id.mess);
        text = getView().findViewById(R.id.mesa);


        textView.setVisibility(View.INVISIBLE);
        textView.postDelayed(new Runnable() {
            @Override
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(700);
                textView.startAnimation(alphaAnimation);
                textView.setVisibility(View.VISIBLE);
            }
        }, 4000);
        textView.postDelayed(new Runnable() {
            @Override
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                alphaAnimation.setDuration(700);
                textView.startAnimation(alphaAnimation);
                textView.setVisibility(View.INVISIBLE);

            }

        }, 7000);
        text.setVisibility(View.INVISIBLE);
        boolean b = text.postDelayed(new Runnable() {
            @Override
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(700);
                text.startAnimation(alphaAnimation);
                text.setVisibility(View.VISIBLE);
            }
        }, 8000);

        cardLevel7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), level7menu.class);
                intent.putExtra("language", language);
                startActivity(intent);

            }
        });

        cardLevel4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), JOFA.class);
                intent.putExtra("language", language);
                startActivity(intent);

            }
        });

        cardLevel2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), CSQ.class);
                intent.putExtra("language", language);
                startActivity(intent);

            }
        });


        cardLevel1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), ANQ.class);
                intent.putExtra("language", language);
                startActivity(intent);

            }
        });

        cardLevel6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), AQ.class);
                intent.putExtra("language", language);
                startActivity(intent);

            }
        });
        cardLevel3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), level3menu.class);
                intent.putExtra("language", language);
                startActivity(intent);

            }
        });

        cardLevel5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), level5menu.class);
                intent.putExtra("language", language);
                startActivity(intent);

            }
        });
    }


}