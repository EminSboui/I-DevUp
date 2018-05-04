 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.Entite;




/**
 *
 * @author Asus
 */
public class Event {
    private int id;
    private String dateDebut;
    private String timeDebut;
    private String timeFin;
    private String nameEvent;
    private String adresse;
    private String description;
    private String picture;
    private int nbrParticipants;
    private int ticket;
    private int nbrLimite;
    private double longitude;
    private double latitude;
    private int idPastry;

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", dateDebut=" + dateDebut + ", timeDebut=" + timeDebut + ", timeFin=" + timeFin + ", nameEvent=" + nameEvent + ", adresse=" + adresse + ", description=" + description + ", picture=" + picture + ", nbrParticipants=" + nbrParticipants + ", ticket=" + ticket + ", nbrLimite=" + nbrLimite + ", longitude=" + longitude + ", latitude=" + latitude + ", idPastry=" + idPastry + '}';
    }

    public Event() {
    }

    public Event(int id, String dateDebut, String timeDebut, String timeFin, String nameEvent, String adresse, String description, String picture, int nbrParticipants, int ticket, int nbrLimite, double longitude, double latitude, int idPastry) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.timeDebut = timeDebut;
        this.timeFin = timeFin;
        this.nameEvent = nameEvent;
        this.adresse = adresse;
        this.description = description;
        this.picture = picture;
        this.nbrParticipants = nbrParticipants;
        this.ticket = ticket;
        this.nbrLimite = nbrLimite;
        this.longitude = longitude;
        this.latitude = latitude;
        this.idPastry = idPastry;
    }
    

    

    public int getIdPastry() {
        return idPastry;
    }

    public void setIdPastry(int idPastry) {
        this.idPastry = idPastry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getTimeDebut() {
        return timeDebut;
    }

    public void setTimeDebut(String timeDebut) {
        this.timeDebut = timeDebut;
    }

    public String getTimeFin() {
        return timeFin;
    }

    public void setTimeFin(String timeFin) {
        this.timeFin = timeFin;
    }

   

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getNbrParticipants() {
        return nbrParticipants;
    }

    public void setNbrParticipants(int nbrParticipants) {
        this.nbrParticipants = nbrParticipants;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getNbrLimite() {
        return nbrLimite;
    }

    public void setNbrLimite(int nbrLimite) {
        this.nbrLimite = nbrLimite;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    
}
