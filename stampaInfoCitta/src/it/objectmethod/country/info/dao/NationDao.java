package it.objectmethod.country.info.dao;

import it.objectmethod.country.info.models.Nation;

public interface NationDao {
	public Nation findByNameCont(String nome, String continente);

}
