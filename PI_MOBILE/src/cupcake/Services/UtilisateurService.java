/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcake.Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.Map;
/*import java.util.logging.Level;
import java.util.logging.Logger;*/
import cupcake.Entite.User;


public class UtilisateurService {

	public static User user;

	public User getListUtilisateur(String json) {
		User u = new User();
		try {
			JSONParser j = new JSONParser();
			Map<String, Object> utilisateurs = j.parseJSON(new CharArrayReader(json.toCharArray()));
			if (utilisateurs.get("id") != null) {
				//u.setId(Integer.parseInt(utilisateurs.get("id").toString()));
                                u.setUsername(utilisateurs.get("username").toString());
                                u.setEmail(utilisateurs.get("email").toString());
                                u.setPassword(utilisateurs.get("password").toString());
				u.setPicture(utilisateurs.get("picture").toString());
				u.setFirstname(utilisateurs.get("firstname").toString());
				u.setLastname(utilisateurs.get("lastname").toString());
				u.setTown(utilisateurs.get("town").toString());
				//Integer.parseInt(utilisateurs.get("numTel").toString().trim())
				//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
				//String date = utilisateurs.get("dateNaissance").toString();
				//c.setDate_commande(formatter.parse(date));
				//u.setDate_naissance(formatter.parse(date));
				//(Date) utilisateurs.get("dateNaissance")
				//ArrayList<String> roles = new ArrayList<>();
				//roles = (ArrayList< String>) utilisateurs.get("roles");
				//System.out.println(roles.get(0).toString() + "/" + roles.get(1).toString());
				//u.setRoles(roles.get(0).toString() /*+ "/" + roles.get(1).toString()*/);
				//u.setSalt(utilisateurs.get("salt"));
				//u.setEmail_canonical(utilisateurs.get("emailCanonical").toString());
				//u.setUsername_canonical(utilisateurs.get("usernameCanonical").toString());
//				u.setConfirmation_token(utilisateurs.get("confirmationToken").toString());
				//u.setPassword_requested_at(null);
				//(Date) utilisateurs.get("passwordRequestedAt")
				//(Date) utilisateurs.get("lastLogin")
			}
		} catch (IOException ex) {
		}
		return u;
	}

	public User LoggedUser(String username, String pw) {
		ConnectionRequest con = new ConnectionRequest();
		con.setUrl("http://localhost:8000/symfony-api/web/app_dev.php/loggeduser/"+username);
		con.addResponseListener(new ActionListener<NetworkEvent>() {
			@Override
			public void actionPerformed(NetworkEvent evt) {
				UtilisateurService us = new UtilisateurService();
				user = us.getListUtilisateur(new String(con.getResponseData()));
				if (user.getUsername() != null ) {
                                    System.out.println("GO GO GO");
				}
                                else
                                    System.out.println("NO NO NO");
			}
		});
		NetworkManager.getInstance().addToQueueAndWait(con);
		return user;
	}

//	public void addUser(Client u) {
//		ConnectionRequest con = new ConnectionRequest();
//		con.setPost(true);
//		String Url = "http://localhost/CupCake_Web_VF-master/web/app_dev.php/api/registerUser?";
//		Url += "un=" + u.getUsername();
//		Url += "&email=" + u.getEmail();
//		Url += "&pw=" + u.getPassword();
//		Url += "&Ntel=" + u.getNum_tel();
//		Url += "&nom=" + u.getNom();
//		Url += "&prenom=" + u.getPrenom();
//		Url += "&dateN=" + u.getDate_naissance();
//		Url += "&adresse=" + u.getAdresse();
//		Url += "&sexe=" + u.getSexe();
//		Url += "&image=" + u.getImage();
//		Url += "&roles=" + u.getRoles();
//		con.setUrl(Url);
//		System.out.println("tt");
//		/*con.addResponseListener((e) -> {
//			UtilisateurService us = new UtilisateurService();
//            String str = new String(con.getResponseData());
//			user = us.getListUtilisateur(new String(con.getResponseData()));
//            System.out.println(str);
//        });*/
//		con.addResponseListener(new ActionListener<NetworkEvent>() {
//			@Override
//			public void actionPerformed(NetworkEvent evt) {
//				String str = new String(con.getResponseData());
//				UtilisateurService us = new UtilisateurService();
//				UtilisateurService.user = us.getListUtilisateur(str);
//				System.out.println(str);
//			}
//		});
//		NetworkManager.getInstance().addToQueueAndWait(con);
//		System.out.println(user);
//	}
}
