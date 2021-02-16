package it.objectmethod.country.info.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

import it.objectmethod.country.info.dao.CityDao;
import it.objectmethod.country.info.dao.impl.CityDaoImpl;
import it.objectmethod.country.info.models.City;

@WebServlet("/cityservlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws HTTPException, IOException, ServletException {

		String nameCity = request.getParameter("name");

		CityDao cityDao = new CityDaoImpl();
		City finalCity = cityDao.findCityByName(nameCity);

		request.setAttribute("ID", finalCity.getId());
		request.setAttribute("nome", finalCity.getName());
		request.setAttribute("countryCode", finalCity.getCountryCode());
		request.setAttribute("distretto", finalCity.getDistrict());
		request.setAttribute("population", finalCity.getPopulation());
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
