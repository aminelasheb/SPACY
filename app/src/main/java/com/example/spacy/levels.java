package com.example.spacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class levels extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
        private BottomNavigationView navView;
    public String lang;
    TextView Mes, Mesa;
    // Animation
    private Animation show_anim, hide_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);
        Intent intent = getIntent();
        String language = intent.getStringExtra("language");

        navView = findViewById(R.id.nav_view);

        navView= findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new learnFragment()).commit();

        // Init animations
        show_anim = AnimationUtils.loadAnimation(this, R.anim.show_nav_bar_animation);
        hide_anim = AnimationUtils.loadAnimation(this, R.anim.hide_nav_bar_animation);
        show_anim.setFillAfter(true);
        hide_anim.setFillAfter(true);
    }
    public void showNavBar(){
       navView.startAnimation(show_anim);
    }

    public void hideNavBar(){
        navView.startAnimation(hide_anim);
    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            Fragment selectedfragment=null;
            switch (item.getItemId()){
                case R.id.navigation_learn:
                    selectedfragment=new learnFragment();
                    break;
                case R.id.navigation_profil:
                    selectedfragment=new profilFragment();
                    break;
                case R.id.navigation_settings:
                    selectedfragment=new settingsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedfragment).commit();
            return true;
        }
    };
}


