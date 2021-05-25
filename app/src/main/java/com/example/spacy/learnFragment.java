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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;


public class learnFragment extends Fragment implements adapterRecycler.OnitemListener {
    private levels activity;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    // For animation logic
    private Boolean navBarVisible = true;


    //    MeowBottomNavigation MeowBottomNavigationview;
    Animation ast;
    private TextView text;
    private ImageView imageView;
    private TextView textView;
    TextView Mes, Mesa;
    String L1,L2,L3,L4,L5,L6,L7;
    String language;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root=LayoutInflater.from(getContext()).inflate(R.layout.fragment_learn,container,false);

        return root;
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_learn, container, false);
//        Mes = view.findViewById(R.id.mess);
//        Mesa = view.findViewById(R.id.mesa);
//        L1 = view.findViewById(R.id.l1);
//        L2 = view.findViewById(R.id.l2);
//        L3 = view.findViewById(R.id.l3);
//        L4 = view.findViewById(R.id.l4);
//        L5 = view.findViewById(R.id.l5);
//        L6 = view.findViewById(R.id.l6);
//        L7 = view.findViewById(R.id.l7);
//
//
//        return view;
//    }

    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<itemrecycler> itemlist=new ArrayList<>();
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        language = sharedPreferences.getString("LangApp","/");
        Mes = getView().findViewById(R.id.mess);
        Mesa = getView().findViewById(R.id.mesa);
        if (language.equals("العربية")) {
            Mes.setText("اهلاا");
            Mesa.setText("اختر مستوى \n و ابدا التعلم");
            itemlist.add(new itemrecycler(R.drawable.start1,L1="المستوى 1","الحروف ,الأرقام"));
            itemlist.add(new itemrecycler(R.drawable.start2,L2="المستوى 2","الألوان ,الأشكال"));
            itemlist.add(new itemrecycler(R.drawable.start3,L3="المستوى 3","الجسم ,الملابس"));
            itemlist.add(new itemrecycler(R.drawable.start4,L4="المستوى 4","العائلة ,المهن"));
            itemlist.add(new itemrecycler(R.drawable.start5,L5="المستوى 5","الفواكه ,الخضر"));
            itemlist.add(new itemrecycler(R.drawable.start6,L6="المستوى 6","الحيوانات"));
            itemlist.add(new itemrecycler(R.drawable.start7,L7="المستوى 7","الأشياء"));

        } else if (language.equals("Français")) {
            Mes.setText("Saluut");
            Mesa.setText("Choisissez un niveau \n Et commencez à apprendre");
            itemlist.add(new itemrecycler(R.drawable.start1,L1="Niveau 1","Alphabets ,Nombers"));
            itemlist.add(new itemrecycler(R.drawable.start2,L2="Niveau 2","Couleurs ,Formes"));
            itemlist.add(new itemrecycler(R.drawable.start3,L3="Niveau 3","Corps ,Vetements"));
            itemlist.add(new itemrecycler(R.drawable.start4,L4="Niveau 4", "Famille ,Professions"));
            itemlist.add(new itemrecycler(R.drawable.start5,L5="Niveau 5","Fruits ,Légumes"));
            itemlist.add(new itemrecycler(R.drawable.start6,L6="Niveau 6","Animaux "));
            itemlist.add(new itemrecycler(R.drawable.start7,L7="Niveau 7","Objects "));


        } else {
        Mes.setText("Hello there !!");
        Mesa.setText("Choose a level \n And start learning");
            itemlist.add(new itemrecycler(R.drawable.start1,L1="Level1","Alphabets ,Numbers"));
            itemlist.add(new itemrecycler(R.drawable.start2,L2="Level2","Colors ,Shapes"));
            itemlist.add(new itemrecycler(R.drawable.start3,L3="Level3","Body ,Clothes"));
            itemlist.add(new itemrecycler(R.drawable.start4,L4="Level4","Family ,Jobs"));
            itemlist.add(new itemrecycler(R.drawable.start5,L5="Level5","Fruit ,Vegetable"));
            itemlist.add(new itemrecycler(R.drawable.start6,L6="Level6","Animals"));
            itemlist.add(new itemrecycler(R.drawable.start7,L7="Level7","Objects"));


    }

        recyclerView=getView().findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(getActivity());
        mAdapter=new adapterRecycler(itemlist,this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);




//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//        language = sharedPreferences.getString("LangApp","/");
/////////////////////////////
//
//        Mes = view.findViewById(R.id.mess);
//        Mesa = view.findViewById(R.id.mesa);
//        L1 = view.findViewById(R.id.l1);
//        L2 = view.findViewById(R.id.l2);
//        L3 = view.findViewById(R.id.l3);
//        L4 = view.findViewById(R.id.l4);
//        L5 = view.findViewById(R.id.l5);
//        L6 = view.findViewById(R.id.l6);
//        L7 = view.findViewById(R.id.l7);
//
//
//
//
//
//
//
//
//        ////////////////////////////
//        if (language.equals("العربية")) {
//            Mes.setText("اهلاا");
//            Mesa.setText("اختر مستوى \n و ابدا التعلم");
//            L1.setText("المستوى 1");
//            L2.setText("المستوى 2");
//            L3.setText("المستوى 3");
//            L4.setText("المستوى 4");
//            L5.setText("المستوى 5");
//            L6.setText("المستوى 6");
//            L7.setText("المستوى 7");
//
//        } else if (language.equals("Français")) {
//            Mes.setText("Saluut");
//            Mesa.setText("Choisissez un niveau \n Et commencez à apprendre");
//            L1.setText("Niveau 1");
//            L2.setText("Niveau 2");
//            L3.setText("Niveau 3");
//            L4.setText("Niveau 4");
//            L5.setText("Niveau 5");
//            L6.setText("Niveau 6");
//            L7.setText("Niveau 7");
//
//
//        } else {
//        Mes.setText("Hello there !!");
//        Mesa.setText("Choose a level \n And start learning");
//        L1.setText("Level 1");
//        L2.setText("Level 2");
//        L3.setText("Level 3");
//        L4.setText("Level 4");
//        L5.setText("Level 5");
//        L6.setText("Level 6");
//        L7.setText("Level 7");
//
//
//    }

        //initialize your view here for use view.findViewById("your view id")
//        cardLevel1 = getView().findViewById(R.id.card1);
//        cardLevel6 = getView().findViewById(R.id.card6);
//        cardLevel7 = getView().findViewById(R.id.mycard);
//        cardLevel3 = getView().findViewById(R.id.card3);
//        cardLevel2 = getView().findViewById(R.id.card2);
//        cardLevel4 = getView().findViewById(R.id.card4);

//        cardLevel5=getView().findViewById(R.id.card5);
        ast = AnimationUtils.loadAnimation(getActivity(), R.anim.astro);
        imageView = getView().findViewById(R.id.astro2);
        imageView.setAnimation(ast);





        Mes.setVisibility(View.INVISIBLE);
        Mes.postDelayed(new Runnable() {
            @Override
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(700);
                Mes.startAnimation(alphaAnimation);
                Mes.setVisibility(View.VISIBLE);
            }
        }, 4000);
        Mes.postDelayed(new Runnable() {
            @Override
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                alphaAnimation.setDuration(700);
                Mes.startAnimation(alphaAnimation);
                Mes.setVisibility(View.INVISIBLE);

            }

        }, 7000);
        Mesa.setVisibility(View.INVISIBLE);
        boolean b = Mesa.postDelayed(new Runnable() {
            @Override
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(700);
                Mesa.startAnimation(alphaAnimation);
                Mesa.setVisibility(View.VISIBLE);
            }
        }, 8000);

//        cardLevel7.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent(getActivity(), level7menu.class);
//                intent.putExtra("language", language);
//                startActivity(intent);
//
//            }
//        });
//
//        cardLevel4.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent(getActivity(), JOFA.class);
//                intent.putExtra("language", language);
//                startActivity(intent);
//
//            }
//        });
//
//        cardLevel2.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent(getActivity(), CSQ.class);
//                intent.putExtra("language", language);
//                startActivity(intent);
//
//            }
//        });
//
//
//        cardLevel1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent(getActivity(), ANQ.class);
//                intent.putExtra("language", language);
//                startActivity(intent);
//
//            }
//        });
//
//        cardLevel6.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent(getActivity(), AQ.class);
//                intent.putExtra("language", language);
//                startActivity(intent);
//
//            }
//        });
//        cardLevel3.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent(getActivity(), level3menu.class);
//                intent.putExtra("language", language);
//                startActivity(intent);
//
//            }
//        });
//
//        cardLevel5.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent(getActivity(), level5menu.class);
//                intent.putExtra("language", language);
//                startActivity(intent);
//
//            }
//        });
        /////////////////////////////////////////////////////////////////////
      activity=(levels)getActivity();





        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy < 0){
                    // Scroll down
                    if (!navBarVisible){
                        activity.showNavBar();
                        navBarVisible = true;
                    }
                } else if (dy > 0){
                    // Scroll up
                    if (navBarVisible) {
                        activity.hideNavBar();
                        navBarVisible = false;
                    }
                }
            }
        });


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }

    private ArrayList<String> getRandomStringList(int size){
        ArrayList<String> randomList = new ArrayList<>();
        for (int i = 0; i < size; i++){
            randomList.add("Level " + i);
        }
        return randomList;
    }


    @Override
    public void onItemClick(int position) {
        if(position==0){
            Intent intent=new Intent(getActivity(),ANQ.class);
            intent.putExtra("Lang",L1);
            startActivity(intent);
        }
        if(position==1){
            Intent intent=new Intent(getActivity(),CSQ.class);
            intent.putExtra("Lang",L2);

            startActivity(intent);
        }
        if(position==2){
            Intent intent=new Intent(getActivity(),level3menu.class);
            intent.putExtra("Lang",L3);

            startActivity(intent);
        }
        if(position==3){
            Intent intent=new Intent(getActivity(),JOFA.class);
            intent.putExtra("Lang",L4);

            startActivity(intent);
        }
        if(position==4){
            Intent intent=new Intent(getActivity(),level5menu.class);
            intent.putExtra("Lang",L5);

            startActivity(intent);
        }
        if(position==5){
            Intent intent=new Intent(getActivity(),AQ.class);
            intent.putExtra("Lang",L6);

            startActivity(intent);
        }
        if(position==6){
            Intent intent=new Intent(getActivity(),level7menu.class);
            intent.putExtra("Lang",L7);

            startActivity(intent);
        }

    }
}