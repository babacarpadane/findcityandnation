package it.objectmethod.citta.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NomeContImpl implements NationForDao {

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
	public Nation findByNameCont(String nome, String continente) {
		Connection conn = getConnection();
		Nation n = new Nation();

		String sql = "SELECT * FROM world.country WHERE Name = ? AND Continent = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, continente);

			ResultSet table = stmt.executeQuery();
			while (table.next()) {
				n.setCode(table.getString("Code"));
				n.setName(table.getString("Name"));
				n.setContinent(table.getString("Continent"));
				n.setPopulation(table.getLong("Population"));
				n.setSurfaceArea(table.getLong("SurfaceArea"));
			}

			table.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;
	}
}
