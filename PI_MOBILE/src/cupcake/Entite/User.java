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
public class User {

    private int id;
    private String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private String password;
    private String roles;
    private int enabled;
    private String firstname;
    private String lastname;
    private String phone;
    private String town;
    private String address;
    private String postalcode;
    private String picture;
    private String facebook;
    private String banneddate;

    public User() {
    }

    public User(String username, String email, String password, String firstname, String lastname, String phone, String town, String address, String postalcode, String picture, String facebook) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.town = town;
        this.address = address;
        this.postalcode = postalcode;
        this.picture = picture;
        this.facebook = facebook;
    }

    public User(String username, String firstname, String lastname, String phone, String town, String address, String postalcode, String picture, String facebook) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.town = town;
        this.address = address;
        this.postalcode = postalcode;
        this.picture = picture;
        this.facebook = facebook;
    }
//construct for admin 

    public User(int id, String username, String email, String password, String firstname, String lastname, String phone, String town, String picture, String address, String facebook) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.town = town;
        this.picture = picture;
        this.address = address;
        this.facebook = facebook;
    }
        public User(int id, String username, String email, String password, int enabled, String firstname, String lastname) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getBanneddate() {
        return banneddate;
    }

    public void setBanneddate(String banneddate) {
        this.banneddate = banneddate;
    }

    @Override
    public String toString() {
        return "username=" + username + ", email=" + email + ", password=" + password + "firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", town=" + town + ", address=" + address + ", postalcode=" + postalcode + ", picture=" + picture + ", facebook=" + facebook + '}';
    }

}
