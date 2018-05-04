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
public class Product {
    private int productId;
    private String productName;
    private String description;
    private String pictures;
    private boolean available;
    private String type;
    private int price;
   // private Date addedDate;
    private String userName;
    private String unite;
    private int offerId;
    

    
    

    public Product(int productId, String productName, String description, String pictures, boolean available, String type, int price, 
            //Date addedDate,
            String userName, String unite, int offerId) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.pictures = pictures;
        this.available = available;
        this.type = type;
        this.price = price;
       // this.addedDate = addedDate;
        this.userName = userName;
        this.unite = unite;
        this.offerId = offerId;
    }

   public Product() {
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

   /* public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }*/

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", description=" + description + ", pictures=" + pictures + ", available=" + available + ", type=" + type + ", price=" + price + " userName=" + userName + ", unite=" + unite + ", offerId=" + offerId + '}';
    }
   
   
    
}
