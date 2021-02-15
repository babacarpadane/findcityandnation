package it.objectmethod.citta.info;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

public class ServletCity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws HTTPException, IOException, ServletException {
		//HttpSession session = request.getSession();
		//if (session.isNew()){
		//	String username = (String) request.getParameter("username");
		//	session.setAttribute("usernamejsp", username);
		//}

		String nameCity = request.getParameter("name");
		
		CityForDao cityDao = new FindCityImpl();
		City finalCity = cityDao.findCityByName(nameCity);

		request.setAttribute("ID", finalCity.getId());
		request.setAttribute("nome", finalCity.getName());
		request.setAttribute("countryCode", finalCity.getCountryCode());
		request.setAttribute("distretto", finalCity.getDistrict());
		request.setAttribute("population", finalCity.getPopulation());
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
