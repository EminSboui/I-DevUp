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
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import cupcake.Entite.Event;
import cupcake.Services.ServiceEvent;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class AffichageEvent {
                public static int id;
                Form f;
                SpanLabel lb;
                Label label;
                String url;
                EncodedImage enc;
                URLImage uRLImage;
                ImageViewer imgV;
                Container oneEvent;
      
 
                
                 public AffichageEvent(Resources theme) {
        
        f = new Form("Tous Les Evenements",new BoxLayout(BoxLayout.Y_AXIS));
        ArrayList<Event> lis= ServiceEvent.getList2();
        for(Event l:lis){
                         oneEvent=new Container(new BoxLayout(BoxLayout.X_AXIS));
                    url="http://localhost/pidevWEB_v1.0/web/uploads/images/"+l.getPicture();
            System.out.println(url);
            enc=EncodedImage.createFromImage(theme.getImage("menu.png"), false);
            uRLImage=URLImage.createToStorage(enc, url, url,URLImage.RESIZE_SCALE_TO_FILL);
            imgV=new ImageViewer(uRLImage);
            oneEvent.add(imgV);
            Label lab3=new Label(l.getNameEvent());
            oneEvent.add(lab3);
           Label lab1=new Label(l.getAdresse());
           oneEvent.add(lab1);
            Button event_btn=new Button("Détail");
            oneEvent.add(event_btn);
            f.add(oneEvent);
             event_btn.addActionListener((e)->{
               id=l.getId();
               DisplayOneEvent display= new DisplayOneEvent(theme);
               display.getF().show();
           });
        }
          f.getToolbar().addCommandToLeftBar(null, theme.getImage("cal_left_arrow.png"), (ev)->{HomeForm h=new HomeForm(theme);
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
