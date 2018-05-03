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
public class Patissier extends User{
 
  // private String userName;
   private String nomPatisserie;
  // private String firstName;
  // private String lastName;
   //private String email;
  // private String password;
  // private Date lastLogin;
  // private String phone ;
  // private String town;
  // private String picture;
   //private String address;
   private String worktime;
   private String dayOff;
   private String speciality;
   private String service;
  //  private int postalCode;
   private String website;
  // private String facebook;
   private String meansOfPayment;
   private String requirement;
   private String latitude;
   private String longitude;

    public Patissier() {
    }

    public Patissier(String username, String email, String password, String firstname, String lastname, String phone, String town, String address, String postalcode, String picture, String facebook,String nomPatisserie, String worktime, String dayOff, String speciality, String service, String website, String meansOfPayment, String requirement, String latitude, String longitude) {
        super( username,  email,  password,  firstname,  lastname,  phone,  town,  address,  postalcode,  picture,  facebook);
        this.nomPatisserie = nomPatisserie;
        this.worktime = worktime;
        this.dayOff = dayOff;
        this.speciality = speciality;
        this.service = service;
        this.website = website;
        this.meansOfPayment = meansOfPayment;
        this.requirement = requirement;
        this.latitude = latitude;
        this.longitude = longitude;
    }
 public Patissier(String username, String firstname, String lastname, String phone, String town, String address, String postalcode, String picture, String facebook,String nomPatisserie, String worktime, String dayOff, String speciality, String service, String website, String meansOfPayment, String requirement, String latitude, String longitude) {
        super( username,  firstname,  lastname,  phone,  town,  address,  postalcode,  picture,  facebook);
        this.nomPatisserie = nomPatisserie;
        this.worktime = worktime;
        this.dayOff = dayOff;
        this.speciality = speciality;
        this.service = service;
        this.website = website;
        this.meansOfPayment = meansOfPayment;
        this.requirement = requirement;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public String getNomPatisserie() {
        return nomPatisserie;
    }

    public void setNomPatisserie(String nomPatisserie) {
        this.nomPatisserie = nomPatisserie;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getDayOff() {
        return dayOff;
    }

    public void setDayOff(String dayOff) {
        this.dayOff = dayOff;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMeansOfPayment() {
        return meansOfPayment;
    }

    public void setMeansOfPayment(String meansOfPayment) {
        this.meansOfPayment = meansOfPayment;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Patissier{" +super.toString()+ "nomPatisserie=" + nomPatisserie + ", worktime=" + worktime + ", dayOff=" + dayOff + ", speciality=" + speciality + ", service=" + service + ", website=" + website + ", meansOfPayment=" + meansOfPayment + ", requirement=" + requirement + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

   
   
   
   
    
}
