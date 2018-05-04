/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.GUI;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import cupcake.Entite.Offer;
import cupcake.Entite.Product;
import cupcake.Services.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author omri_
 */
public class ShowAllProducts extends Form {

    SpanLabel label;
    Container ctn;
    EncodedImage enc;
    URLImage uRLImage;
    ImageViewer imgV;
    Container oneEvent;

    public ShowAllProducts(Resources theme) {
        super(BoxLayout.y());
        ProductService p = new ProductService();
        ctn = new Container(BoxLayout.y());
        setTitle("Tous Produits");
        /* getToolbar().addCommandToLeftBar("<<", null, new ActionListener<ActionEvent>() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ProfileForm a = new ProfileForm(theme);
                a.show();
            }
        }
        );*/
        Button fab = new Button("Ajouter Produit");

        fab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AddProduct(theme).show();
            }
        });

        ctn.add(fab);

        for (Map.Entry<Product, Offer> e : p.getList().entrySet()) {
            
            String url = "http://localhost/piweb/web/uploads/images/" + e.getKey().getPictures();
            System.out.println(url);
            enc = EncodedImage.createFromImage(theme.getImage("menu.png"), false);
            uRLImage = URLImage.createToStorage(enc, url, url, URLImage.RESIZE_SCALE_TO_FILL);
            imgV = new ImageViewer(uRLImage.scaledLargerRatio(200, 100));
            ShareButton share = new ShareButton();
            //share.setImageToShare(url,);
            share.setTextToShare("http://localhost/symfony-api/web/app_dev.php/Product/all");
            ctn.add(share);
            ctn.add(imgV);
            MultiButton mb = new MultiButton(e.getKey().getProductName());

            if (e.getValue().getOfferprice() == 0) {

                mb.setTextLine2(e.getKey().getPrice() + " DT *" + e.getKey().getUnite());
            } else {

                mb.setTextLine2(e.getKey().getPrice() + " DT *" + e.getKey().getUnite() + "  " + e.getValue().getOfferprice() + " DT");
            }

            ctn.add(mb);
            mb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    detailsProduct prod = new detailsProduct(theme, e.getKey(), e.getValue());
                    prod.getF().show();
                }

            });
            
           
        }

        add(ctn);

    }

}