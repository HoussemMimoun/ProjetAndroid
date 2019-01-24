package com.alphaford.projetandroid.Entity;

/**
 * Created by user on 04/12/2017.
 */

public class Stade {
    private  int id_stade;
    private String nom_stade;
    private int altitude;
    private int longitude;
    private String image;
    private String description;

    public Stade() {
    }

    public Stade(int id_stade, String nom_stade, int altitude, int longitude, String image, String description) {
        this.id_stade = id_stade;
        this.nom_stade = nom_stade;
        this.altitude = altitude;
        this.longitude = longitude;
        this.image = image;
        this.description = description;
    }

    public int getId_stade() {
        return id_stade;
    }

    public void setId_stade(int id_stade) {
        this.id_stade = id_stade;
    }

    public String getNom_stade() {
        return nom_stade;
    }

    public void setNom_stade(String nom_stade) {
        this.nom_stade = nom_stade;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
