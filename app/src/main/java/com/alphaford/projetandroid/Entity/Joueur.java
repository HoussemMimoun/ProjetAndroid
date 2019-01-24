package com.alphaford.projetandroid.Entity;

/**
 * Created by user on 12/12/2017.
 */

public class Joueur {
    private int id_joueur;
    private String nom_joueur;
    private String photo_joueur;
    private String nationalite;
    private int age;
    private String poste;
    private int nb_but;
    private String club;

    public Joueur() {
    }

    public Joueur(int id_joueur, String nom_joueur, String photo_joueur, String nationalite, int age, String poste, int nb_but, String club) {
        this.id_joueur = id_joueur;
        this.nom_joueur = nom_joueur;
        this.photo_joueur = photo_joueur;
        this.nationalite = nationalite;
        this.age = age;
        this.poste = poste;
        this.nb_but = nb_but;
        this.club = club;
    }

    public Joueur(int id_joueur, String nom_joueur, String photo_joueur) {
        this.id_joueur = id_joueur;
        this.nom_joueur = nom_joueur;
        this.photo_joueur = photo_joueur;
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public String getNom_joueur() {
        return nom_joueur;
    }

    public void setNom_joueur(String nom_joueur) {
        this.nom_joueur = nom_joueur;
    }

    public String getPhoto_joueur() {
        return photo_joueur;
    }

    public void setPhoto_joueur(String photo_joueur) {
        this.photo_joueur = photo_joueur;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getNb_but() {
        return nb_but;
    }

    public void setNb_but(int nb_but) {
        this.nb_but = nb_but;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
