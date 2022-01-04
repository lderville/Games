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


@WebServlet(name = "loginServlet", urlPatterns = { "/login" })
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Login = "/WEB-INF/jsp/Login.jsp";
	private static final String Home = "/index.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(Login);
		dispatcher.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String identifiant = request.getParameter("userID");
		String password = request.getParameter("password");
		
		
		List<Utilisateur> listUtilisateurs = null;
		try {
			listUtilisateurs = UtilisateurManager.getInstance().SeLoguer(identifiant);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		if (listUtilisateurs.isEmpty()) {
			
			request.setAttribute("wrongpassword", "Compte inéxistant");
			RequestDispatcher dispatcher = request.getRequestDispatcher(Login);
			dispatcher.forward(request, response);
			
			
		} else { 
			
			Utilisateur utilisateur =listUtilisateurs.get(0);
			String pseudo =utilisateur.getPseudo();
			String email = utilisateur.getEmail();
			
			if ((pseudo.equals(identifiant) || email.equals(identifiant)) && password.equals(utilisateur.getPassword())) {
				
				request.getSession().setAttribute("user", utilisateur);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(Home);
				dispatcher.forward(request, response);
				
				
			} else {
				request.setAttribute("wrongpassword", "Mauvais mot de passe ou mauvais login");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(Login);
				dispatcher.forward(request, response);
				
				

			}
			
			
			
		}
		

		
		
	}

}
