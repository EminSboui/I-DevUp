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
import cupcake.Entite.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dorra
 */
public class ServiceComponent {
    
    public void addComponent(Component component) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost:8000/symfony-api/web/component/" +component.getComponentname()+ "/" + component.getUnity();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public static ArrayList<Component> getList() {
        ArrayList<Component> listComponent = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:8000/symfony-api/web/app_dev.php/recipe/allComponent");
        con.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp = new JSONParser();
            try {
                //renvoi une map avec clé = root et valeur le reste
                Map<String, Object> components = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println("roooooot:" +components.get("root"));
                List<Map<String, Object>> list = (List<Map<String, Object>>) components.get("root");
                for (Map<String, Object> obj : list) {
                    Component component = new Component();
                    float id = Float.parseFloat(obj.get("componentid").toString());
                    component.setRecipeid((int) id);
                    component.setComponentname(obj.get("componentname").toString());
                    component.setUnity(obj.get("unity").toString());
                    listComponent.add(component);
                }
            } catch (IOException ex) {}
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listComponent;
    }
}
