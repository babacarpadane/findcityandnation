package it.objectmethod.country.info.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import it.objectmethod.country.info.dao.NationDao;
import it.objectmethod.country.info.dao.impl.NationDaoImpl;
import it.objectmethod.country.info.models.Nation;

@WebServlet("/nationservlet")
public class NationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String continent = request.getParameter("continent");

		NationDao a = new NationDaoImpl();
		Nation nazFinale = a.findByNameCont(name, continent);

		request.setAttribute("code", nazFinale.getCode());
		request.setAttribute("nome_n", nazFinale.getName());
		request.setAttribute("continent", nazFinale.getContinent());
		request.setAttribute("population_n", nazFinale.getPopulation());
		request.setAttribute("surface", nazFinale.getSurfaceAea());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}