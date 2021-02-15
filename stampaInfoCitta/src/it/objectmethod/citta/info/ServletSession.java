package it.objectmethod.citta.info;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// String username = request.getParameter("username");
		// String sessionName = (String) session.getAttribute("nome-session"); 
		session.setAttribute("nome-session", request.getParameter("username"));
		request.setAttribute("usernamejsp", "nome-session");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}