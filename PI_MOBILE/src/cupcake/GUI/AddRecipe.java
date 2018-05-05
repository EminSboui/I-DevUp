/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.GUI;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.FloatingHint;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import cupcake.Entite.Component;
import cupcake.Entite.Recipe;
import cupcake.Services.ServiceComponent;
import cupcake.Services.ServiceRecipe;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Dorra
 */
public class AddRecipe extends BaseForm{

    Form f;
    Container addRecipe;
    Container ajout;
    int nbr, i;
    private String imgPath = "";
    private String imgName = "";
    boolean imageselected = false;
    
    public AddRecipe() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public AddRecipe(Resources resourceObjectInstance){
        
        ajout = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        addRecipe = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        f = new Form("Ajouter une recette");
        
        Image selection = resourceObjectInstance.getImage("selection-in-sidemenu.png");
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
        f.getToolbar().addCommandToSideMenu("Afficher les recettes", statsImage, e -> new DisplayRecipe(resourceObjectInstance).show());
        
        TextField Nom = new TextField("", "Nom de la recette", 50, TextField.BASELINE);
        TextField Description = new TextField("", "Description", 50, TextField.BASELINE);
        TextField Composant = new TextField("","Composant",50,TextField.BASELINE);
        TextField Unity = new TextField("","Unité",50,TextField.BASELINE);
        
        Nom.getAllStyles().setAlignment(5);
        Description.getAllStyles().setAlignment(5);
        Description.setSingleLineTextArea(false);
        Description.setRows(5);
        Composant.getAllStyles().setAlignment(5);
        Unity.getAllStyles().setAlignment(5);
        
        Label NomIcon = new Label("", "TextField");
        Label DescriptionIcon = new Label("", "TextField");
        Label ComposantIcon = new Label("","TextField");
        Label UnityIcon = new Label("","TextField");
        
        NomIcon.getAllStyles().setMargin(RIGHT, 0);
        DescriptionIcon.getAllStyles().setMargin(RIGHT, 0);
        ComposantIcon.getAllStyles().setMargin(RIGHT, 0);
        UnityIcon.getAllStyles().setMargin(RIGHT, 0);
        
        FontImage.setMaterialIcon(NomIcon, FontImage.MATERIAL_DETAILS, 3);
        FontImage.setMaterialIcon(DescriptionIcon, FontImage.MATERIAL_DETAILS, 3);
        FontImage.setMaterialIcon(ComposantIcon, FontImage.MATERIAL_DETAILS, 3);
        FontImage.setMaterialIcon(UnityIcon, FontImage.MATERIAL_DETAILS, 3);
        
        Button btnOk = new Button("Ajouter");
        Button addCompo = new Button("Ajouter composant");
        
        ajout.add(new FloatingHint(Nom));
        ajout.add(new FloatingHint(Description));
        ajout.add(new FloatingHint(Composant));
        ajout.add(new FloatingHint(Unity));
        
        ajout.add(addCompo);
        addRecipe.add(ajout);
        
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
                        Image listingMask = resourceObjectInstance.getImage("logi.jpg");
                        System.out.println("imgpath: " + imgPath);
                        System.out.println("imgname: " + imgName);
                        imageselected = true;
                    } catch (IOException e) {}
                }
            }, Display.GALLERY_IMAGE);
        });
        Recipe recipe = new Recipe(Nom.getText(),Description.getText(),1,imgName);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent l) {
                ServiceRecipe.addRecipe(recipe);
                Dialog.show("Confirmation", "Ajout Avec Succés", "Ok", null);
            }
        });
        addCompo.addActionListener((evt) -> {
            Component component = new Component(Composant.getText(),0,Unity.getText(),recipe.getRecipeid());
            ServiceComponent.addComponent(component);
        });
        addRecipe.add(fab);
        addRecipe.add(btnOk);
        //setupSideMenu(res);
        f.add(addRecipe);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
