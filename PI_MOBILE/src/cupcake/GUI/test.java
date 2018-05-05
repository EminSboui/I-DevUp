/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.GUI;

import com.codename1.capture.Capture;
import com.codename1.media.*;
import com.codename1.components.MediaPlayer;
import com.codename1.components.MultiButton;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Dorra
 */
public class test extends Form {

//    Form hi;
//    hi= new Form("Capture", new BoxLayout(BoxLayout.Y_AXIS));
//
//    hi.setToolbar(new Toolbar());
//    
//    Style s = UIManager.getInstance().getComponentStyle("Title");
//    FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_MIC, s);
//
//    FileSystemStorage fs = FileSystemStorage.getInstance();
//    String recordingsDir = fs.getAppHomePath() + "recordings/";
//
//    fs.mkdir(recordingsDir);
//
//    try{
//    for (String file : fs.listFiles(recordingsDir)) {
//            MultiButton mb = new MultiButton(file.substring(file.lastIndexOf("/") + 1));
//            mb.addActionListener((e) -> {
//                try {
//                    Media m = MediaManager.createMedia(recordingsDir + file, false);
//                    m.play();
//                } catch (IOException err) {
//                    Log.e(err);
//                }
//            });
//            hi.add(mb);
//        }
//
//        hi.getToolbar().addCommandToRightBar("", icon, (ev) -> {
//            try {
//                String file = Capture.capturePhoto();
//                if (file != null) {
//                    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MMM-dd-kk-mm");
//                    String fileName = sd.format(new Date());
//                    String filePath = recordingsDir + fileName;
//                    Util.copy(fs.openInputStream(file), fs.openOutputStream(filePath));
//                    MultiButton mb = new MultiButton(fileName);
//                    mb.addActionListener((e) -> {
//                        try {
//                            Media m = MediaManager.createMedia(filePath, false);
//                            m.play();
//                        } catch (IOException err) {
//                            Log.e(err);
//                        }
//                    });
//                    hi.add(mb);
//                    hi.revalidate();
//                }
//            } catch (IOException err) {}
//        });
//    }catch(IOException err) {}
//    hi.show();
    final Form hi = new Form("MediaPlayer", new BorderLayout());
hi.setToolbar(new Toolbar());
Style s = UIManager.getInstance().getComponentStyle("Title");
FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_VIDEO_LIBRARY, s);
hi.getToolbar().addCommandToRightBar(new Command("", icon) {
    @Override
    public void actionPerformed(ActionEvent evt) {
        Display.getInstance().openGallery((e) -> {
            if(e != null && e.getSource() != null) {
                String file = (String)e.getSource();
                try {
                    Media video = MediaManager.createMedia(file, true);
                    hi.removeAll();
                    hi.add(BorderLayout.CENTER, new MediaPlayer(video));
                    hi.revalidate();
                } catch(IOException err) {
                    Log.e(err);
                } 
            }
        }, Display.GALLERY_VIDEO);
    }
});
hi.show();
}