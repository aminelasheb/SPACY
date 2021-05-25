package com.example.spacy;

public class itemrecycler {
    private int t ;
    private int mImageRessource;
    private String mtext1;
    private String mtext2;


    public itemrecycler(int T ,int Imageresource,String text1, String text2){
t = T ;
        mImageRessource=Imageresource;
        mtext1=text1;
        mtext2=text2;

    }
    public int getmImageRessource(){
        return mImageRessource;
    }
    public String getMtext1(){
        return mtext1;
    }
    public String getMtext2(){
        return mtext2;
    }
    public int getT() {return t;}

}
