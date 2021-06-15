package com.example.spacy;

public class aymenmodel {
    String titel;
    int image;

    public aymenmodel(String titel, int image) {
        this.titel = titel;
        this.image = image;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
