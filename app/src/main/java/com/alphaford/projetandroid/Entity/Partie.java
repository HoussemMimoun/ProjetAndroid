package com.alphaford.projetandroid.Entity;

import java.util.Date;

/**
 * Created by user on 27/12/2017.
 */

public class Partie {
    private int id_match;
    private Date date_match;
    private String heure_match;
    private String equipe1;
    private String equipe2;
    private Boolean played;
    private String stade;
    private String drapeau_equipe1;
    private String drapeau_equipe2;


    public Partie(int id_match, Date date_match, String heure_match, Boolean played) {
        this.id_match = id_match;
        this.date_match = date_match;
        this.heure_match = heure_match;
        this.played = played;
    }


    public Partie(int id_match, String heure_match, String equipe1, String equipe2, String stade) {
        this.id_match = id_match;
        this.heure_match = heure_match;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.stade = stade;
    }

    public Partie(int id_match, String heure_match, String equipe1, String equipe2, String stade, String drapeau_equipe1, String drapeau_equipe2) {
        this.id_match = id_match;
        this.heure_match = heure_match;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.stade = stade;
        this.drapeau_equipe1 = drapeau_equipe1;
        this.drapeau_equipe2 = drapeau_equipe2;
    }

    public Partie() {
    }

    public Partie(int id_match, Date date_match, String heure_match, String equipe1, String equipe2, String stade, String drapeau_equipe1, String drapeau_equipe2) {
        this.id_match = id_match;
        this.date_match = date_match;
        this.heure_match = heure_match;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.stade = stade;
        this.drapeau_equipe1 = drapeau_equipe1;
        this.drapeau_equipe2 = drapeau_equipe2;
    }

    public Partie(int id_match, Date date_match, String heure_match) {
        this.id_match = id_match;
        this.date_match = date_match;
        this.heure_match = heure_match;
    }

    public Partie(int id_match, String heure_match) {
        this.id_match = id_match;
        this.heure_match = heure_match;
    }

    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public Date getDate_match() {
        return date_match;
    }

    public void setDate_match(Date date_match) {
        this.date_match = date_match;
    }

    public String getHeure_match() {
        return heure_match;
    }

    public void setHeure_match(String heure_match) {
        this.heure_match = heure_match;
    }

    public Boolean getPlayed() {
        return played;
    }

    public void setPlayed(Boolean played) {
        this.played = played;
    }

    public String getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(String equipe1) {
        this.equipe1 = equipe1;
    }

    public String getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(String equipe2) {
        this.equipe2 = equipe2;
    }

    public String getStade() {
        return stade;
    }

    public void setStade(String stade) {
        this.stade = stade;
    }

    public String getDrapeau_equipe1() {
        return drapeau_equipe1;
    }

    public void setDrapeau_equipe1(String drapeau_equipe1) {
        this.drapeau_equipe1 = drapeau_equipe1;
    }

    public String getDrapeau_equipe2() {
        return drapeau_equipe2;
    }

    public void setDrapeau_equipe2(String drapeau_equipe2) {
        this.drapeau_equipe2 = drapeau_equipe2;
    }


}
