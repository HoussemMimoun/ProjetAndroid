package com.alphaford.projetandroid.Entity;

/**
 * Created by user on 04/12/2017.
 */

public class Equipe {
    private  int id_equipe;
    private String nom_equipe;
    private  String continent;
    private int but_marque;
    private int but_recu;
    private int nb_victoire;
    private int nb_null;
    private int nb_defaite;
    private int nb_point;
    private String drapeau_equipe;

    public Equipe() {
    }

    public Equipe(int id_equipe, String nom_equipe, String continent, int but_marque, int but_recu, int nb_victoire, int nb_null, int nb_defaite, int nb_point) {
        this.id_equipe = id_equipe;
        this.nom_equipe = nom_equipe;
        this.continent = continent;
        this.but_marque = but_marque;
        this.but_recu = but_recu;
        this.nb_victoire = nb_victoire;
        this.nb_null = nb_null;
        this.nb_defaite = nb_defaite;
        this.nb_point = nb_point;
    }

    public Equipe(int id_equipe, String nom_equipe, String drapeau_equipe) {
        this.id_equipe = id_equipe;
        this.nom_equipe = nom_equipe;
        this.drapeau_equipe = drapeau_equipe;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public String getNom_equipe() {
        return nom_equipe;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getBut_marque() {
        return but_marque;
    }

    public void setBut_marque(int but_marque) {
        this.but_marque = but_marque;
    }

    public int getBut_recu() {
        return but_recu;
    }

    public void setBut_recu(int but_recu) {
        this.but_recu = but_recu;
    }

    public int getNb_victoire() {
        return nb_victoire;
    }

    public void setNb_victoire(int nb_victoire) {
        this.nb_victoire = nb_victoire;
    }

    public int getNb_null() {
        return nb_null;
    }

    public void setNb_null(int nb_null) {
        this.nb_null = nb_null;
    }

    public int getNb_defaite() {
        return nb_defaite;
    }

    public void setNb_defaite(int nb_defaite) {
        this.nb_defaite = nb_defaite;
    }

    public int getNb_point() {
        return nb_point;
    }

    public void setNb_point(int nb_point) {
        this.nb_point = nb_point;
    }

    public String getDrapeau_equipe() {
        return drapeau_equipe;
    }

    public void setDrapeau_equipe(String drapeau_equipe) {
        this.drapeau_equipe = drapeau_equipe;
    }
}
