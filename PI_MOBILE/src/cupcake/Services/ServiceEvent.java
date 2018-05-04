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
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import cupcake.Entite.Event;
import cupcake.GUI.AffichageEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Asus
 */
public class ServiceEvent {
    public static ArrayList<Event> getList2() {

        ArrayList<Event> listEvents = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
            con.setUrl("http://localhost/symfony-api/web/app_dev.php/event/alls");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listEvents = getListEvent(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> Events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" +Events.get("root"));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) Events.get("root");
                    System.out.println(list);
                    for (Map<String, Object> obj : list) {
                        Event event = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        event.setId((int) id);
                        event.setAdresse(obj.get("address").toString());
                        event.setNameEvent(obj.get("nameevent").toString());
                        event.setDescription((String) obj.get("description"));
                        event.setPicture((String) obj.get("picture"));
                        listEvents.add(event);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }

    public static void ajoutTask(Event e) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony-api/web/app_dev.php/event/new/" +e.getNameEvent()+ "/" + e.getDescription()+"/"+e.getAdresse()+"/"+
                e.getDateDebut()+"/"+e.getTimeDebut()+"/"+e.getTimeFin()+"/"+e.getIdPastry()+"/"+e.getTicket()+"/"+e.getPicture()+"/"+  e.getNbrLimite();
        con.setUrl(Url);

        System.out.println("tt");

//        con.addResponseCodeListener((e) -> {
//            String str = new String(con.getResponseData());
//            System.out.println(str);
////            if (str.trim().equalsIgnoreCase("OK")) {
////                f2.setTitle(tlogin.getText());
////             f2.show();
////            }
////            else{
////            Dialog.show("error", "login ou pwd invalid", "ok", null);
////            }
//        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    

public static Event getDetailEvent() {
                               Event event = new Event();

        ConnectionRequest con2 = new ConnectionRequest();
        con2.setUrl("http://localhost/symfony-api/web/app_dev.php/event/find/"+AffichageEvent.id);
        con2.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con2.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" + tasks);

                    //List<Map<String, Object>> list = (List<Map<String, Object>>) tasks;
                     float id = Float.parseFloat(tasks.get("id").toString());
                     float nbr = Float.parseFloat(tasks.get("nbrparticipants").toString());
                     float ticket = Float.parseFloat(tasks.get("ticket").toString());
                     float nbrlimite = Float.parseFloat(tasks.get("nbrlimite").toString());

                            event.setId((int) id);
                            event.setNameEvent((String) tasks.get("nameevent"));
                            event.setAdresse((String) tasks.get("address"));
                            event.setDescription((String) tasks.get("description"));
                            event.setPicture((String) tasks.get("picture"));
                            event.setNbrParticipants((int)nbr );
                            event.setTicket((int) ticket);
                            event.setNbrLimite((int) nbrlimite);
                            Map<String, Object> mapDateDebut=(Map<String, Object>) tasks.get("datedebut");
                            float datedebut = Float.parseFloat(mapDateDebut.get("timestamp").toString());
                            String date =new SimpleDateFormat("dd/MM/yyyy").format(new Date((long) (datedebut * 1000L)));
                             Map<String, Object> maptimeDebut=(Map<String, Object>) tasks.get("timedebut");
                            float timedebut = Float.parseFloat(mapDateDebut.get("timestamp").toString());
                            String timeStart =new SimpleDateFormat("HH:mm aaa").format(new Date((long) (timedebut * 1000)));
                            Map<String, Object> maptimeFin=(Map<String, Object>) tasks.get("timefin");
                            float timefin = Float.parseFloat(maptimeFin.get("timestamp").toString());
                            String timeEnd =new SimpleDateFormat("HH:mm aaa").format(new Date((long) (timefin * 1000)));
                            event.setDateDebut(date);
                            event.setTimeDebut(timeStart);
                            event.setTimeFin(timeEnd);
                            System.out.println(timeStart);
                            System.out.println(timeEnd);
                            
                } catch (IOException ex) {
                }

            }
        });
                                System.out.println(event);

        NetworkManager.getInstance().addToQueueAndWait(con2);
        return event;

    }    
}
