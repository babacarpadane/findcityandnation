package it.objectmethod.country.info.dao;

import it.objectmethod.country.info.models.City;

public interface CityDao {
	public City findCityByName(String name);
	

}
