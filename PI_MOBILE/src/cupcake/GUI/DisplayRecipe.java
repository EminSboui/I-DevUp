/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.GUI;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import cupcake.Entite.Recipe;
import cupcake.Services.ServiceRecipe;
import java.util.ArrayList;

/**
 *
 * @author Dorra
 */
public class DisplayRecipe extends BaseForm{
    ScaleImageLabel sl;

    public DisplayRecipe() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public DisplayRecipe(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        initGuiBuilderComponents(resourceObjectInstance);
        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
                
        installSidemenu(resourceObjectInstance);        
        
        gui_Text_Area_2.setRows(2);
        gui_Text_Area_2.setColumns(100);
        gui_Text_Area_2.setGrowByContent(false);
        gui_Text_Area_2.setEditable(false);
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setGrowByContent(false);
        gui_Text_Area_1.setEditable(false);
    }

    @Override
    public void installSidemenu(Resources res) {
        
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
        getToolbar().addCommandToSideMenu("Ajouter recette", statsImage, e -> new AddRecipe(res).getF().show());

    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 ;
    private com.codename1.ui.Container cntRecipeName;
    private com.codename1.components.MultiButton gui_Multi_Button_1;
    private com.codename1.components.MultiButton gui_Multi_Button_3;
    private com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_imageContainer1;
    private com.codename1.ui.Container gui_Container_2;
    private com.codename1.ui.TextArea gui_Text_Area_1;
    private com.codename1.ui.Button gui_Button_1;
    private com.codename1.ui.Label gui_separator1;
    EncodedImage enc;
    URLImage uRLImage;
    private com.codename1.ui.Container gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_null_1_1_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Toutes les recettes");
        setName("TrendingForm");
        
        ServiceRecipe serviceRecipe=new ServiceRecipe();
        ArrayList<Recipe> lis=serviceRecipe.getList();
        
        for (Recipe li : lis) {
            
        gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        cntRecipeName = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout()); 
        gui_Multi_Button_1 = new com.codename1.components.MultiButton();
        gui_Multi_Button_3 = new com.codename1.components.MultiButton();
        gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        gui_Text_Area_1 = new com.codename1.ui.TextArea();
        gui_Button_1 = new com.codename1.ui.Button();
        gui_separator1 = new com.codename1.ui.Label();
        
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1);
        gui_Multi_Button_1.setUIID("Label");
        gui_Multi_Button_1.setName("Multi_Button_1");
        gui_Multi_Button_1.setIcon(resourceObjectInstance.getImage("contact-c.png"));
        gui_Multi_Button_1.setPropertyValue("line1", ServiceRecipe.getUser(li.getRecipeuser()).getUsername());
        gui_Multi_Button_1.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_1.setPropertyValue("uiid2", "RedLabel");
        
        addComponent(cntRecipeName);
        cntRecipeName.setName("Container_1");
        cntRecipeName.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_3);
        gui_Multi_Button_3.setUIID("Label");
        gui_Multi_Button_3.setName("Multi_Button_1");
        gui_Multi_Button_3.setPropertyValue("line1", li.getRecipename());
        gui_Multi_Button_3.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_3.setPropertyValue("uiid2", "RedLabel"); 
        
        String url = "http://localhost:8000/pidev/web/uploads/images/"+li.getPicture() ;
        enc = EncodedImage.createFromImage(resourceObjectInstance.getImage("card.png"), false);
        uRLImage = URLImage.createToStorage(enc, url, url, URLImage.RESIZE_SCALE_TO_FILL);
        sl = new ScaleImageLabel(uRLImage);
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer1.add(BorderLayout.CENTER, sl);
        
        addComponent(gui_imageContainer1);
        gui_imageContainer1.setName("imageContainer1");
        gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
        
        gui_Container_2.setName("Container_2");
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_1);
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_1);
        gui_Text_Area_1.setText(li.getDescription());
        gui_Text_Area_1.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_1.setName("Text_Area_1");
        gui_Text_Area_1.setEditable(false);
        
        gui_Button_1.setText("");
        gui_Button_1.setUIID("Label");
        gui_Button_1.setName("Button_1");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_1,"".charAt(0));
        gui_Button_1.addActionListener((evt) -> {
            new DisplayOne(resourceObjectInstance,li).show();
        });
        
        addComponent(gui_separator1);
        gui_separator1.setUIID("Separator");
        gui_separator1.setName("separator1");
          
        }
        
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

    @Override
    protected boolean isCurrentTrending() {
        return true;
    }
}