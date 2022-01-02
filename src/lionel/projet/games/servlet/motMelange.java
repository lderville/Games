package lionel.projet.games.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lionel.projet.games.bll.Dictionnaire;



@WebServlet("/motMelange")
public class motMelange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String mot_melange = "/WEB-INF/jsp/motMelange.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<String> list_de_mot=Dictionnaire.getInstance().melangeMot();
		
		String mot = list_de_mot.get(0);
		String mot_mel = list_de_mot.get(1);
		
		System.out.println(mot);
		System.out.println(mot_mel);
		char [] arrayChar = mot_mel.toCharArray();
		int nombre_lettre = arrayChar.length;
		
		request.getSession().setAttribute("mot", mot);
		request.getSession().setAttribute("mot_mel", mot_mel);
		request.getSession().setAttribute("nombre_lettre", arrayChar.length-1);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(mot_melange);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
