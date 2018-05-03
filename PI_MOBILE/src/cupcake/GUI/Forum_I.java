/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.GUI;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import cupcake.Entite.Forum;
import cupcake.Entite.test;
import cupcake.Services.Service_Forum;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author Amine Sboui
 */
public class Forum_I {

    private String imgPath = "";
    private String imgName = "";
    boolean imageselected = false;

    public void HomePage(Resources theme) {
        Form f;
        TextField titre;
        TextField contenue;
        ComboBox categorie;
        Picker date;
        TextField citation;
        TextField tags;
        Button btnajout;
        f = new Form("home");
        titre = new TextField("", "Titre", 20, TextField.EMAILADDR);
        categorie = new ComboBox("Recette", "Produit", "Evenement");
        contenue = new TextField("", "Contenue", 20, TextField.EMAILADDR);
        date = new Picker();
        date.setType(Display.PICKER_TYPE_DATE);
        date.setDate(new Date());
        citation = new TextField("", "Citation", 20, TextField.EMAILADDR);
        tags = new TextField("", "Tags", 20, TextField.EMAILADDR);
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_IMAGE);

        fab.addActionListener((ActionListener) (ActionEvent evt) -> {
            Display.getInstance().openGallery((ActionListener) (ActionEvent ev) -> {
                if (ev != null && ev.getSource() != null) {
                    imgPath = (String) ev.getSource();
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
                        e.printStackTrace();
                    }

                }
            }, Display.GALLERY_IMAGE);
        });
        btnajout = new Button("Ajouter");
        f.add(titre);
        f.add(contenue);
        f.add(date);
        f.add(citation);
        f.add(tags);
        f.add(fab);
        f.add(btnajout);
        btnajout.addActionListener((e) -> {
            Service_Forum ser = new Service_Forum();
            test t = new test(titre.getText());
            //Forum fo = new Forum(titre.getText(),55,1, contenue.getText(), "Non Resolu", 0, date.getDate(), 0, 0, 0, citation.getText(), tags.getText(), imgName);
            System.out.println(t);
            ser.test(t);
            ToastBar.showErrorMessage("Forum Ajouté avec succes");

        });
        f.show();
    }
}
