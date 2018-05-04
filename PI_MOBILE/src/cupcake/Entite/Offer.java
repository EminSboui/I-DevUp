/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.Entite;

/**
 *
 * @author omri_
 */
public class Offer {
    
    int offerid;
    String offername;
    int offerprice;
    String picture;
    String datedebut;
    String datefin;

    public Offer(int offerid, String offername, int offerprice, String picture, String datedebut, String datefin) {
        this.offerid = offerid;
        this.offername = offername;
        this.offerprice = offerprice;
        this.picture = picture;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Offer() {
    }
    
    

    public int getOfferid() {
        return offerid;
    }

    public void setOfferid(int offerid) {
        this.offerid = offerid;
    }

    public String getOffername() {
        return offername;
    }

    public void setOffername(String offername) {
        this.offername = offername;
    }

    public int getOfferprice() {
        return offerprice;
    }

    public void setOfferprice(int offerprice) {
        this.offerprice = offerprice;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }
    
}
