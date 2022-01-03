package lionel.projet.games.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "loginServlet", urlPatterns = { "/login" })
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Login = "/WEB-INF/jsp/Login.jsp";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(Login);
		dispatcher.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String identifiant = request.getParameter("userID");
		String password = request.getParameter("password");
		
		
		
	}

}
