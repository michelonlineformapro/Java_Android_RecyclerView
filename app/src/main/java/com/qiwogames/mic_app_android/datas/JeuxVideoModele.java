package com.qiwogames.mic_app_android.datas;

import java.io.Serializable;

public class JeuxVideoModele implements Serializable {
    private String nom_jeux;
    private int image_jeux;
    private String description_jeux;
    private String prix_jeux;

    public JeuxVideoModele(String nom_jeux, int image_jeux, String description_jeux, String prix_jeux) {
        this.nom_jeux = nom_jeux;
        this.image_jeux = image_jeux;
        this.description_jeux = description_jeux;
        this.prix_jeux = prix_jeux;
    }

    public String getNom_jeux() {
        return nom_jeux;
    }

    public void setNom_jeux(String nom_jeux) {
        this.nom_jeux = nom_jeux;
    }

    public int getImage_jeux() {
        return image_jeux;
    }

    public void setImage_jeux(int image_jeux) {
        this.image_jeux = image_jeux;
    }

    public String getDescription_jeux() {
        return description_jeux;
    }

    public void setDescription_jeux(String description_jeux) {
        this.description_jeux = description_jeux;
    }

    public String getPrix_jeux() {
        return prix_jeux;
    }

    public void setPrix_jeux(String prix_jeux) {
        this.prix_jeux = prix_jeux;
    }
}
