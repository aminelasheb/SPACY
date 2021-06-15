package com.example.spacy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * create an instance of this fragment.
 */
public class profilFragment extends Fragment {
    ImageView profile,plus ;
    TextView name,english ,englishScore,french,frenchScore,Arab,arabicScore ;  final int PICK_IMAGE = 100;
    String GM ,Name ,ARsc ,FRsc ,ANsc ;
    String id,im ,IM;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_profil, container, false) ;
        profile = view.findViewById(R.id.profile_image) ;
        name =view.findViewById(R.id.Name) ;




        english=view.findViewById(R.id.anglais);
        englishScore=view.findViewById(R.id.Anscore);
        french=view.findViewById(R.id.French);
        frenchScore=view.findViewById(R.id.lang);
        Arab=view.findViewById(R.id.arab);
        arabicScore=view.findViewById(R.id.aScore);




        plus=view.findViewById(R.id.imageView5) ;
        return view ;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String act = sharedPreferences.getString("acct", "/");
        GM = sharedPreferences.getString("GM", "/");
        String IM = sharedPreferences.getString("Image","/") ;
        im = sharedPreferences.getString("image", "1"); changeim(im);

        SharedPreferences MyPre = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = MyPre.edit();


        english.setVisibility(View.GONE);
        englishScore.setVisibility(View.GONE);
        french.setVisibility(View.GONE);
        frenchScore.setVisibility(View.GONE);
        arabicScore.setVisibility(View.GONE);
        Arab.setVisibility(View.GONE);
        Name = sharedPreferences.getString("Name","/") ;
        if (GM.equals("MAIL")) { id = FirebaseAuth.getInstance().getCurrentUser().getUid() ;}
        else if (GM.equals("GOOGLE")) { id = act ;}

        if ((GM.equals("MAIL"))||(GM.equals("GOOGLE")) ) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(id);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                arabicScore.setText(snapshot.child("العربية").getValue().toString());
                frenchScore.setText(snapshot.child("Français").getValue().toString());
                englishScore.setText(snapshot.child("Anglais").getValue().toString());
                if (GM.equals("MAIL")) {
                    editor.putString("image", snapshot.child("image").getValue().toString());
                    editor.commit();
                }
                ARsc=arabicScore.getText().toString();
                        FRsc=frenchScore.getText().toString();
                                ANsc=englishScore.getText().toString() ;



                try {
                    if ((ARsc.equals("-1"))==false) {
                        arabicScore.setVisibility(View.VISIBLE);
                        Arab.setVisibility(View.VISIBLE);
                        arabicScore.setText(ARsc+"");

                    }

                    if (!(FRsc.equals("-1"))) {
                        frenchScore.setText(FRsc+"");
                        french.setVisibility(View.VISIBLE);
                        frenchScore.setVisibility(View.VISIBLE);
                    }

                    if (!(ANsc.equals("-1"))) {
                        englishScore.setText(ANsc+"");
                        englishScore.setVisibility(View.VISIBLE);
                        english.setVisibility(View.VISIBLE);
                    }
                } catch (Exception e) {  CharSequence text = e.getMessage();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(getContext(), text, duration);
                    toast.show();}





            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        }); }

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (im.equals("1")) {im="2";}
//                else if (im.equals("2")) {im="1";}


                SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences MyPre = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = MyPre.edit();


                if (sharedPreferences.getString("image", "/").equals("1")) {
                    editor.putString("image", "2");
                } else if (sharedPreferences.getString("image", "/").equals("2")) {
                    editor.putString("image", "1");
                }
                editor.commit();
                changeim(sharedPreferences.getString("image", "/"));


                if (GM.equals("MAIL")) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("image", im);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    reference.updateChildren(map);


                }

                if (GM.equals("MAIL")) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            name.setText(snapshot.child("username").getValue().toString());

                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });
                }


                if (GM.equals("GOOGLE")) {
                    plus.setAlpha(0f);
                    name.setText(Name);
                    try {
                        Picasso.with(getContext()).load(IM).into(profile);
                    } catch (Exception e) {

                    }


                }
            }


        });
    }

    private void changeim(String im) {
        if (im.equals("1")) {
            profile.setImageResource(R.drawable.child);
        } else if (im.equals("2")) {
            profile.setImageResource(R.drawable.girl);
        }
    }
    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        Uri imageUri;

        if (resultCode == getActivity().RESULT_OK && reqCode == 100){
            imageUri = data.getData();
            profile.setImageURI(imageUri);
            HashMap<String , Object> map = new HashMap<>();
            map.put("image" ,imageUri.toString());
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO");
            reference.updateChildren(map) ;
        }
} }