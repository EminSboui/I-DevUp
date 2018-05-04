/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import cupcake.Entite.Event;
import cupcake.Services.ServiceEvent;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class DisplayOneEvent {
                Form f;
                SpanLabel lb;
                Label label;
                String url;
                EncodedImage enc;
                URLImage uRLImage;
                ImageViewer imgV;
                Container oneEvent; 
                
                 public DisplayOneEvent(Resources theme) {
                     Event event = ServiceEvent.getDetailEvent();
                f = new Form(event.getNameEvent(),BoxLayout.y());
                         oneEvent=new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    url="http://localhost/pidevWEB_v1.0/web/uploads/images/"+event.getPicture();
                    
                    
            System.out.println(url);
            enc=EncodedImage.createFromImage(theme.getImage("menu.png"), false);
            uRLImage=URLImage.createToStorage(enc, url, url,URLImage.RESIZE_SCALE);
            imgV=new ImageViewer(uRLImage);
            Container image = new Container();
            f.add(imgV);
            Label lab3=new Label(event.getNameEvent());
            oneEvent.add(lab3);
           Label lab1=new Label(event.getAdresse());
           oneEvent.add(lab1);
           Label labdesc=new Label(event.getDescription());
           oneEvent.add(labdesc);
           Container nbrparticipant = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           Label labnbrparticipant = new Label("Nombre Participants");
                     Label txtnbrparticipant=new Label(String.valueOf(event.getNbrParticipants()));
              nbrparticipant.add(labnbrparticipant);
              nbrparticipant.add(txtnbrparticipant);
                         Container detailContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
                            detailContainer.add(nbrparticipant);
           if(event.getTicket()==1){
              Container nbrlimite = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Label labnbrlimite = new Label("Nombre Limite");
                     Label txtnbrlimite=new Label(String.valueOf(event.getNbrLimite()));
              nbrlimite.add(labnbrlimite);
              nbrlimite.add(txtnbrlimite);
              detailContainer.add(nbrlimite);
           }
                      Label lab4=new Label(event.getDateDebut());
                      Label lab5=new Label("De: "+event.getTimeDebut());
                      Label lab6=new Label("A: "+event.getTimeFin());
                    Container date=new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Container time=new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    time.add(lab5);
                    time.add(lab6);
                    date.add(lab4);
                    date.add(time);
                     
                    oneEvent.add(date);
                    oneEvent.add(detailContainer);
            Button event_btn=new Button("Participer");
           oneEvent.add(event_btn);
           f.add(oneEvent);
            event_btn.addActionListener((e)->{
                
           });
            
            
           

          f.getToolbar().addCommandToLeftBar(null, theme.getImage("cal_left_arrow.png"), (ev)->{AffichageEvent h=new AffichageEvent(theme);
          h.getF().show();
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    
}
