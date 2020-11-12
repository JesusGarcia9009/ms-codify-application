package com.ms.codify.service;

import java.util.List;
import java.util.Optional;

import com.ms.codify.entities.City;

/**
 * CityService Operaciones CRUD para la entidad City Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public interface CityService {
	
	
	/**
	 * CityService - save()
	 *
	 * @author Jesus Garcia
	 * @param City - Object
	 * @return City - Object
	 */
	public City save(City city);

	/**
	 * CityService - getAll()
	 *
	 * @author Jesus Garcia
	 * @param none
	 * @return List<City> listado de ciudades
	 */
    public List<City> getAll();

	/**
	 * CityService - get
	 *
	 * @param none
	 * @return Optional<City> 
	 */
    public Optional<City> get(Long id);

    /**
	 * CityService - getByName
	 *
	 * @param none
	 * @return City see object city
	 */
    public City getByName(String name);

    
    /**
	 * CityService - getByName
	 *
	 * @param none
	 * @return String name
	 */
    public void delete(String name);
    
}