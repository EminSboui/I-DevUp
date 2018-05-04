/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.GUI;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import cupcake.Entite.Recipe;
import cupcake.Services.ServiceRecipe;
import java.util.ArrayList;

/**
 *
 * @author Dorra
 */
public class Display {
    Form f;
    Button detail;
    public Display() {
        
        f = new Form();
        Container box = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container list = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ServiceRecipe serviceRecipe=new ServiceRecipe();
        ArrayList<Recipe> lis=serviceRecipe.getList();
        for (Recipe li : lis) {
            detail = new Button("Détail");
            Label Rname = new Label();
            Rname.setText(li.getRecipename());
            detail.addActionListener((evt) -> {
                DisplayOne oneRecipe = new DisplayOne();
                oneRecipe.getF().show();
            });
            box.add(Rname);
            box.add(detail);
            }
        list.add(box);

        f.add(list);
          f.getToolbar().addCommandToRightBar("Back", null, (ev)->{Display h=new Display();
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
