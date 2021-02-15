package it.objectmethod.citta.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FindCityImpl implements CityForDao {

	private Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:33060/", "omdev", "omdev");

		} catch (Exception e) {
			e.printStackTrace();

		}

		return conn;
	}

	@Override
	public City findCityByName(String name) {
		Connection con = getConnection();
		City citta = new City();
		String sql = "SELECT * FROM	world.city WHERE Name = ?";
		

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);

			ResultSet table = stmt.executeQuery();
			while (table.next()) {
				citta.setId(table.getLong("ID"));
				citta.setName(table.getString("Name"));
				citta.setCountryCode(table.getString("CountryCode"));
				citta.setDistrict(table.getString("District"));
				citta.setPopulation(table.getLong("Population"));
			}

			table.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return citta;
	}

}
