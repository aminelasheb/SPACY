
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
            itemlist.add(new itemrecycler(2,R.drawable.start1,L1="المستوى 1","الحروف ,الأرقام"));
            itemlist.add(new itemrecycler(2,R.drawable.start2,L2="المستوى 2","الألوان ,الأشكال"));
            itemlist.add(new itemrecycler(2,R.drawable.start3,L3="المستوى 3","الجسم ,الملابس"));
            itemlist.add(new itemrecycler(2,R.drawable.start4,L4="المستوى 4","العائلة ,المهن"));
            itemlist.add(new itemrecycler(2,R.drawable.start5,L5="المستوى 5","الفواكه ,الخضر"));
            itemlist.add(new itemrecycler(2,R.drawable.start6,L6="المستوى 6","الحيوانات"));
            itemlist.add(new itemrecycler(2,R.drawable.start7,L7="المستوى 7","الأشياء"));

        } else if (language.equals("Français")) {
            Mes.setText("Saluut");
            Mesa.setText("Choisissez un niveau \n Et commencez à apprendre");
            itemlist.add(new itemrecycler(1,R.drawable.start1,L1="Niveau 1","Alphabets ,Nombers"));
            itemlist.add(new itemrecycler(1,R.drawable.start2,L2="Niveau 2","Couleurs ,Formes"));
            itemlist.add(new itemrecycler(1,R.drawable.start3,L3="Niveau 3","Corps ,Vetements"));
            itemlist.add(new itemrecycler(1,R.drawable.start4,L4="Niveau 4", "Famille ,Professions"));
            itemlist.add(new itemrecycler(1,R.drawable.start5,L5="Niveau 5","Fruits ,Légumes"));
            itemlist.add(new itemrecycler(1,R.drawable.start6,L6="Niveau 6","Animaux "));
            itemlist.add(new itemrecycler(1,R.drawable.start7,L7="Niveau 7","Objects "));


        } else {
        Mes.setText("Hello there !!");
        Mesa.setText("Choose a level \n And start learning");
            itemlist.add(new itemrecycler(1,R.drawable.start1,L1="Level1","Alphabets ,Numbers"));
            itemlist.add(new itemrecycler(1,R.drawable.start2,L2="Level2","Colors ,Shapes"));
            itemlist.add(new itemrecycler(1,R.drawable.start3,L3="Level3","Body ,Clothes"));
            itemlist.add(new itemrecycler(1,R.drawable.start4,L4="Level4","Family ,Jobs"));
            itemlist.add(new itemrecycler(1,R.drawable.start5,L5="Level5","Fruit ,Vegetable"));
            itemlist.add(new itemrecycler(1,R.drawable.start6,L6="Level6","Animals"));
            itemlist.add(new itemrecycler(1,R.drawable.start7,L7="Level7","Objects"));


    }

        recyclerView=getView().findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(getActivity());
        mAdapter=new adapterRecycler(itemlist,this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);


        ast = AnimationUtils.loadAnimation(getActivity(), R.anim.astro);
        imageView = getView().findViewById(R.id.astro2);
        if(levels.counter==0){
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
            }, 2000);
            Mes.postDelayed(new Runnable() {
                @Override
                public void run() {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                    alphaAnimation.setDuration(1000);
                    Mes.startAnimation(alphaAnimation);
                    Mes.setVisibility(View.INVISIBLE);

                }

            }, 3500);
            Mesa.setVisibility(View.INVISIBLE);
            boolean b = Mesa.postDelayed(new Runnable() {
                @Override
                public void run() {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                    alphaAnimation.setDuration(700);
                    Mesa.startAnimation(alphaAnimation);
                    Mesa.setVisibility(View.VISIBLE);
                }
            }, 5300);

        }

Mes.setVisibility(View.GONE);



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

    }


    @Override
    public void onItemClick(int position) {
        if(position==0){
            Intent intent=new Intent(getActivity(),ANQ.class);

            intent.putExtra("Lang",L1);
            intent.putExtra("Level","1");

            startActivity(intent);
        }
        if(position==1){
            Intent intent=new Intent(getActivity(),CSQ.class);
            intent.putExtra("Lang",L2);
            intent.putExtra("Level","2");

            startActivity(intent);
        }
        if(position==2){
            Intent intent=new Intent(getActivity(),level3menu.class);
            intent.putExtra("Lang",L3);
            intent.putExtra("Level","3");

            startActivity(intent);
        }
        if(position==3){
            Intent intent=new Intent(getActivity(),JOFA.class);
            intent.putExtra("Lang",L4);
            intent.putExtra("Level","4");

            startActivity(intent);
        }
        if(position==4){
            Intent intent=new Intent(getActivity(),level5menu.class);
            intent.putExtra("Lang",L5);
            intent.putExtra("Level","5");

            startActivity(intent);
        }
        if(position==5){
            Intent intent=new Intent(getActivity(),AQ.class);
            intent.putExtra("Lang",L6);
            intent.putExtra("Level","6");

            startActivity(intent);
        }
        if(position==6){
            Intent intent=new Intent(getActivity(),level7menu.class);
            intent.putExtra("Lang",L7);
            intent.putExtra("Level","7");

            startActivity(intent);
        }

    }
}