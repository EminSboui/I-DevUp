/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.Services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import cupcake.Entite.Forum;
import cupcake.Entite.test;

/**
 *
 * @author Amine Sboui
 */
public class Service_Forum {

    public void test(test f) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1:8000/forum/mobile/test/" + f;
        con.setUrl(Url);
        System.out.println("Aman");
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println("Bjah rabbi");
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void ajoutForum(Forum f) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1:8000/forum/mobile/AddForum/" + f;
        con.setUrl(Url);
        System.out.println("Aman");
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println("Bjah rabbi");
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
}
