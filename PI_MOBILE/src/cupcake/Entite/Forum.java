/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.Entite;

import java.util.Date;

/**
 *
 * @author Amine Sboui
 */
public class Forum {
    private int id ;
    private String titre;
    private int id_user;
    private int id_categorie;
    private String contenue;
    private String etat;
    private int nbrsignalisation;
    private Date date_c;
    private int nbrjaime;
    private int jaimepas;
    private int vue;
    private String citation;
    private String tags;
    private String picture;

    public Forum() {
    }

    public Forum(String titre, int id_user, int id_categorie, String contenue, String etat, int nbrsignalisation, Date date, int nbrjaime, int jaimepas, int vue, String citation, String tags, String picture) {
        this.titre = titre;
        this.id_user = id_user;
        this.id_categorie = id_categorie;
        this.contenue = contenue;
        this.etat = etat;
        this.nbrsignalisation = nbrsignalisation;
        this.date_c = date;
        this.nbrjaime = nbrjaime;
        this.jaimepas = jaimepas;
        this.vue = vue;
        this.citation = citation;
        this.tags = tags;
        this.picture = picture;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getNbrsignalisation() {
        return nbrsignalisation;
    }

    public void setNbrsignalisation(int nbrsignalisation) {
        this.nbrsignalisation = nbrsignalisation;
    }

    public Date getDate_c() {
        return date_c;
    }

    public void setDate_c(Date date_c) {
        this.date_c = date_c;
    }

    public int getNbrjaime() {
        return nbrjaime;
    }

    public void setNbrjaime(int nbrjaime) {
        this.nbrjaime = nbrjaime;
    }

    public int getJaimepas() {
        return jaimepas;
    }

    public void setJaimepas(int jaimepas) {
        this.jaimepas = jaimepas;
    }

    public int getVue() {
        return vue;
    }

    public void setVue(int vue) {
        this.vue = vue;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Forum{" + "id=" + id + ", titre=" + titre + ", id_user=" + id_user + ", id_categorie=" + id_categorie + ", contenue=" + contenue + ", etat=" + etat + ", nbrsignalisation=" + nbrsignalisation + ", date_c=" + date_c + ", nbrjaime=" + nbrjaime + ", jaimepas=" + jaimepas + ", vue=" + vue + ", citation=" + citation + ", tags=" + tags + ", picture=" + picture + '}';
    }


    
}
