package it.objectmethod.citta.info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

public class ServletNation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//if (session.isNew()){
		//	String username = (String) request.getParameter("username");
		//	session.setAttribute("usernamejsp", username);
		//}
		
		String name = request.getParameter("name");
		String continent = request.getParameter("continent");

		NationForDao a = new NomeContImpl();
		Nation nazFinale = a.findByNameCont(name, continent);

		request.setAttribute("code", nazFinale.getCode());
		request.setAttribute("nome_n", nazFinale.getName());
		request.setAttribute("continent", nazFinale.getContinent());
		request.setAttribute("population_n", nazFinale.getPopulation());
		request.setAttribute("surface", nazFinale.getSurfaceAea());
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}