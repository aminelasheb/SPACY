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

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);
        //put him by default on learn fragment
        //assign variables
//        bottomNavigation = findViewById(R.id.bottom_navigation);
//        //add menu items
//        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_profil));
//        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_learn));
//        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_settings));


//        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
//            @Override
//            public void onShowItem(MeowBottomNavigation.Model item) {
//                //initialize fragments
//                Fragment fragment = null;
//                switch (item.getId()) {
//                    case 1:
//                        //when id is 1
//                        //initialize settings fragments
//                        fragment = new profilFragment();
//                        break;
//                    case 2:
//                        //when id is 2
//                        //initialize learning fragmen
//                        Bundle bundle = new Bundle();
//                        bundle.putString("language", language);
//// set Fragmentclass Arguments
//                        fragment = new learnFragment();
//                        fragment.setArguments(bundle);
//                        break;
//                    case 3:
//                        fragment = new settingsFragment();
//
//
//                }
//                //loead fragment
//                loadFragment(fragment);
//            }
//        });
//        //navigate beetwen learn profil and settings
//        bottomNavigation.show(2, true);
//        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
//            @Override
//            public void onClickItem(MeowBottomNavigation.Model item) {
//
//            }
//        });
//        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
//            @Override
//            public void onReselectItem(MeowBottomNavigation.Model item) {
//
//            }
//        });
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

//    private void loadFragment(Fragment fragment) {
//        //Replace fragment
//        //ndiro variable fragment li fiha settings wela learn wela el profil fe ---> layout fragment ta3na
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container, fragment).commit();
//    }

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


