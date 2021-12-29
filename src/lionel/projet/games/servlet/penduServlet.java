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
	private static final String win = "/WEB-INF/jsp/winPage.jsp";
	private static final String loose = "/WEB-INF/jsp/loosePage.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mot_alea = null;
		String mot_alea_vide= null;
	
			 mot_alea = PenduManager.getInstance().tirageAuHasard().toLowerCase();

			
		System.out.println(mot_alea);
		
		 char[] myChars = mot_alea.toCharArray();
		 char[] mychars_mot_vide = new char[myChars.length];
		for (int i = 0; i < myChars.length; i++) {
			
			if (myChars[i] == ' ') {
				mychars_mot_vide[i]=' ';	
			}else if (myChars[i] == '-') {
				mychars_mot_vide[i]='-';
			}else{
			
				mychars_mot_vide[i]= '_';
			}
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
		 
		
		
		request.getSession().setAttribute("a", "enable");
		request.getSession().setAttribute("b", "enable");
		request.getSession().setAttribute("c", "enable");
		request.getSession().setAttribute("d", "enable");
		request.getSession().setAttribute("e", "enable");
		request.getSession().setAttribute("f", "enable");
		request.getSession().setAttribute("g", "enable");
		request.getSession().setAttribute("h", "enable");
		request.getSession().setAttribute("i", "enable");
		request.getSession().setAttribute("j", "enable");
		request.getSession().setAttribute("k", "enable");
		request.getSession().setAttribute("l", "enable");
		request.getSession().setAttribute("m", "enable");
		request.getSession().setAttribute("n", "enable");
		request.getSession().setAttribute("o", "enable");
		request.getSession().setAttribute("p", "enable");
		request.getSession().setAttribute("q", "enable");
		request.getSession().setAttribute("r", "enable");
		request.getSession().setAttribute("s", "enable");
		request.getSession().setAttribute("t", "enable");
		request.getSession().setAttribute("u", "enable");
		request.getSession().setAttribute("v", "enable");
		request.getSession().setAttribute("w", "enable");
		request.getSession().setAttribute("x", "enable");
		request.getSession().setAttribute("y", "enable");
		request.getSession().setAttribute("z", "enable");
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(pendu);
		dispatcher.forward(request, response);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String para_lettre=request.getParameter("choixlettre");

		char lettre_recu = para_lettre.charAt(0);
		
		request.getSession().setAttribute(para_lettre, "disabled");
		
		String salut = (String) request.getSession().getAttribute(para_lettre);
		System.out.println(salut);
		
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
		        request.setAttribute("choix", "bravo Bonne lettre ");
		        
		        break;
		    }
		}
		if (contains==false) {
		    tentative = tentative+1;
		    request.getSession().setAttribute("tentative", tentative);
		    request.getSession().setAttribute("urlimage", "imagePendu/Le-Pendu-1.png");
		    request.setAttribute("choix", "Perdu Mauvaise lettre ");
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
			if (myChars[i]== lettre_recu || (myChars[i]=='â' && lettre_recu =='a')||(myChars[i]=='é' && lettre_recu =='e')||(myChars[i]=='ï' && lettre_recu =='i')) {
				mychars_mot_vide[i]= myChars[i];
				
			}else if (mychars_mot_vide[i]!='_') {
				mychars_mot_vide[i]= mychars_mot_vide[i];
			
			}else  {
				mychars_mot_vide[i]= '_';
			}

	}
		mot_alea_vide = String.valueOf(mychars_mot_vide);
		request.getSession().setAttribute("mot_a_trouver_vide", mot_alea_vide); 
		
		
		if(mot_alea_vide.equals(mot_alea) && tentative<8) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(win);
			dispatcher.forward(request, response);
			
		}else if(tentative>=8) {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher(loose);
			dispatcher.forward(request, response);
		
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(pendu);
			dispatcher.forward(request, response);
			
		}
	}

	
		
		
		
		
}
