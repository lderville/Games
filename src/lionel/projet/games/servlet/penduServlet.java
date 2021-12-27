package lionel.projet.games.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import lionel.projet.games.bll.PenduManager;

/**
 * Servlet implementation class penduServlet
 */
@WebServlet("/pendu")
public class penduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String pendu = "/WEB-INF/jsp/lependu.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mot_alea = null;
		String mot_alea_vide= null;
	
			 mot_alea = PenduManager.getInstance().tirageAuHasard();

			
		System.out.println(mot_alea);
		
		 char[] myChars = mot_alea.toCharArray();
		 char[] mychars_mot_vide = new char[myChars.length];
		for (int i = 0; i < myChars.length; i++) {
			
				mychars_mot_vide[i]= '_';
		}
		 
		 mot_alea_vide = String.valueOf(mychars_mot_vide);
		 
		 for (int i=0; i<myChars.length; i++){
	            System.out.println(myChars[i]);
		 }
		 
		 request.getSession().setAttribute("nblettres", myChars.length-1);
		 System.out.println(myChars.length);
		 
		request.getSession().setAttribute("mot_a_trouver_vide", mot_alea_vide); 
		request.getSession().setAttribute("mot_a_trouver", mot_alea);
		request.getSession().setAttribute("mot", myChars);
		request.getSession().setAttribute("urlimage", "imagePendu/Le-Pendu-1.png");
		request.getSession().setAttribute("tentative", 1);
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher(pendu);
		dispatcher.forward(request, response);
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String para_lettre=request.getParameter("choixlettre");
		
		
		
		
		char lettre_recu = para_lettre.charAt(0);
		System.out.println(lettre_recu);
		String mot_alea_vide =(String) request.getSession().getAttribute("mot_a_trouver_vide");
		System.out.println(mot_alea_vide);
		String mot_alea = (String) request.getSession().getAttribute("mot_a_trouver");
		System.out.println(mot_alea);
		
		char[] myChars = mot_alea.toCharArray();
		char[] mychars_mot_vide = mot_alea_vide.toCharArray();
		
		int tentative = (int) request.getSession().getAttribute("tentative");
		boolean contains = false;
		for (char c : myChars) {
		    if (c == lettre_recu) {
		        contains = true;
		        
		        break;
		    }
		}
		if (contains==false) {
		    tentative = tentative+1;
		    request.getSession().setAttribute("tentative", tentative);
		    request.getSession().setAttribute("urlimage", "imagePendu/Le-Pendu-1.png");
		}
		
		
		switch (tentative) {
		case 1:
			request.getSession().setAttribute("urlimage", "imagePendu/Le-Pendu-1.png");
			break;
		case 2:
			request.getSession().setAttribute("urlimage", "imagePendu/Le-Pendu-2.png");		
					break;
		case 3:
			request.getSession().setAttribute("urlimage", "imagePendu/Le-Pendu-3.png");
			break;
		case 4:
			request.getSession().setAttribute("urlimage", "imagePendu/Le-Pendu-4.png");
			break;
		case 5:
			request.getSession().setAttribute("urlimage", "imagePendu/Le-Pendu-5.png");
			break;
		case 6:
			request.getSession().setAttribute("urlimage", "imagePendu/Le-Pendu-6.png");		
					break;
		case 7:
			request.getSession().setAttribute("urlimage", "imagePendu/Le-Pendu-7.png");
			break;

		default:
			request.getSession().setAttribute("urlimage", "imagePendu/Le-Pendu-8.png");
			
			break;
		}
		

		for (int i = 0; i < myChars.length; i++) {
			System.out.println(mychars_mot_vide[i]);
			if (myChars[i]== lettre_recu || (myChars[i]=='â' && lettre_recu =='a')||(myChars[i]=='é' && lettre_recu =='e')) {
				mychars_mot_vide[i]= myChars[i];
				
			}else if (mychars_mot_vide[i]!='_') {
				mychars_mot_vide[i]= mychars_mot_vide[i];
			
			}else  {
				mychars_mot_vide[i]= '_';
			}

	}
		mot_alea_vide = String.valueOf(mychars_mot_vide);
		request.getSession().setAttribute("mot_a_trouver_vide", mot_alea_vide); 
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pendu);
		dispatcher.forward(request, response);
	}

}
