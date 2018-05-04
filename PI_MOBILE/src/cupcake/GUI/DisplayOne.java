/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.GUI;

/**
 *
 * @author Dorra
 */



import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import cupcake.Entite.Recipe;
import cupcake.Services.ServiceRecipe;
import java.util.ArrayList;

public class DisplayOne {
  Form f;

    public DisplayOne() {
        
        f = new Form();
        Container list = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ServiceRecipe serviceRecipe=new ServiceRecipe();
        ArrayList<Recipe> lis=serviceRecipe.getList();
        for (Recipe li : lis) {
            SpanLabel name = new SpanLabel();
            name.setText(li.getRecipename());
            list.add(name);
        }
        f.add(list);
//        lb.setText(lis.get(0).getRecipename());
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{Display h=new Display();
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
