package it.dennis.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dennis.web.dao.UtenteDAO;
import it.dennis.web.model.Utente;

/**
 * Servlet implementation class GetUtenteController
 */
public class GetUtenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetUtenteController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id")) ;
		UtenteDAO dao = new UtenteDAO();
		Utente utente1 = dao.getUtente(id);
		
		request.setAttribute("utente", utente1);
		
		RequestDispatcher rd = request.getRequestDispatcher("showUtente.jsp");
		rd.forward(request, response);
	}


}
