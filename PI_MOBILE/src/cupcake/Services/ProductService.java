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
import cupcake.Entite.Offer;
import cupcake.Entite.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author omri_
 */
public class ProductService {

    public void addProduct(Product product) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost:8000/symfony-api/web/Product/" + product.getProductName() + "/" + product.getDescription();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public Map<Product, Offer> getList() {
        HashMap<Product, Offer> listProduct = new HashMap<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfony-api/web/app_dev.php/Product/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> products = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" + products.get("root"));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) products.get("root");

                    for (Map<String, Object> obj : list) {
                        Product product = new Product();
                        float id = Float.parseFloat(obj.get("productid").toString());
                        product.setProductId((int) id);
                        product.setProductName(obj.get("productname").toString());
                        product.setDescription(obj.get("description").toString());
                        product.setProductName(obj.get("productname").toString());
                        product.setPictures(obj.get("picture").toString());
                        product.setUnite(obj.get("unite").toString());
                        float price = Float.parseFloat(obj.get("price").toString());
                        product.setPrice((int) price);
                        
                        Map<String, Object> offerMap = (Map<String, Object>) obj.get("offer");
                        Offer offer = new Offer();
                        float offerprice = Float.parseFloat(offerMap.get("offerprice").toString());
                        offer.setOfferprice((int) offerprice);

                        listProduct.put(product, offer);
                    }
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduct;
    }

}
