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
public class Client extends User {

    public Client() {
    }

    public Client(String username, String email, String password, String firstname, String lastname, String phone, String town, String address, String postalcode, String picture, String facebook) {
        super(username, email, password, firstname, lastname, phone, town, address, postalcode, picture, facebook);
    }

    @Override
    public String toString() {
        return "Client{" +super.toString()+ '}';
    }
    
    
    
}
