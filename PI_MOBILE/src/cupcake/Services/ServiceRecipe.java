/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import cupcake.Entite.Component;
import cupcake.Entite.Recipe;
import cupcake.Entite.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dorra
 */
public class ServiceRecipe {

    public static void addRecipe(Recipe recipe) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost:8000/symfony-api/web/app_dev.php/recipe/new/"
                + recipe.getRecipename() + "/" + recipe.getDescription() + "/" + "1" + "/" + recipe.getPicture();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public ArrayList<Recipe> getList() {
        ArrayList<Recipe> listRecipe = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:8000/symfony-api/web/recipe/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> recipes = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" + recipes.get("root"));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) recipes.get("root");
                    for (Map<String, Object> obj : list) {
                        Recipe recipe = new Recipe();
                        float id = Float.parseFloat(obj.get("recipeid").toString());
                        recipe.setRecipeid((int) id);
                        recipe.setRecipename(obj.get("recipename").toString());
                        recipe.setDescription(obj.get("description").toString());
                        recipe.setPicture(obj.get("picture").toString());
                        listRecipe.add(recipe);
                    }
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listRecipe;
    }

    public static User getUser(int id) {
        
        User user = new User();
        ConnectionRequest con2 = new ConnectionRequest();
        con2.setUrl("http://localhost:8000/symfony-api/web/app_dev.php/recipe/user/1" );
        con2.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> users = jsonp.parseJSON(new CharArrayReader(new String(con2.getResponseData()).toCharArray()));                  
                    user.setUsername((String)users.get("username"));
                } catch (IOException ex) {}
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con2);
        return user;
    }

    public Map<Recipe, List<Component>> find() {
        HashMap<Recipe, List<Component>> oneRecipe = new HashMap<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:8000/symfony-api/web/recipe/find/13");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> recipes = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" + recipes.get("root"));
                    Recipe recette = new Recipe();
                    recette.setDescription((String) recipes.get("description"));
                    recette.setPicture((String) recipes.get("picture"));
                    float id = Float.parseFloat(recipes.get("recipeid").toString());
                    recette.setRecipeid((int) id);
                    recette.setRecipename((String) recipes.get("recipename"));
                    recette.setVideo((String) recipes.get("vid"));
                    ArrayList<Component> listcomponent = ServiceComponent.getList();
                    for (Component c : listcomponent) {
                        if (c.getRecipeid() == recette.getRecipeid()) {
                            oneRecipe.get(recette).add(c);
                        }
                    }
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return oneRecipe;
    }

    public ArrayList<Component> findComponent(int idR) {
        ArrayList<Component> components = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:8000/symfony-api/web/app_dev.php/recipe/findComponent/" + idR);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> recipes = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" + recipes.get("root"));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) recipes.get("root");
                    for (Map<String, Object> obj : list) {
                        Component component = new Component();
                        component.setComponentname((String) obj.get("componentname"));
                        component.setUnity((String) obj.get("unity"));
                        float id = Float.parseFloat(obj.get("componentid").toString());
                        component.setComponentId((int) id);
                        components.add(component);
                    }
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return components;
    }
}
