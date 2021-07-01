package com.example.spacy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.github.lzyzsd.circleprogress.CircleProgress;
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

    ProgressBar circleProgress;
    RecyclerView recyclerView;
    ImageView profile,plus ;
    TextView name,score,score2,score3,progress,txt5,a,f,aa ,sc;  final int PICK_IMAGE = 100;
    String GM ,Name ,IM ;
    int scoree,SCOREE;
    int SCORE=0 ;

    TextView email ,emailx ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_profil, container, false) ;

        profile = view.findViewById(R.id.profile_image) ;
        name =view.findViewById(R.id.Name) ;
        plus=view.findViewById(R.id.imageView5) ;
        score=view.findViewById(R.id.score);
        score2=view.findViewById(R.id.score2);
email=view.findViewById(R.id.txt2);
txt5=view.findViewById(R.id.text5);
a=view.findViewById(R.id.a) ;
sc=view.findViewById(R.id.scoreee);
        f=view.findViewById(R.id.f) ;
        aa=view.findViewById(R.id.aa) ;


        emailx=view.findViewById(R.id.txtx);
        progress=view.findViewById(R.id.text_view_progress);
        circleProgress=view.findViewById(R.id.progress_bar);
        score3=view.findViewById(R.id.score3);

        return view ;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String language = sharedPreferences.getString("LangApp", "/");
        if (language.equals("العربية")) {



            email.setText("البريد الالكتروني");
            txt5.setText("التقدم");
            sc.setText("مجموع النقاط");
            a.setText("الانجليزية");
            f.setText("الفرنسية");

            aa.setText("العربية");



        }
        else    if (language.equals("Français")) {



            email.setText("E-mail");
            txt5.setText("Mon progrès");
            sc.setText("Mon score");
            a.setText("Anglais");
            f.setText("Français");

            aa.setText("Arabe");



        }
        else {
            email.setText("E-mail");
            txt5.setText("My progrès");
            sc.setText("My score");
            a.setText("English");
            f.setText("French");

            aa.setText("Arabic");

        }
        String GM = sharedPreferences.getString("GM","/") ;
        String Name = sharedPreferences.getString("Name","/") ;
        String emaill = sharedPreferences.getString("email","/") ;

        String IM = sharedPreferences.getString("Image","/") ;

        if (GM.equals("LATER")) {
            email.setVisibility(View.GONE);
            emailx.setVisibility(View.GONE);
            if  (sharedPreferences.getString("Anglais","/").equals("true") ) {
                scoree=0 ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Anglais1","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Anglais2","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Anglais3","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Anglais4","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Anglais5","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Anglais6","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Anglais7","0")) ;

                SCOREE=SCOREE+scoree;
                if (scoree<=9) {score.setText("0"+scoree+"/70");}
                else if (scoree>9) {score.setText(+scoree+"/70");} }

            if  (sharedPreferences.getString("Français","/").equals("true") ) {
                scoree=0 ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Français1","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Français2","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Français3","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Français4","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Français5","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Français6","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Français7","0")) ;

                SCOREE=SCOREE+scoree;

                if (scoree<=9) {score2.setText("0"+scoree+"/70");}
                else if (scoree>9) {score2.setText(+scoree+"/70");} }

            if  (sharedPreferences.getString("Arabe","/").equals("true") ) {
                scoree=0 ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Arabe1","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Arabe2","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Arabe3","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Arabe4","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Arabe5","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Arabe6","0")) ;
                scoree=scoree+Integer.parseInt(sharedPreferences.getString("Arabe7","0")) ;

                SCOREE=SCOREE+scoree;

                if (scoree<=9) {score3.setText("0aaa"+scoree+"/70");}
                else if (scoree>9) {score3.setText("aaa"+scoree+"/70");} }

            progress.setText(SCOREE*100/210+"%");
            circleProgress.setProgress(SCOREE*100/210);

        }

        if (GM.equals("MAIL")) {
            if (email.getVisibility()==View.GONE) { email.setVisibility(View.VISIBLE);}
            if (emailx.getVisibility()==View.GONE) {emailx.setVisibility(View.VISIBLE);}

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
reference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
        name.setText(snapshot.child("username").getValue().toString());
        emailx.setText(snapshot.child("email").getValue().toString());
SCOREE=0;
        if  ( snapshot.hasChild("Anglais")) {
            scoree=0 ;
            if  ( snapshot.hasChild("Anglais1")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais1").getValue().toString()) ;}
            if  ( snapshot.hasChild("Anglais2")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais2").getValue().toString()); }
            if  ( snapshot.hasChild("Anglais3")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais3").getValue().toString()) ;}
            if  ( snapshot.hasChild("Anglais4")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais4").getValue().toString()); }
            if  ( snapshot.hasChild("Anglais5")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais5").getValue().toString()); }
            if  ( snapshot.hasChild("Anglais6")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais6").getValue().toString()); }
            if  ( snapshot.hasChild("Anglais7")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais7").getValue().toString()); }
            SCOREE=SCOREE+scoree;

            if (scoree<=9) {score.setText("0"+scoree+"/70");}
            else if (scoree>9) {score.setText(+scoree+"/70");} }

        if  ( snapshot.hasChild("Français")) {
            scoree=0 ;
            if  ( snapshot.hasChild("Français1")) { scoree=scoree+Integer.parseInt(snapshot.child("Français1").getValue().toString()) ;}
            if  ( snapshot.hasChild("Français2")) { scoree=scoree+Integer.parseInt(snapshot.child("Français2").getValue().toString()) ;}
            if  ( snapshot.hasChild("Français3")) { scoree=scoree+Integer.parseInt(snapshot.child("Français3").getValue().toString()) ;}
            if  ( snapshot.hasChild("Français4")) { scoree=scoree+Integer.parseInt(snapshot.child("Français4").getValue().toString()) ;}
            if  ( snapshot.hasChild("Français5")) { scoree=scoree+Integer.parseInt(snapshot.child("Français5").getValue().toString()) ;}
            if  ( snapshot.hasChild("Français6")) { scoree=scoree+Integer.parseInt(snapshot.child("Français6").getValue().toString()) ;}
            if  ( snapshot.hasChild("Français7")) { scoree=scoree+Integer.parseInt(snapshot.child("Français7").getValue().toString()) ;}
            SCOREE=SCOREE+scoree;

            if (scoree<=9) {score2.setText("0"+scoree+"/70");}
            else if (scoree>9) {score2.setText(+scoree+"/70");} }

        if  ( snapshot.hasChild("العربية")) {
            scoree=0 ;
            if  ( snapshot.hasChild("Arabe1")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe1").getValue().toString()) ;}
            if  ( snapshot.hasChild("Arabe2")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe2").getValue().toString()) ;}
            if  ( snapshot.hasChild("Arabe3")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe3").getValue().toString()) ;}
            if  ( snapshot.hasChild("Arabe4")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe4").getValue().toString()) ;}
            if  ( snapshot.hasChild("Arabe5")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe5").getValue().toString()) ;}
            if  ( snapshot.hasChild("Arabe6")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe6").getValue().toString()) ;}
            if  ( snapshot.hasChild("Arabe7")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe7").getValue().toString()) ;}
            SCOREE=SCOREE+scoree;

            if (scoree<=9) {score3.setText("0"+scoree+"/70");}
            else if (scoree>9) {score3.setText(+scoree+"/70");}}

        progress.setText(SCOREE*100/210+"%");
        circleProgress.setProgress(SCOREE*100/210);
    }

    @Override
    public void onCancelled(@NonNull @NotNull DatabaseError error) {

    }



});
        }


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });


        if (GM.equals("GOOGLE")) {

            if (email.getVisibility()==View.GONE) { email.setVisibility(View.VISIBLE);}
            if (emailx.getVisibility()==View.GONE) {emailx.setVisibility(View.VISIBLE);}

            plus.setAlpha(0f);
name.setText(Name);
emailx.setText(emaill) ;
            try {
                Picasso.with(getContext()).load(IM).into(profile);
            } catch (Exception e) {

            }
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("INFO").child(sharedPreferences.getString("acct", "/"));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    SCOREE=0 ;
                    if  ( snapshot.hasChild("Anglais")) {
                        scoree=0 ;
                        if  ( snapshot.hasChild("Anglais1")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais1").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Anglais2")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais2").getValue().toString()); }
                        if  ( snapshot.hasChild("Anglais3")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais3").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Anglais4")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais4").getValue().toString()); }
                        if  ( snapshot.hasChild("Anglais5")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais5").getValue().toString()); }
                        if  ( snapshot.hasChild("Anglais6")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais6").getValue().toString()); }
                        if  ( snapshot.hasChild("Anglais7")) { scoree=scoree+Integer.parseInt(snapshot.child("Anglais7").getValue().toString()); }
                        if (scoree<=9) {score.setText("0"+scoree+"/70");}
                        else if (scoree>9) {score.setText(+scoree+"/70");}
                        SCOREE=SCOREE+scoree;
                    }

                    if  ( snapshot.hasChild("Français")) {
                        scoree=0 ;
                        if  ( snapshot.hasChild("Français1")) { scoree=scoree+Integer.parseInt(snapshot.child("Français1").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Français2")) { scoree=scoree+Integer.parseInt(snapshot.child("Français2").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Français3")) { scoree=scoree+Integer.parseInt(snapshot.child("Français3").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Français4")) { scoree=scoree+Integer.parseInt(snapshot.child("Français4").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Français5")) { scoree=scoree+Integer.parseInt(snapshot.child("Français5").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Français6")) { scoree=scoree+Integer.parseInt(snapshot.child("Français6").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Français7")) { scoree=scoree+Integer.parseInt(snapshot.child("Français7").getValue().toString()) ;}
                        SCOREE=SCOREE+scoree;

                        if (scoree<=9) {score2.setText("0"+scoree+"/70");}
                        else if (scoree>9) {score2.setText(+scoree+"/70");} }



                    if  ( snapshot.hasChild("Arabe")) {
                        scoree=0 ;
                        if  ( snapshot.hasChild("Arabe1")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe1").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Arabe2")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe2").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Arabe3")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe3").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Arabe4")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe4").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Arabe5")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe5").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Arabe6")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe6").getValue().toString()) ;}
                        if  ( snapshot.hasChild("Arabe7")) { scoree=scoree+Integer.parseInt(snapshot.child("Arabe7").getValue().toString()) ;}
                        SCOREE=SCOREE+scoree;

                        if (scoree<=9) {score3.setText("0"+scoree+"/70");}
                        else if (scoree>9) {score3.setText(+scoree+"/70");}



                    }
                    progress.setText(SCOREE*100/210+"%");
                    circleProgress.setProgress(SCOREE*100/210);

                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }


    } ) ; }


//       sc = score2.getText().toString().charAt(0)+score2.getText().toString().charAt(1)+"";
//        scoree=scoree+Integer.parseInt(sc);
//        sc = score3.getText().toString().charAt(0)+score3.getText().toString().charAt(1)+"";
//
//        scoree=scoree+Integer.parseInt(sc);
//        scoree = scoree * 100;
//        double scoreee= scoree / 210 ;


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
}

}