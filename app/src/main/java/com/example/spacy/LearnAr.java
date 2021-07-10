package com.example.spacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.intellij.lang.annotations.Language;

import java.util.ArrayList;

public class LearnAr extends AppCompatActivity {
    //initialize variable
    ViewPager vpVertical, vpHorizontal;
    private MediaPlayer mMediaPlayer;
    private adaptervp adaptervpp;
    private ArrayList<aymenmodel> aymenmodelArrayList;
    private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    RelativeLayout learn;

    TextView ident, ident2;

    int[] vocals;
    boolean whitee;
    String level, languageLearn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_ar);
        ImageView im = findViewById(R.id.speakerfrf1);

        ident = findViewById(R.id.ident);
        ident2 = findViewById(R.id.ident2);
        learn = findViewById(R.id.back);
        //assign variable
        SharedPreferences sharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String Language = sharedPreferences.getString("LangApp", "/");
        Intent intent = getIntent();

        level = intent.getStringExtra("Level");
        languageLearn = sharedPreferences.getString("LangLearn", "/");

        whitee = false;

        if (level.equals("1")) {
            learn.setBackgroundResource(R.drawable.artff1);
            whitee = true;

            ident.setText("الحروف");


        }

        if (level.equals("1/2")) {
            whitee = true;

            learn.setBackgroundResource(R.drawable.artff1);
            ident.setText("الأرقام");
        }
        if (level.equals("2")) {
            learn.setBackgroundResource(R.drawable.artff4);
            ident.setText("الألوان");

        }
        if (level.equals("2/2")) {
            learn.setBackgroundResource(R.drawable.artff4);
            ident.setText("الأشكال");

        }
        if (level.equals("3")) {
            learn.setBackgroundResource(R.drawable.artff3);
            ident.setText("الجسم");

        }

        if (level.equals("3/2")) {
            learn.setBackgroundResource(R.drawable.artff3);
            ident.setText("الملابس");

        }
        if (level.equals("4")) {
            learn.setBackgroundResource(R.drawable.artff2);
            ident.setText("العائلة");

        }
        if (level.equals("4/2")) {
            learn.setBackgroundResource(R.drawable.artff2);
            ident.setText("المهن");

        }
        if (level.equals("5")) {
            learn.setBackgroundResource(R.drawable.artff5);
            ident.setText("الفواكه");

        }
        if (level.equals("5/2")) {
            learn.setBackgroundResource(R.drawable.artff5);
            ident.setText("الخضر");

        }
        if (level.equals("6")) {
            learn.setBackgroundResource(R.drawable.artff6);
            ident.setText("الحيوانات");

        }
        if (level.equals("7")) {
            learn.setBackgroundResource(R.drawable.artff7);
            ident.setText("الأشياء");

        }


        if (whitee) {
            ident2.setTextColor(Color.WHITE);
            ident.setTextColor(Color.WHITE);
        }
        vpHorizontal = findViewById(R.id.vp_horizontal2f);
        loadcards();

        if ((level.equals("1")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.aenglish, R.raw.benglish, R.raw.cenglish, R.raw.demglish, R.raw.eenglish, R.raw.fenglish, R.raw.genglish, R.raw.henglish
                    , R.raw.ienglish, R.raw.jenglish, R.raw.kenglish, R.raw.lenglish, R.raw.menglish, R.raw.nenglish, R.raw.oenglish, R.raw.penglish, R.raw.qenglish, R.raw.renglish
                    , R.raw.senglish, R.raw.tenglish, R.raw.uenglish, R.raw.venglish, R.raw.wenglish, R.raw.xenglish, R.raw.yenglish, R.raw.zenglish,};
        } else if ((level.equals("1")) && languageLearn.equals("Fr")) {
            vocals = new int[]{R.raw.alettrefr, R.raw.blettfr, R.raw.clettrefr, R.raw.dlettre, R.raw.efr, R.raw.flettrefr, R.raw.glettrefr, R.raw.hlettrefr
                    , R.raw.ilettrefr, R.raw.jlettrefr, R.raw.klettrefr, R.raw.lfr, R.raw.mfr, R.raw.nnfr, R.raw.oofr, R.raw.ppfr, R.raw.qqfr, R.raw.rrfr
                    , R.raw.ssfr, R.raw.ttfr, R.raw.ufr, R.raw.vvfr, R.raw.wwfr, R.raw.xfr, R.raw.yfr, R.raw.zfr,};
        } else if ((level.equals("1/2")) && languageLearn.equals("Fr")) {
            vocals = new int[]{R.raw.f00, R.raw.f01, R.raw.f02, R.raw.f03, R.raw.f04, R.raw.f05, R.raw.f06, R.raw.f07
                    , R.raw.f08, R.raw.f09, R.raw.f10};
        } else if ((level.equals("1/2")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.zerooo, R.raw.oneng, R.raw.twooo, R.raw.threeng, R.raw.fourng,
                    R.raw.fiveng, R.raw.sixg, R.raw.sevenng, R.raw.eight, R.raw.ninng, R.raw.tenng};

        } else if ((level.equals("2")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.black, R.raw.whitee, R.raw.yelloww, R.raw.purplee, R.raw.red,
                    R.raw.pinkk, R.raw.grey, R.raw.green, R.raw.brown, R.raw.bleu, R.raw.orangee};

        } else if ((level.equals("2")) && languageLearn.equals("Fr")) {
            int[] vocals = {R.raw.noir, R.raw.blanc, R.raw.jaune, R.raw.violet, R.raw.rouge,
                    R.raw.rose, R.raw.gris, R.raw.vert, R.raw.marron, R.raw.bleufr, R.raw.orangeee};
        } else if ((level.equals("2/2")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.square, R.raw.triangle, R.raw.circle, R.raw.rectangle, R.raw.oval,
                    R.raw.star, R.raw.rohmbus, R.raw.pentagon, R.raw.hexagon, R.raw.heart};

        } else if ((level.equals("2/2")) && languageLearn.equals("Fr")) {
            vocals = new int[]{R.raw.carree, R.raw.trianglee, R.raw.cercle, R.raw.rectanglee, R.raw.ovale,
                    R.raw.etoile, R.raw.losange, R.raw.pentagone, R.raw.hexagone, R.raw.coeur};

        } else if ((level.equals("3")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.head, R.raw.face, R.raw.hair, R.raw.eye, R.raw.nose, R.raw.ear, R.raw.mouth, R.raw.hand
                    , R.raw.arm, R.raw.leg, R.raw.calf, R.raw.foot,};
        } else if ((level.equals("3")) && languageLearn.equals("Fr")) {
            vocals = new int[]{R.raw.tete, R.raw.visage, R.raw.chv, R.raw.ey2, R.raw.nez, R.raw.orl, R.raw.bouch, R.raw.main
                    , R.raw.bras, R.raw.jambe, R.raw.mollet, R.raw.pied,};
        } else if ((level.equals("3/2")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.shirt, R.raw.pant, R.raw.boot, R.raw.casqq, R.raw.cap, R.raw.gloves,
                    R.raw.glasses, R.raw.skirt, R.raw.jacket, R.raw.costt, R.raw.ring, R.raw.watch
            };
        } else if ((level.equals("3/2")) && languageLearn.equals("Fr")) {
            vocals = new int[]{R.raw.ttshirt, R.raw.pantalon, R.raw.botte, R.raw.cass1, R.raw.chape, R.raw.gants, R.raw.lunettes,
                    R.raw.jupe, R.raw.veste, R.raw.costume, R.raw.bague, R.raw.montre
            };
        } else if ((level.equals("4")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.jadi1, R.raw.grm1, R.raw.dad1, R.raw.mom1, R.raw.bgb1, R.raw.sis1, R.raw.bbb1, R.raw.ancl1
                    , R.raw.ant1, R.raw.csns1};
        } else if ((level.equals("4")) && languageLearn.equals("Fr")) {
            vocals = new int[]{R.raw.grp2, R.raw.grm2, R.raw.dad2, R.raw.mom2, R.raw.bgb2, R.raw.sis2, R.raw.bbb2, R.raw.ancl2
                    , R.raw.ant2, R.raw.csns2};
        } else if ((level.equals("6")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.cow, R.raw.dog, R.raw.elephant, R.raw.fox, R.raw.giraffe,
                    R.raw.horse, R.raw.lion, R.raw.monkey, R.raw.panda, R.raw.snake, R.raw.gorilla, R.raw.rabit};
        } else if ((level.equals("4/2")) && languageLearn.equals("Fr")) {
            vocals = new int[]{R.raw.astro, R.raw.dcer, R.raw.infrm2, R.raw.prof2, R.raw.plc2, R.raw.pmp, R.raw.arc2, R.raw.mc2
                    , R.raw.bcr2, R.raw.chef2, R.raw.cffr2, R.raw.fct2, R.raw.agr2, R.raw.pcr2};
        } else if ((level.equals("4/2")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.astr, R.raw.doc, R.raw.nrc, R.raw.tch, R.raw.plc, R.raw.frft, R.raw.artan, R.raw.buil
                    , R.raw.lumbr, R.raw.chefan, R.raw.hair, R.raw.pst, R.raw.frm, R.raw.snn};
        } else if ((level.equals("5")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.ailan, R.raw.betteravean, R.raw.carottean, R.raw.concombrean, R.raw.laituean, R.raw.leekan,
                    R.raw.maiisan, R.raw.oberginean, R.raw.onionan, R.raw.pepperan, R.raw.pommedeterrean, R.raw.shampignonan,
                    R.raw.tomatean};
        } else if ((level.equals("5")) && languageLearn.equals("Fr")) {
            vocals = new int[]{R.raw.tomatte, R.raw.pommedeterre, R.raw.poivron, R.raw.onion, R.raw.obergine, R.raw.courgette,
                    R.raw.fenouil, R.raw.concombre, R.raw.choufleur, R.raw.champignon, R.raw.carotte, R.raw.brocoli,
                    R.raw.betterave, R.raw.artichaut, R.raw.maiis, R.raw.petitpois, R.raw.aiie, R.raw.laitue};
        } else if ((level.equals("5/2")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.abricotan, R.raw.apple, R.raw.bannanean, R.raw.cerisean, R.raw.figan,
                    R.raw.kiwian, R.raw.mango, R.raw.melonan, R.raw.orangean, R.raw.pear, R.raw.peech, R.raw.pineapple, R.raw.pomegranarte,
                    R.raw.raisingrabes, R.raw.strawberry, R.raw.watermelon};
        } else if ((level.equals("5/2")) && languageLearn.equals("Fr")) {
            vocals = new int[]{R.raw.abricot, R.raw.ananas, R.raw.avocat, R.raw.bannane, R.raw.cerise, R.raw.citron, R.raw.figue, R.raw.fraise,
                    R.raw.kiwi, R.raw.grenade, R.raw.framboise, R.raw.mangue, R.raw.melon, R.raw.noixdecoco, R.raw.orange, R.raw.peche,
                    R.raw.pomme, R.raw.poire, R.raw.raisin, R.raw.pastheque};
        } else if ((level.equals("6")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.cow, R.raw.dog, R.raw.elephant, R.raw.fox, R.raw.giraffe,
                    R.raw.horse, R.raw.lion, R.raw.monkey, R.raw.panda, R.raw.snake, R.raw.gorilla, R.raw.rabit};
        } else if ((level.equals("6")) && languageLearn.equals("Fr")) {
            vocals = new int[]{R.raw.catfr, R.raw.cowfr, R.raw.dogfr, R.raw.elephantfr, R.raw.foxfr, R.raw.girafefr,
                    R.raw.gorillafr, R.raw.horsefr, R.raw.lionfr, R.raw.monkeyfr, R.raw.rabitfr, R.raw.snakefr,};
        } else if ((level.equals("7")) && languageLearn.equals("An")) {
            vocals = new int[]{R.raw.backpack, R.raw.chair, R.raw.drums, R.raw.hammer, R.raw.pillow, R.raw.computer, R.raw.bed, R.raw.clock, R.raw.book, R.raw.ball, R.raw.keys, R.raw.shoes
            };
        } else if ((level.equals("7")) && languageLearn.equals("Fr")) {
            vocals = new int[]{R.raw.sacados, R.raw.chaise, R.raw.batterie, R.raw.marteau, R.raw.oreiller, R.raw.ordinateur, R.raw.lit, R.raw.horloge, R.raw.livres, R.raw.ballon, R.raw.cles, R.raw.chaussure
            };
        } else if ((level.equals("1")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.alifara, R.raw.baaara, R.raw.taaara, R.raw.thaaara, R.raw.jimara, R.raw.haara, R.raw.khaara,
                    R.raw.dalara, R.raw.dhalara, R.raw.raaara, R.raw.zayara, R.raw.sinara, R.raw.chineara, R.raw.sadara,
                    R.raw.dhaara, R.raw.ttara, R.raw.dhaara, R.raw.ayenara, R.raw.ghayenara, R.raw.faaara, R.raw.kafara,
                    R.raw.kafeara, R.raw.lamara, R.raw.mimara, R.raw.nonara, R.raw.haara, R.raw.wawara, R.raw.yaara,};

        } else if ((level.equals("1/2")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.a00, R.raw.a01, R.raw.a02, R.raw.a03, R.raw.a04, R.raw.a05, R.raw.a06, R.raw.a07
                    , R.raw.a08, R.raw.a09, R.raw.a10ar};
        } else if ((level.equals("2")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.blackar, R.raw.whitear, R.raw.yellowar, R.raw.purplear, R.raw.redar,
                    R.raw.pinkar, R.raw.greyar, R.raw.greenar, R.raw.brownar, R.raw.bleuar, R.raw.orangear};
        } else if ((level.equals("2/2")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.squarear, R.raw.trianglear, R.raw.circlear, R.raw.rectanglear, R.raw.ovalear,
                    R.raw.starar, R.raw.rohmbusar, R.raw.pentagoar, R.raw.hexagonar, R.raw.heartar};
        } else if ((level.equals("3")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.tet, R.raw.vsg, R.raw.chvv, R.raw.ain, R.raw.anf, R.raw.odon, R.raw.fam, R.raw.yad, R.raw.dra
                    , R.raw.sak, R.raw.sakk, R.raw.kadm,};
        } else if ((level.equals("4")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.grp3, R.raw.grm, R.raw.dad3, R.raw.mom3, R.raw.bgb3, R.raw.sis3, R.raw.bbb3, R.raw.ancl3
                    , R.raw.ant3, R.raw.csns3};
        } else if ((level.equals("7")) && languageLearn.equals("Ar")) {
        } else if ((level.equals("3/2")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.kamis, R.raw.serwal, R.raw.hidaa, R.raw.kobaa, R.raw.kobaa, R.raw.kofazat,
                    R.raw.nadarat, R.raw.tanora, R.raw.miitaf, R.raw.badlat, R.raw.khatem, R.raw.saaa,};
        } else if ((level.equals("4/2")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.arbas, R.raw.ardoc, R.raw.armom, R.raw.armm3, R.raw.plc3, R.raw.pmp3, R.raw.arc3, R.raw.mc3
                    , R.raw.hatt3, R.raw.khob, R.raw.hala9, R.raw.fac3, R.raw.falh, R.raw.say};
        } else if ((level.equals("5")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.baazilaa, R.raw.badhinjan, R.raw.bassal, R.raw.brookli, R.raw.carottear, R.raw.champignonar, R.raw.felfel,
                    R.raw.khass, R.raw.kheyar, R.raw.lifte, R.raw.maiisar, R.raw.pommedeterrear, R.raw.thoum, R.raw.tomattear};
        } else if ((level.equals("5/2")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.dattear, R.raw.ananasar, R.raw.cerisear, R.raw.citronar, R.raw.figuear, R.raw.fraisear, R.raw.mawza,
                    R.raw.grenadear, R.raw.mechmech, R.raw.orangear, R.raw.khoukh, R.raw.pommear, R.raw.raisinar, R.raw.pasthequear};
        } else if ((level.equals("6")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.catar, R.raw.dogar, R.raw.elephantar, R.raw.foxar,
                    R.raw.horsear, R.raw.lionar, R.raw.monkeyar, R.raw.pandaar, R.raw.snakear,

                    R.raw.rabitar};
        } else if ((level.equals("7")) && languageLearn.equals("Ar")) {
            vocals = new int[]{R.raw.ha9iba, R.raw.korsi, R.raw.table, R.raw.mitra9a, R.raw.wisada, R.raw.hasoub, R.raw.sarir, R.raw.sa3a, R.raw.kitab, R.raw.kora, R.raw.mafati7, R.raw.hidae
            };
        }


        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(LearnAr.this, vocals[vpHorizontal.getCurrentItem()]);

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }


    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    private void loadcards() {

        aymenmodelArrayList = new ArrayList<>();

        if ((level.equals("1")) && languageLearn.equals("Ar")) {
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.alif2021));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.baa2021));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.taa2021));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.ttaa2021));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.jim2021));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.haa2021));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.khaa2021));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.douaa1215));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.diab56655));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.roro5565));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.zincvchewiya2332));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.sin5453));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.chin254));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.sad52));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.ddad547));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.ttta587));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.dadno545));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.abass554));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.ghin455));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.faa5245));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.kkada54));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.kahfj56));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.lala154));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.mim345));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.naa));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.haap));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.waw5653));
            aymenmodelArrayList.add(new aymenmodel("",R.drawable.yay4665));
        }

        else if ((level.equals("1/2")) && languageLearn.equals("Ar")) {
            aymenmodelArrayList.add(new aymenmodel("صفر",R.drawable.zero));
            aymenmodelArrayList.add(new aymenmodel("واحد",R.drawable.one));
            aymenmodelArrayList.add(new aymenmodel("اثنان",R.drawable.two));
            aymenmodelArrayList.add(new aymenmodel("ثلاثة", R.drawable.threee));
            aymenmodelArrayList.add(new aymenmodel("أربعة",R.drawable.four));
            aymenmodelArrayList.add(new aymenmodel("خمسة",R.drawable.five));
            aymenmodelArrayList.add(new aymenmodel("ستة",R.drawable.six));
            aymenmodelArrayList.add(new aymenmodel("سبعة",R.drawable.seven));
            aymenmodelArrayList.add(new aymenmodel("ثمانية",R.drawable.eight));
            aymenmodelArrayList.add(new aymenmodel("تسعة",R.drawable.nine));
            aymenmodelArrayList.add(new aymenmodel("عشرة",R.drawable.ten));
        }

        else if ((level.equals("2")) && languageLearn.equals("Ar")) {
            aymenmodelArrayList.add(new aymenmodel("أسود",R.drawable.black));
            aymenmodelArrayList.add(new aymenmodel("أبيض",R.drawable.white));
            aymenmodelArrayList.add(new aymenmodel("أصفر",R.drawable.yellow));
            aymenmodelArrayList.add(new aymenmodel("بنفسجي", R.drawable.violet));
            aymenmodelArrayList.add(new aymenmodel("أحمر",R.drawable.red));
            aymenmodelArrayList.add(new aymenmodel("وردي",R.drawable.pink));
            aymenmodelArrayList.add(new aymenmodel("رمادي",R.drawable.greyy));
            aymenmodelArrayList.add(new aymenmodel("أخضر",R.drawable.green));
            aymenmodelArrayList.add(new aymenmodel("بني",R.drawable.brown));
            aymenmodelArrayList.add(new aymenmodel("أزرق",R.drawable.bleu));
            aymenmodelArrayList.add(new aymenmodel("برتقالي",R.drawable.orange1));


        }

        else if ((level.equals("2/2")) && languageLearn.equals("Ar")) {

            aymenmodelArrayList.add(new aymenmodel("مربع",R.drawable.square));
            aymenmodelArrayList.add(new aymenmodel("مثلث",R.drawable.triangle));
            aymenmodelArrayList.add(new aymenmodel("دائرة",R.drawable.circle));
            aymenmodelArrayList.add(new aymenmodel("مستطيل", R.drawable.rectangle));
            aymenmodelArrayList.add(new aymenmodel("بيضوي",R.drawable.oval));
            aymenmodelArrayList.add(new aymenmodel("نجمة",R.drawable.star));
            aymenmodelArrayList.add(new aymenmodel("معين",R.drawable.rhombus));
            aymenmodelArrayList.add(new aymenmodel("خماسي",R.drawable.pentagon));
            aymenmodelArrayList.add(new aymenmodel("سداسي",R.drawable.hexagon));
            aymenmodelArrayList.add(new aymenmodel("قلب",R.drawable.heart));

        }

        else if ((level.equals("3")) && languageLearn.equals("Ar")) {
            aymenmodelArrayList.add(new aymenmodel("رأس",R.drawable.head1));
            aymenmodelArrayList.add(new aymenmodel("وجه",R.drawable.face));
            aymenmodelArrayList.add(new aymenmodel("شعر",R.drawable.hair4));
            aymenmodelArrayList.add(new aymenmodel("عين", R.drawable.eye));
            aymenmodelArrayList.add(new aymenmodel("أنف",R.drawable.nose));
            aymenmodelArrayList.add(new aymenmodel("أذن",R.drawable.orl));
            aymenmodelArrayList.add(new aymenmodel("فم",R.drawable.bouch));
            aymenmodelArrayList.add(new aymenmodel("يد",R.drawable.mainn));
            aymenmodelArrayList.add(new aymenmodel("ذراع",R.drawable.bras));
            aymenmodelArrayList.add(new aymenmodel("ساق",R.drawable.jambe1));
            aymenmodelArrayList.add(new aymenmodel("ربلة الساق",R.drawable.mollet));
            aymenmodelArrayList.add(new aymenmodel("قدم",R.drawable.pied));

        }

        else if ((level.equals("3/2")) && languageLearn.equals("Ar")) {
            aymenmodelArrayList.add(new aymenmodel("قميص",R.drawable.shirt));
            aymenmodelArrayList.add(new aymenmodel("سروال",R.drawable.pantalon));
            aymenmodelArrayList.add(new aymenmodel("حذاء",R.drawable.boot1));
            aymenmodelArrayList.add(new aymenmodel("قبعة", R.drawable.caskette));
            aymenmodelArrayList.add(new aymenmodel("قبعة",R.drawable.chapeau));
            aymenmodelArrayList.add(new aymenmodel("قفازات",R.drawable.gloves1));
            aymenmodelArrayList.add(new aymenmodel("نظارات",R.drawable.glasses));
            aymenmodelArrayList.add(new aymenmodel("تنورة",R.drawable.skirt));
            aymenmodelArrayList.add(new aymenmodel("معطف",R.drawable.veste1));
            aymenmodelArrayList.add(new aymenmodel("بدلة",R.drawable.cost1));
            aymenmodelArrayList.add(new aymenmodel("خاتم",R.drawable.bag));
            aymenmodelArrayList.add(new aymenmodel("ساعة",R.drawable.watches));



        }

        else if ((level.equals("4")) && languageLearn.equals("Ar")) {
            aymenmodelArrayList.add(new aymenmodel("الجد",R.drawable.grapa));
            aymenmodelArrayList.add(new aymenmodel("الجدة",R.drawable.grama));
            aymenmodelArrayList.add(new aymenmodel("ابي",R.drawable.dad));
            aymenmodelArrayList.add(new aymenmodel("امي", R.drawable.mam));
            aymenmodelArrayList.add(new aymenmodel("اخي الاكبر",R.drawable.bigbro));
            aymenmodelArrayList.add(new aymenmodel("اختي",R.drawable.sis));
            aymenmodelArrayList.add(new aymenmodel("اخي الصغير",R.drawable.baby));
            aymenmodelArrayList.add(new aymenmodel("خالي",R.drawable.ancl));
            aymenmodelArrayList.add(new aymenmodel("عمتي",R.drawable.antt));
            aymenmodelArrayList.add(new aymenmodel("ابناء العم",R.drawable.cons));

        }

        else if ((level.equals("4/2")) && languageLearn.equals("Ar")) {

            aymenmodelArrayList.add(new aymenmodel("عالم فضاء",R.drawable.astronome));
            aymenmodelArrayList.add(new aymenmodel("طبيب",R.drawable.doctor));
            aymenmodelArrayList.add(new aymenmodel("ممرضة",R.drawable.infirmiere));
            aymenmodelArrayList.add(new aymenmodel("معلم", R.drawable.prof));
            aymenmodelArrayList.add(new aymenmodel("شرطي",R.drawable.policier));
            aymenmodelArrayList.add(new aymenmodel("رجل اطفاء",R.drawable.pompier));
            aymenmodelArrayList.add(new aymenmodel("مهندس معماري",R.drawable.architecte));
            aymenmodelArrayList.add(new aymenmodel("بناء",R.drawable.macon));
            aymenmodelArrayList.add(new aymenmodel("حطاب",R.drawable.bucheron));
            aymenmodelArrayList.add(new aymenmodel("طباخ",R.drawable.chef));
            aymenmodelArrayList.add(new aymenmodel("حلاق",R.drawable.coiffeur));
            aymenmodelArrayList.add(new aymenmodel("ساعي بريد",R.drawable.facteur));
            aymenmodelArrayList.add(new aymenmodel("فلاح",R.drawable.agriculteur));
            aymenmodelArrayList.add(new aymenmodel("صياد",R.drawable.pecheur));

        }

        else if ((level.equals("5")) && languageLearn.equals("Ar")) {    aymenmodelArrayList=new ArrayList<>();
            aymenmodelArrayList.add(new aymenmodel("بازلاء",R.drawable.petitpois));
            aymenmodelArrayList.add(new aymenmodel("باذنجان",R.drawable.obergine));
            aymenmodelArrayList.add(new aymenmodel("بصل",R.drawable.onion));
            aymenmodelArrayList.add(new aymenmodel("بروكلي",R.drawable.brocoli));
            aymenmodelArrayList.add(new aymenmodel("جزر", R.drawable.carotte));
            aymenmodelArrayList.add(new aymenmodel("فطر",R.drawable.champignon));
            aymenmodelArrayList.add(new aymenmodel("فلفل",R.drawable.felfel));
            aymenmodelArrayList.add(new aymenmodel("خس",R.drawable.laitue));
            aymenmodelArrayList.add(new aymenmodel("خيار",R.drawable.concombre));
            aymenmodelArrayList.add(new aymenmodel("ذرة",R.drawable.maiis));
            aymenmodelArrayList.add(new aymenmodel("بطاطا",R.drawable.pommedeterre));
            aymenmodelArrayList.add(new aymenmodel("ثوم",R.drawable.ail));
            aymenmodelArrayList.add(new aymenmodel("طماطم",R.drawable.tomatte));
        }
        else if ((level.equals("5/2")) && languageLearn.equals("Ar")) {    aymenmodelArrayList.add(new aymenmodel("تمر",R.drawable.datte));
            aymenmodelArrayList.add(new aymenmodel("أناناس",R.drawable.ananas));
            aymenmodelArrayList.add(new aymenmodel("كرز",R.drawable.cerise));
            aymenmodelArrayList.add(new aymenmodel("ليمون", R.drawable.citron));
            aymenmodelArrayList.add(new aymenmodel("تين",R.drawable.figue));
            aymenmodelArrayList.add(new aymenmodel("فراولة",R.drawable.fraise));
            aymenmodelArrayList.add(new aymenmodel(" موز",R.drawable.bannane));
            aymenmodelArrayList.add(new aymenmodel("رمان",R.drawable.grenade));
            aymenmodelArrayList.add(new aymenmodel("مشمش",R.drawable.abricot));
            aymenmodelArrayList.add(new aymenmodel("برتقال",R.drawable.orangee));
            aymenmodelArrayList.add(new aymenmodel("خوخ",R.drawable.peche));
            aymenmodelArrayList.add(new aymenmodel("تفاح",R.drawable.pomme));
            aymenmodelArrayList.add(new aymenmodel("عنب",R.drawable.raisin));
            aymenmodelArrayList.add(new aymenmodel("بطيخ",R.drawable.pastheque));

        }
        else if ((level.equals("6")) && languageLearn.equals("Ar")) {

            aymenmodelArrayList.add(new aymenmodel("قط",R.drawable.cat));
            aymenmodelArrayList.add(new aymenmodel("كلب",R.drawable.dog));
            aymenmodelArrayList.add(new aymenmodel("فيل",R.drawable.elepant));
            aymenmodelArrayList.add(new aymenmodel("ثعلب", R.drawable.fox));
            aymenmodelArrayList.add(new aymenmodel("حصان",R.drawable.horse));
            aymenmodelArrayList.add(new aymenmodel("أسد",R.drawable.lion));
            aymenmodelArrayList.add(new aymenmodel("قرد",R.drawable.monkey));
            aymenmodelArrayList.add(new aymenmodel("باندا",R.drawable.panda));
            aymenmodelArrayList.add(new aymenmodel("ثعبان",R.drawable.snake));
            aymenmodelArrayList.add(new aymenmodel("أرنب",R.drawable.rabbit));

        }

        else if ((level.equals("7")) && languageLearn.equals("Ar"))  {   aymenmodelArrayList.add(new aymenmodel("حقيبة ظهر",R.drawable.backpack));
            aymenmodelArrayList.add(new aymenmodel("كرسي",R.drawable.chair));
            aymenmodelArrayList.add(new aymenmodel("طبل",R.drawable.drum));
            aymenmodelArrayList.add(new aymenmodel("مطرقة", R.drawable.hammer));
            aymenmodelArrayList.add(new aymenmodel("وسادة",R.drawable.pillow));
            aymenmodelArrayList.add(new aymenmodel("حاسوب",R.drawable.pc));
            aymenmodelArrayList.add(new aymenmodel("سرير",R.drawable.bed));
            aymenmodelArrayList.add(new aymenmodel("ساعة",R.drawable.clock));
            aymenmodelArrayList.add(new aymenmodel("كتاب",R.drawable.book));
            aymenmodelArrayList.add(new aymenmodel("كرة",R.drawable.ball));
            aymenmodelArrayList.add(new aymenmodel("مفاتيح",R.drawable.keys));
            aymenmodelArrayList.add(new aymenmodel("حذاء",R.drawable.shoes));}


        else if (((level.equals("1")) && languageLearn.equals("An")) || ((level.equals("1")) && languageLearn.equals("Fr"))) {


            aymenmodelArrayList.add(new aymenmodel("", R.drawable.let0a));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.b));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.c));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.lettd));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.elett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.flett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.glett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.hlett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.ilett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.jlett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.klett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.llett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.mlett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.nlett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.olett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.plett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.qlett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.rlett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.slett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.tlett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.ulett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.vlett));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.wlet));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.xlet));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.ylet));
            aymenmodelArrayList.add(new aymenmodel("", R.drawable.zlet));
        } else if ((level.equals("1/2")) && languageLearn.equals("Fr")) {

            aymenmodelArrayList.add(new aymenmodel("Zéro", R.drawable.zero));
            aymenmodelArrayList.add(new aymenmodel("Un", R.drawable.one));
            aymenmodelArrayList.add(new aymenmodel("Deux", R.drawable.two));
            aymenmodelArrayList.add(new aymenmodel("Trois", R.drawable.threee));
            aymenmodelArrayList.add(new aymenmodel("Quatre", R.drawable.four));
            aymenmodelArrayList.add(new aymenmodel("Cinq", R.drawable.five));
            aymenmodelArrayList.add(new aymenmodel("Six", R.drawable.six));
            aymenmodelArrayList.add(new aymenmodel("Sept", R.drawable.seven));
            aymenmodelArrayList.add(new aymenmodel("Huit", R.drawable.eight));
            aymenmodelArrayList.add(new aymenmodel("Neuf", R.drawable.nine));
            aymenmodelArrayList.add(new aymenmodel("Dix", R.drawable.ten));

        } else if ((level.equals("1/2")) && languageLearn.equals("An")) {
            aymenmodelArrayList.add(new aymenmodel("Zero", R.drawable.zero));
            aymenmodelArrayList.add(new aymenmodel("One", R.drawable.one));
            aymenmodelArrayList.add(new aymenmodel("Two", R.drawable.two));
            aymenmodelArrayList.add(new aymenmodel("Three", R.drawable.threee));
            aymenmodelArrayList.add(new aymenmodel("Four", R.drawable.four));
            aymenmodelArrayList.add(new aymenmodel("Five", R.drawable.five));
            aymenmodelArrayList.add(new aymenmodel("Six", R.drawable.six));
            aymenmodelArrayList.add(new aymenmodel("Seven", R.drawable.seven));
            aymenmodelArrayList.add(new aymenmodel("Eight", R.drawable.eight));
            aymenmodelArrayList.add(new aymenmodel("Nine", R.drawable.nine));
            aymenmodelArrayList.add(new aymenmodel("Ten", R.drawable.ten));

        } else if ((level.equals("2")) && languageLearn.equals("An")) {


            aymenmodelArrayList.add(new aymenmodel("Black", R.drawable.black));
            aymenmodelArrayList.add(new aymenmodel("White", R.drawable.white));
            aymenmodelArrayList.add(new aymenmodel("Yellow", R.drawable.yellow));
            aymenmodelArrayList.add(new aymenmodel("Purple", R.drawable.violet));
            aymenmodelArrayList.add(new aymenmodel("Red", R.drawable.red));
            aymenmodelArrayList.add(new aymenmodel("Pink", R.drawable.pink));
            aymenmodelArrayList.add(new aymenmodel("Grey", R.drawable.greyy));
            aymenmodelArrayList.add(new aymenmodel("Green", R.drawable.green));
            aymenmodelArrayList.add(new aymenmodel("Brown", R.drawable.brown));
            aymenmodelArrayList.add(new aymenmodel("Bleu", R.drawable.bleu));
            aymenmodelArrayList.add(new aymenmodel("Orange", R.drawable.orange1));
        } else if ((level.equals("2")) && languageLearn.equals("Fr")) {
            aymenmodelArrayList.add(new aymenmodel("Noir", R.drawable.black));
            aymenmodelArrayList.add(new aymenmodel("Blanc", R.drawable.white));
            aymenmodelArrayList.add(new aymenmodel("Jaune", R.drawable.yellow));
            aymenmodelArrayList.add(new aymenmodel("Violet", R.drawable.violet));
            aymenmodelArrayList.add(new aymenmodel("Rouge", R.drawable.red));
            aymenmodelArrayList.add(new aymenmodel("Rose", R.drawable.pink));
            aymenmodelArrayList.add(new aymenmodel("Gris", R.drawable.greyy));
            aymenmodelArrayList.add(new aymenmodel("Vert", R.drawable.green));
            aymenmodelArrayList.add(new aymenmodel("Marron", R.drawable.brown));
            aymenmodelArrayList.add(new aymenmodel("Bleu", R.drawable.bleu));
            aymenmodelArrayList.add(new aymenmodel("Orange", R.drawable.orange1));
        } else if ((level.equals("2/2")) && languageLearn.equals("Fr")) {

            aymenmodelArrayList.add(new aymenmodel("Carrée", R.drawable.square));
            aymenmodelArrayList.add(new aymenmodel("Triangle", R.drawable.triangle));
            aymenmodelArrayList.add(new aymenmodel("Cercle", R.drawable.circle));
            aymenmodelArrayList.add(new aymenmodel("Rectangle", R.drawable.rectangle));
            aymenmodelArrayList.add(new aymenmodel("Ovale", R.drawable.oval));
            aymenmodelArrayList.add(new aymenmodel("Star", R.drawable.star));
            aymenmodelArrayList.add(new aymenmodel("Etoile", R.drawable.rhombus));
            aymenmodelArrayList.add(new aymenmodel("Pentagone", R.drawable.pentagon));
            aymenmodelArrayList.add(new aymenmodel("Hexagone", R.drawable.hexagon));
            aymenmodelArrayList.add(new aymenmodel("Coeur", R.drawable.heart));
        } else if ((level.equals("2/2")) && languageLearn.equals("An")) {

            aymenmodelArrayList.add(new aymenmodel("Square", R.drawable.square));
            aymenmodelArrayList.add(new aymenmodel("Triangle", R.drawable.triangle));
            aymenmodelArrayList.add(new aymenmodel("Circle", R.drawable.circle));
            aymenmodelArrayList.add(new aymenmodel("Rectangle", R.drawable.rectangle));
            aymenmodelArrayList.add(new aymenmodel("Oval", R.drawable.oval));
            aymenmodelArrayList.add(new aymenmodel("Star", R.drawable.star));
            aymenmodelArrayList.add(new aymenmodel("Rohmbus", R.drawable.rhombus));
            aymenmodelArrayList.add(new aymenmodel("Pentagon", R.drawable.pentagon));
            aymenmodelArrayList.add(new aymenmodel("Hexagon", R.drawable.hexagon));
            aymenmodelArrayList.add(new aymenmodel("Heart", R.drawable.heart));
        } else if ((level.equals("3")) && languageLearn.equals("An")) {
            aymenmodelArrayList.add(new aymenmodel("head", R.drawable.head1));
            aymenmodelArrayList.add(new aymenmodel("face", R.drawable.face));
            aymenmodelArrayList.add(new aymenmodel("hair", R.drawable.hair4));
            aymenmodelArrayList.add(new aymenmodel("Eye", R.drawable.eye));
            aymenmodelArrayList.add(new aymenmodel("nose", R.drawable.nose));
            aymenmodelArrayList.add(new aymenmodel("Ear", R.drawable.orl));
            aymenmodelArrayList.add(new aymenmodel("mouth", R.drawable.bouch));
            aymenmodelArrayList.add(new aymenmodel("hand", R.drawable.mainn));
            aymenmodelArrayList.add(new aymenmodel("arm", R.drawable.bras));
            aymenmodelArrayList.add(new aymenmodel("leg", R.drawable.jambe1));
            aymenmodelArrayList.add(new aymenmodel("calf", R.drawable.mollet));
            aymenmodelArrayList.add(new aymenmodel("foot", R.drawable.pied));

        } else if ((level.equals("3")) && languageLearn.equals("Fr")) {
            aymenmodelArrayList.add(new aymenmodel("tête", R.drawable.head1));
            aymenmodelArrayList.add(new aymenmodel("visage", R.drawable.face));
            aymenmodelArrayList.add(new aymenmodel("cheveu", R.drawable.hair4));
            aymenmodelArrayList.add(new aymenmodel("Eye", R.drawable.eye));
            aymenmodelArrayList.add(new aymenmodel("nez", R.drawable.nose));
            aymenmodelArrayList.add(new aymenmodel("oreille", R.drawable.orl));
            aymenmodelArrayList.add(new aymenmodel("bouche", R.drawable.bouch));
            aymenmodelArrayList.add(new aymenmodel("main", R.drawable.mainn));
            aymenmodelArrayList.add(new aymenmodel("bras", R.drawable.bras));
            aymenmodelArrayList.add(new aymenmodel("jambe", R.drawable.jambe1));
            aymenmodelArrayList.add(new aymenmodel("mollet", R.drawable.mollet));
            aymenmodelArrayList.add(new aymenmodel("pied", R.drawable.pied));
        } else if ((level.equals("3/2")) && languageLearn.equals("An")) {
            aymenmodelArrayList.add(new aymenmodel("tee-shirt", R.drawable.shirt));
            aymenmodelArrayList.add(new aymenmodel("pant", R.drawable.pantalon));
            aymenmodelArrayList.add(new aymenmodel("boot", R.drawable.boot1));
            aymenmodelArrayList.add(new aymenmodel("casquette", R.drawable.caskette));
            aymenmodelArrayList.add(new aymenmodel("cap", R.drawable.chapeau));
            aymenmodelArrayList.add(new aymenmodel("Gloves", R.drawable.gloves1));
            aymenmodelArrayList.add(new aymenmodel("Glasses", R.drawable.glasses));
            aymenmodelArrayList.add(new aymenmodel("Skirt", R.drawable.skirt));
            aymenmodelArrayList.add(new aymenmodel("jacket", R.drawable.veste1));
            aymenmodelArrayList.add(new aymenmodel("costume", R.drawable.cost1));
            aymenmodelArrayList.add(new aymenmodel("ring", R.drawable.bag));
            aymenmodelArrayList.add(new aymenmodel("watch", R.drawable.watches));

        } else if ((level.equals("3/2")) && languageLearn.equals("Fr")) {
            aymenmodelArrayList.add(new aymenmodel("T-shirt", R.drawable.shirt));
            aymenmodelArrayList.add(new aymenmodel("pantalon", R.drawable.pantalon));
            aymenmodelArrayList.add(new aymenmodel("botte", R.drawable.boot1));
            aymenmodelArrayList.add(new aymenmodel("casquette", R.drawable.caskette));
            aymenmodelArrayList.add(new aymenmodel("chapeau", R.drawable.chapeau));
            aymenmodelArrayList.add(new aymenmodel("gants", R.drawable.gloves1));
            aymenmodelArrayList.add(new aymenmodel("lunette", R.drawable.glasses));
            aymenmodelArrayList.add(new aymenmodel("jupe", R.drawable.skirt));
            aymenmodelArrayList.add(new aymenmodel("veste", R.drawable.veste1));
            aymenmodelArrayList.add(new aymenmodel("costume", R.drawable.cost1));
            aymenmodelArrayList.add(new aymenmodel("bague", R.drawable.bag));
            aymenmodelArrayList.add(new aymenmodel("montre", R.drawable.watches));
        } else if ((level.equals("4")) && languageLearn.equals("An")) {
            aymenmodelArrayList.add(new aymenmodel("grandfather", R.drawable.grapa));
            aymenmodelArrayList.add(new aymenmodel("grandmother", R.drawable.grama));
            aymenmodelArrayList.add(new aymenmodel("my father", R.drawable.dad));
            aymenmodelArrayList.add(new aymenmodel("my mother", R.drawable.mam));
            aymenmodelArrayList.add(new aymenmodel("big brother", R.drawable.bigbro));
            aymenmodelArrayList.add(new aymenmodel("sister", R.drawable.sis));
            aymenmodelArrayList.add(new aymenmodel("baby", R.drawable.baby));
            aymenmodelArrayList.add(new aymenmodel("uncle", R.drawable.ancl));
            aymenmodelArrayList.add(new aymenmodel("aunt", R.drawable.antt));
            aymenmodelArrayList.add(new aymenmodel("cousins", R.drawable.cons));
        } else if ((level.equals("4")) && languageLearn.equals("Fr")) {
            aymenmodelArrayList.add(new aymenmodel("grand-père", R.drawable.grapa));
            aymenmodelArrayList.add(new aymenmodel("grand-mère", R.drawable.grama));
            aymenmodelArrayList.add(new aymenmodel("papa", R.drawable.dad));
            aymenmodelArrayList.add(new aymenmodel("maman", R.drawable.mam));
            aymenmodelArrayList.add(new aymenmodel("grand-frère", R.drawable.bigbro));
            aymenmodelArrayList.add(new aymenmodel("sœur", R.drawable.sis));
            aymenmodelArrayList.add(new aymenmodel("petit frère", R.drawable.baby));
            aymenmodelArrayList.add(new aymenmodel("oncle", R.drawable.ancl));
            aymenmodelArrayList.add(new aymenmodel("tante", R.drawable.antt));
            aymenmodelArrayList.add(new aymenmodel("cousins", R.drawable.cons));
        } else if ((level.equals("6")) && languageLearn.equals("An")) {
            aymenmodelArrayList.add(new aymenmodel("Cow", R.drawable.cow));
            aymenmodelArrayList.add(new aymenmodel("Dog", R.drawable.dog));
            aymenmodelArrayList.add(new aymenmodel("Elephant", R.drawable.elepant));
            aymenmodelArrayList.add(new aymenmodel("fox", R.drawable.fox));
            aymenmodelArrayList.add(new aymenmodel("Giraffe", R.drawable.giraffe));
            aymenmodelArrayList.add(new aymenmodel("Horse", R.drawable.horse));
            aymenmodelArrayList.add(new aymenmodel("Lyon", R.drawable.lion));
            aymenmodelArrayList.add(new aymenmodel("Monkey", R.drawable.monkey));
            aymenmodelArrayList.add(new aymenmodel("Panda", R.drawable.panda));
            aymenmodelArrayList.add(new aymenmodel("Snake", R.drawable.snake));
            aymenmodelArrayList.add(new aymenmodel("Gorilla", R.drawable.gorilla));
            aymenmodelArrayList.add(new aymenmodel("Rabbit", R.drawable.rabbit));
        } else if ((level.equals("4/2")) && languageLearn.equals("Fr")) {
            aymenmodelArrayList.add(new aymenmodel("astronome", R.drawable.astronome));
            aymenmodelArrayList.add(new aymenmodel("docteur", R.drawable.doctor));
            aymenmodelArrayList.add(new aymenmodel("infirmière", R.drawable.infirmiere));
            aymenmodelArrayList.add(new aymenmodel("prof", R.drawable.prof));
            aymenmodelArrayList.add(new aymenmodel("policier", R.drawable.policier));
            aymenmodelArrayList.add(new aymenmodel("pompier", R.drawable.pompier));
            aymenmodelArrayList.add(new aymenmodel("architecte", R.drawable.architecte));
            aymenmodelArrayList.add(new aymenmodel("maçon", R.drawable.macon));
            aymenmodelArrayList.add(new aymenmodel("bucheron", R.drawable.bucheron));
            aymenmodelArrayList.add(new aymenmodel("chef", R.drawable.chef));
            aymenmodelArrayList.add(new aymenmodel("coiffeur", R.drawable.coiffeur));
            aymenmodelArrayList.add(new aymenmodel("facteur", R.drawable.facteur));
            aymenmodelArrayList.add(new aymenmodel("agriculteur", R.drawable.agriculteur));
            aymenmodelArrayList.add(new aymenmodel("pecheur", R.drawable.pecheur));

        } else if ((level.equals("4/2")) && languageLearn.equals("An")) {
            aymenmodelArrayList.add(new aymenmodel("astronomer", R.drawable.astronome));
            aymenmodelArrayList.add(new aymenmodel("doctor", R.drawable.doctor));
            aymenmodelArrayList.add(new aymenmodel("nurse", R.drawable.infirmiere));
            aymenmodelArrayList.add(new aymenmodel("teacher", R.drawable.prof));
            aymenmodelArrayList.add(new aymenmodel("policemen", R.drawable.policier));
            aymenmodelArrayList.add(new aymenmodel("firefighter", R.drawable.pompier));
            aymenmodelArrayList.add(new aymenmodel("architect", R.drawable.architecte));
            aymenmodelArrayList.add(new aymenmodel("builder", R.drawable.macon));
            aymenmodelArrayList.add(new aymenmodel("lumberjack", R.drawable.bucheron));
            aymenmodelArrayList.add(new aymenmodel("chef", R.drawable.chef));
            aymenmodelArrayList.add(new aymenmodel("hairdresser", R.drawable.coiffeur));
            aymenmodelArrayList.add(new aymenmodel("postman", R.drawable.facteur));
            aymenmodelArrayList.add(new aymenmodel("farmer", R.drawable.agriculteur));
            aymenmodelArrayList.add(new aymenmodel("sinner", R.drawable.pecheur));
        } else if ((level.equals("5")) && languageLearn.equals("An")) {
            aymenmodelArrayList.add(new aymenmodel("Garlic", R.drawable.ail));
            aymenmodelArrayList.add(new aymenmodel("Carrot", R.drawable.carotte));
            aymenmodelArrayList.add(new aymenmodel("Cucumber", R.drawable.concombre));
            aymenmodelArrayList.add(new aymenmodel("Lettuce", R.drawable.laitue));
            aymenmodelArrayList.add(new aymenmodel("Leek", R.drawable.leek));
            aymenmodelArrayList.add(new aymenmodel("Corn", R.drawable.maiis));
            aymenmodelArrayList.add(new aymenmodel("Eggplant", R.drawable.obergine));
            aymenmodelArrayList.add(new aymenmodel("Onion", R.drawable.onion));
            aymenmodelArrayList.add(new aymenmodel("Pepper", R.drawable.poivron));
            aymenmodelArrayList.add(new aymenmodel("Potato", R.drawable.pommedeterre));
            aymenmodelArrayList.add(new aymenmodel("Mushroom", R.drawable.champignon));
            aymenmodelArrayList.add(new aymenmodel("Tomato", R.drawable.tomatte));
        } else if ((level.equals("5")) && languageLearn.equals("Fr")) {
            aymenmodelArrayList.add(new aymenmodel("Tommate", R.drawable.tomatte));
            aymenmodelArrayList.add(new aymenmodel("Pomme de terre", R.drawable.pommedeterre));
            aymenmodelArrayList.add(new aymenmodel("Poivron", R.drawable.poivron));
            aymenmodelArrayList.add(new aymenmodel("Onion", R.drawable.onion));
            aymenmodelArrayList.add(new aymenmodel("Obergine", R.drawable.obergine));
            aymenmodelArrayList.add(new aymenmodel("Mais", R.drawable.maiis));
            aymenmodelArrayList.add(new aymenmodel("Courgette", R.drawable.courgette));
            aymenmodelArrayList.add(new aymenmodel("Concombre", R.drawable.concombre));
            aymenmodelArrayList.add(new aymenmodel("Chou-fleur", R.drawable.choufleur));
            aymenmodelArrayList.add(new aymenmodel("Champignon", R.drawable.champignon));
            aymenmodelArrayList.add(new aymenmodel("Carotte", R.drawable.carotte));
            aymenmodelArrayList.add(new aymenmodel("Brocoli", R.drawable.brocoli));
            aymenmodelArrayList.add(new aymenmodel("Betterave", R.drawable.betterave));
            aymenmodelArrayList.add(new aymenmodel("Artichaut", R.drawable.artichaut));
            aymenmodelArrayList.add(new aymenmodel("Petit pois", R.drawable.petitpois));
            aymenmodelArrayList.add(new aymenmodel("Ail", R.drawable.ail));
            aymenmodelArrayList.add(new aymenmodel("Laitue", R.drawable.laitue));
        } else if ((level.equals("5/2")) && languageLearn.equals("An")) {
            aymenmodelArrayList.add(new aymenmodel("Apricot", R.drawable.abricot));
            aymenmodelArrayList.add(new aymenmodel("Apple", R.drawable.pomme));
            aymenmodelArrayList.add(new aymenmodel("Banana", R.drawable.bannane));
            aymenmodelArrayList.add(new aymenmodel("Cherry", R.drawable.cerise));
            aymenmodelArrayList.add(new aymenmodel("Fig", R.drawable.figue));
            aymenmodelArrayList.add(new aymenmodel("Kiwi", R.drawable.kiwi));
            aymenmodelArrayList.add(new aymenmodel("Mango", R.drawable.mangue));
            aymenmodelArrayList.add(new aymenmodel("Melon", R.drawable.melon));
            aymenmodelArrayList.add(new aymenmodel("Orange", R.drawable.orangee));
            aymenmodelArrayList.add(new aymenmodel("Pear", R.drawable.poire));
            aymenmodelArrayList.add(new aymenmodel("Peach", R.drawable.peche));
            aymenmodelArrayList.add(new aymenmodel("Pineapple", R.drawable.ananas));
            aymenmodelArrayList.add(new aymenmodel("Pomegranate", R.drawable.grenade));
            aymenmodelArrayList.add(new aymenmodel("Grape", R.drawable.raisin));
            aymenmodelArrayList.add(new aymenmodel("Strawberry", R.drawable.fraise));
            aymenmodelArrayList.add(new aymenmodel("Watermelon", R.drawable.pastheque));
        } else if ((level.equals("5/2")) && languageLearn.equals("Fr")) {
            aymenmodelArrayList.add(new aymenmodel("Abricot", R.drawable.abricot));
            aymenmodelArrayList.add(new aymenmodel("Ananas", R.drawable.ananas));
            aymenmodelArrayList.add(new aymenmodel("Avocat", R.drawable.avocat));
            aymenmodelArrayList.add(new aymenmodel("Banane", R.drawable.bannane));
            aymenmodelArrayList.add(new aymenmodel("Cerise", R.drawable.cerise));
            aymenmodelArrayList.add(new aymenmodel("Citron", R.drawable.citron));
            aymenmodelArrayList.add(new aymenmodel("Figue", R.drawable.figue));
            aymenmodelArrayList.add(new aymenmodel("Fraise", R.drawable.fraise));
            aymenmodelArrayList.add(new aymenmodel("Kiwi", R.drawable.kiwi));
            aymenmodelArrayList.add(new aymenmodel("Grenade", R.drawable.grenade));

            aymenmodelArrayList.add(new aymenmodel("Framboise", R.drawable.framboise));
            aymenmodelArrayList.add(new aymenmodel("Mangue", R.drawable.mangue));
            aymenmodelArrayList.add(new aymenmodel("Melon", R.drawable.melon));
            aymenmodelArrayList.add(new aymenmodel("Noix De Coco", R.drawable.noixdecoco));
            aymenmodelArrayList.add(new aymenmodel("Orange", R.drawable.orangee));

            aymenmodelArrayList.add(new aymenmodel("Peche", R.drawable.peche));
            aymenmodelArrayList.add(new aymenmodel("pomme", R.drawable.pomme));

            aymenmodelArrayList.add(new aymenmodel("Poire", R.drawable.poire));
            aymenmodelArrayList.add(new aymenmodel("Raisin", R.drawable.raisin));
            aymenmodelArrayList.add(new aymenmodel("Pastheque", R.drawable.pastheque));
        } else if ((level.equals("6")) && languageLearn.equals("An")) {
            aymenmodelArrayList.add(new aymenmodel("Cow", R.drawable.cow));
            aymenmodelArrayList.add(new aymenmodel("Dog", R.drawable.dog));
            aymenmodelArrayList.add(new aymenmodel("Elephant", R.drawable.elepant));
            aymenmodelArrayList.add(new aymenmodel("fox", R.drawable.fox));
            aymenmodelArrayList.add(new aymenmodel("Giraffe", R.drawable.giraffe));
            aymenmodelArrayList.add(new aymenmodel("Horse", R.drawable.horse));
            aymenmodelArrayList.add(new aymenmodel("Lyon", R.drawable.lion));
            aymenmodelArrayList.add(new aymenmodel("Monkey", R.drawable.monkey));
            aymenmodelArrayList.add(new aymenmodel("Panda", R.drawable.panda));
            aymenmodelArrayList.add(new aymenmodel("Snake", R.drawable.snake));
            aymenmodelArrayList.add(new aymenmodel("Gorilla", R.drawable.gorilla));
            aymenmodelArrayList.add(new aymenmodel("Rabbit", R.drawable.rabbit));
        } else if ((level.equals("6")) && languageLearn.equals("Fr")) {
            aymenmodelArrayList.add(new aymenmodel("Chat", R.drawable.cat));
            aymenmodelArrayList.add(new aymenmodel("CHien", R.drawable.dog));
            aymenmodelArrayList.add(new aymenmodel("Elephant", R.drawable.elepant));
            aymenmodelArrayList.add(new aymenmodel("Renard", R.drawable.fox));
            aymenmodelArrayList.add(new aymenmodel("Cheval", R.drawable.horse));
            aymenmodelArrayList.add(new aymenmodel("Lyon", R.drawable.lion));
            aymenmodelArrayList.add(new aymenmodel("jcp", R.drawable.monkey));
            aymenmodelArrayList.add(new aymenmodel("Panda", R.drawable.panda));
            aymenmodelArrayList.add(new aymenmodel("Serpant", R.drawable.snake));
            aymenmodelArrayList.add(new aymenmodel("Lappin", R.drawable.rabbit));
        } else if ((level.equals("7")) && languageLearn.equals("An")) {
            aymenmodelArrayList.add(new aymenmodel("Backpack", R.drawable.backpack));
            aymenmodelArrayList.add(new aymenmodel("chair", R.drawable.chair));
            aymenmodelArrayList.add(new aymenmodel("Drums", R.drawable.drum));
            aymenmodelArrayList.add(new aymenmodel("Hammer", R.drawable.hammer));
            aymenmodelArrayList.add(new aymenmodel("Pillow", R.drawable.pillow));
            aymenmodelArrayList.add(new aymenmodel("Computer", R.drawable.pc));
            aymenmodelArrayList.add(new aymenmodel("Bed", R.drawable.bed));
            aymenmodelArrayList.add(new aymenmodel("Clock", R.drawable.clock));
            aymenmodelArrayList.add(new aymenmodel("Book", R.drawable.book));
            aymenmodelArrayList.add(new aymenmodel("Ball", R.drawable.ball));
            aymenmodelArrayList.add(new aymenmodel("Keys", R.drawable.keys));
            aymenmodelArrayList.add(new aymenmodel("Shoes", R.drawable.shoes));
        } else if ((level.equals("7")) && languageLearn.equals("Fr")) {
            aymenmodelArrayList.add(new aymenmodel("Sacados", R.drawable.backpack));
            aymenmodelArrayList.add(new aymenmodel("Chaise", R.drawable.chair));
            aymenmodelArrayList.add(new aymenmodel("Tambours", R.drawable.drum));
            aymenmodelArrayList.add(new aymenmodel("Marteau", R.drawable.hammer));
            aymenmodelArrayList.add(new aymenmodel("Oreiller", R.drawable.pillow));
            aymenmodelArrayList.add(new aymenmodel("L'ordinateur", R.drawable.pc));
            aymenmodelArrayList.add(new aymenmodel("Lit", R.drawable.bed));
            aymenmodelArrayList.add(new aymenmodel("L'horloge", R.drawable.clock));
            aymenmodelArrayList.add(new aymenmodel("Livre", R.drawable.book));
            aymenmodelArrayList.add(new aymenmodel("Balle", R.drawable.ball));
            aymenmodelArrayList.add(new aymenmodel("Clés", R.drawable.keys));
            aymenmodelArrayList.add(new aymenmodel("Chaussures", R.drawable.shoes));
        }


        adaptervpp = new adaptervp(this, aymenmodelArrayList);

        vpHorizontal.setAdapter(adaptervpp);

        vpHorizontal.setPadding(50, 400, 50, 0);

    }

}