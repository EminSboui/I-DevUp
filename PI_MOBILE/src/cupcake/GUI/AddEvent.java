/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.GUI;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.FloatingHint;
import com.codename1.components.OnOffSwitch;
import com.codename1.io.FileSystemStorage;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import cupcake.Entite.Event;
import cupcake.Services.ServiceEvent;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Asus
 */
public class AddEvent {
    Form f;
     Container addEvent ;
     Container ajout;
     int nbr,i;
      private String imgPath = "";
    private String imgName = "";
    boolean imageselected = false;
     public AddEvent(Resources theme) {
   
         ajout = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         addEvent = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         f=new Form("Ajouter un Evenement");
         TextField Nom = new TextField("","Nom de l'Evenement",50,TextField.BASELINE);
         TextField Location = new TextField("","Description");
         TextField Texte = new TextField("","Adresse",50,TextField.CENTER);
        Nom.getAllStyles().setAlignment(5);
            Location.setSingleLineTextArea(false);
            Location.setRows(5);
        Texte.getAllStyles();
        Label NomIcon = new Label("", "TextField");
        Label LocationIcon = new Label("", "TextField");
        Label TexteIcon = new Label("", "TextField");
        NomIcon.getAllStyles().setMargin(RIGHT, 0);
        LocationIcon.getAllStyles().setMargin(RIGHT, 0);
        TexteIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(NomIcon, FontImage.MATERIAL_DETAILS, 3);
        FontImage.setMaterialIcon(LocationIcon, FontImage.MATERIAL_LOCATION_CITY, 3);
        FontImage.setMaterialIcon(TexteIcon, FontImage.MATERIAL_LOCATION_CITY, 3);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm aaa");              
        Label db=new Label("Date : ");
         Picker DateMc = new Picker();
        DateMc.setFormatter(format);
        
        Label hd=new Label("Heure Début");
         Picker timestart = new Picker();
         
         timestart.setType(Display.PICKER_TYPE_TIME);
        Label hf=new Label("Heure Fin     :");
         Picker timefin = new Picker();
         timefin.setType(Display.PICKER_TYPE_TIME);
         Container timeS=BoxLayout.encloseY(hd,timestart);
         Container timeF=BoxLayout.encloseY(hf,timefin);
         Container time=BoxLayout.encloseX(timeS,timeF);
        Button btnOk = new Button("Ajouter");
        
        
                ajout.add(new FloatingHint(Nom));
                ajout.add(new FloatingHint(Location));
                ajout.add(new FloatingHint(Texte));
                ajout.add(db);
                ajout.add(DateMc) ; 
                ajout.add(time) ;
                OnOffSwitch ticket = new OnOffSwitch();
                addEvent.add(ajout);
                Container tickets=new Container(new BoxLayout(BoxLayout.X_AXIS));
                Container t = BoxLayout.encloseX(ticket,new Label("Ticket"));
                tickets.add(t);
              
                addEvent.add(tickets);
                TextField nbrr=new TextField("0", "Nombre", 5, TextArea.NUMERIC);
                Container nbrlimite = BoxLayout.encloseY(new Label("Nombre Limite"),nbrr);
                nbrlimite.setVisible(false);
                tickets.add(nbrlimite);
                nbr=0;
                 i=0;
                ticket.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent l) {
                 System.out.println(ticket.isValue());
                 if(ticket.isValue()){
                     nbrlimite.setVisible(true);
                    
                     i=1;
                 }else {
                     nbrlimite.setVisible(false);
                     
                 }
             }
         });
   
       
 
         FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_IMAGE);
 
        fab.addActionListener((ActionListener) (ActionEvent evt) -> {
            Display.getInstance().openGallery((ActionListener) (ActionEvent ev) -> {
                if (ev != null && ev.getSource() != null) {
                    imgPath = (String) ev.getSource();
                    System.out.println((String) ev.getSource());
                    int fileNameIndex = imgPath.lastIndexOf("/") + 1;
                    imgName = imgPath.substring(fileNameIndex);
                    try {
                        InputStream is = FileSystemStorage.getInstance().openInputStream(imgPath);
                        Image im = Image.createImage(is);
                        Image listingMask = theme.getImage("refimg2.jpg");
                        System.out.println("imgpath: " + imgPath);
                        System.out.println("imgname: " + imgName);
                        imageselected = true;
 
                    } catch (IOException e) {
                    }
 
                }
            }, Display.GALLERY_IMAGE);
        });
        btnOk.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent l) {
             nbr=Integer.parseInt(nbrr.getText());
                    System.out.println(DateMc.getText()+"+++"+timestart.getText()+"*******"+nbr);
                 ServiceEvent.ajoutTask(new Event(0, DateMc.getText(),timestart.getText()+":00" ,timefin.getText()+":00", Nom.getText(), Texte.getText(), Location.getText(), imgName, 0,i , nbr, 0.0,0.0,1));
            Dialog.show("Confirmation", "Ajout Avec Succés", "Ok", null);
             }
         });
                         addEvent.add(fab);
                        addEvent.add(btnOk) ;
        // setupSideMenu(res);
            f.add(addEvent);
            
}
  public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
  

    
}
