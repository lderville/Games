package lionel.projet.games.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lionel.projet.games.bll.BLLException;
import lionel.projet.games.bll.UtilisateurManager;
import lionel.projet.games.bo.Utilisateur;


@WebServlet(name = "createUserServlet", urlPatterns = { "/CreateUser" })
public class createUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CreateUser = "/WEB-INF/jsp/CreateUser.jsp";
	private static final String Login = "/WEB-INF/jsp/Login.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = "pseudo*";
		String prenom = "prenom*";
		String nom = "nom*";
		String email = "email*";
		String telephone = "telephone*";
		String rue = "rue*";
		String code_postal = "code postal*";
		String ville = "ville*";
		String password = "mot de passe*";
		String passwordConf = "confirmation mot de passe*";
		
		
		Utilisateur newUser = new Utilisateur(pseudo, prenom, nom, email, telephone, rue, code_postal, ville, passwordConf, 0, false);
		request.setAttribute("inscription", newUser);
		
		Utilisateur user =(Utilisateur) request.getAttribute("inscription");
		
		System.out.println(user.toString());
		request.setAttribute("wrong", "");
		RequestDispatcher dispatcher = request.getRequestDispatcher(CreateUser);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("pseudo");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("mail");
		String telephone = request.getParameter("phone");
		String rue = request.getParameter("rue");
		String code_postal = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String password = request.getParameter("password");
		String passwordConf = request.getParameter("PasswordConf");
		
		int jeton = 0 ;
		boolean administrateur = false;
		
		
		Utilisateur newUser = new Utilisateur(pseudo, prenom, nom, email, telephone, rue, code_postal, ville, password, jeton, administrateur);
		System.out.println(newUser.toString());
		List<Utilisateur> list_user2 = null;
		List<Utilisateur> list_user = null;
		try {
			list_user = UtilisateurManager.getInstance().SeLoguer(pseudo);
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			 list_user2 = UtilisateurManager.getInstance().SeLoguer(email);
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		if (password.equals(passwordConf) && list_user.isEmpty() && list_user2.isEmpty()) {
			
			//requête bll 
			try {
				UtilisateurManager.getInstance().ajouterUtilisateur(newUser);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(Login);
			dispatcher.forward(request, response);
			
		} else {
			
			
			
			request.setAttribute("inscription", newUser);
			request.setAttribute("wrong", "mauvaise confimation mot de passe ");
			
			if (!list_user.isEmpty() || !list_user2.isEmpty()) {
				
				request.setAttribute("wrong", "pseudo ou email déjà pris ");
			}
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(CreateUser);
			dispatcher.forward(request, response);

		}
		
		
		
		
		
		
	}

}
