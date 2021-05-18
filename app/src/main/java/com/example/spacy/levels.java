package com.example.spacy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class levels extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    public String lang;
    TextView Mes, Mesa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);
        Intent intent = getIntent();
        String language = intent.getStringExtra("language");


        //put him by default on learn fragment
        //assign variables
        bottomNavigation = findViewById(R.id.bottom_navigation);
        //add menu items
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_profil));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_learn));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_settings));


        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //initialize fragments
                Fragment fragment = null;
                switch (item.getId()) {
                    case 1:
                        //when id is 1
                        //initialize settings fragments
                        fragment = new profilFragment();
                        break;
                    case 2:
                        //when id is 2
                        //initialize learning fragmen
                        Bundle bundle = new Bundle();
                        bundle.putString("language", language);
// set Fragmentclass Arguments
                        fragment = new learnFragment();
                        fragment.setArguments(bundle);
                        break;
                    case 3:
                        fragment = new settingsFragment();


                }
                //loead fragment
                loadFragment(fragment);
            }
        });
        //navigate beetwen learn profil and settings
        bottomNavigation.show(2, true);
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });
    }

    private void loadFragment(Fragment fragment) {
        //Replace fragment
        //ndiro variable fragment li fiha settings wela learn wela el profil fe ---> layout fragment ta3na
        getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container, fragment).commit();
    }
}


