/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.Entite;

/**
 *
 * @author Dorra
 */
public class Recipe {
    private int recipeid;
    private String recipename;
    private String description;
    private String picture;
    private String video;
    private String recipeuser;


    public Recipe(String recipename, String picture, String recipeuser) {
        this.recipename = recipename;
        this.picture = picture;
        this.recipeuser = recipeuser;
    }
    
    public Recipe(String recipename, String description, String picture,String a) {
        this.recipename = recipename;
        this.description = description;
        this.picture = picture;
    }
    
    public Recipe(int recipeid, String recipename, String description, String picture, String video) {
        this.recipeid = recipeid;
        this.recipename = recipename;
        this.description = description;
        this.picture = picture;
        this.video = video;
    }
 public Recipe(int recipeid, String recipename, String description, String picture) {
        this.recipeid = recipeid;
        this.recipename = recipename;
        this.description = description;
        this.picture = picture;
    }
    public Recipe(int recipeid) {
        this.recipeid = recipeid;
    }

    public Recipe(String description) {
        this.description = description;
    }

    public Recipe(String recipename, String description) {
        this.recipename = recipename;
        this.description = description;
    }
    public Recipe(String description, String video,int a) {
        this.description = description;
        this.video = video;
    }

    public Recipe(String recipename, String description, String picture, String video, String recipeuser) {
        this.recipename = recipename;
        this.description = description;
        this.picture = picture;
        this.video = video;
        this.recipeuser= recipeuser;
    }

    public Recipe() {
    }

    public String getRecipename() {
        return recipename;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(int recipeid) {
        this.recipeid = recipeid;
    }

    public String getRecipeuser() {
        return recipeuser;
    }

    public void setRecipeuser(String recipeuser) {
        this.recipeuser = recipeuser;
    }

    @Override
    public String toString() {
        return "Recipe{recipename=" + recipename + ", description=" + description + ", picture=" + picture + ", video=" + video + '}';
    }
}
