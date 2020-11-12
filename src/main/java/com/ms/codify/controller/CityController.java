package com.ms.codify.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ms.codify.entities.City;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * CityController - Capa de Rest - Servicio de City - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Api(value = "Microservicio de City", description = "Esta API tiene los servicios referentes a operaciones CRUD de la entidad City")
public interface CityController {


	/**
	 * save - Guardar Objeto de ciudad. - Spring Boot
	 *
	 *
	 * @param City entidad de ciudad
	 * @return ResponseEntity<?> 
	 * @author Jesus Garcia
	 * @since 1.0
	 * @version jdk-11
	 */
	@ApiOperation(value = "Guardar", notes = "Guarda el objeto creado y retorna los datos de la api de coneccion a nuestra aplicacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
	public ResponseEntity<?> save(@RequestBody City city) ;
	
	/**
	 * getAll - Listado de registros de las ciudades. - Spring Boot
	 *
	 * @param City entidad de ciudad
	 * @return ResponseEntity<?> 
	 * @author Jesus Garcia
	 * @since 1.0
	 * @version jdk-11
	 */
	@ApiOperation(value = "Obtener listado", notes = "Listado de registros de las ciudades")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<List<City>> getAll() throws SQLException;
    
	/**
	 * get - Obtiene el objeto por el parametro id. - Spring Boot
	 *
	 * @param id - id de ciudad
	 * @return ResponseEntity<City> 
	 * @author Jesus Garcia
	 * @since 1.0
	 * @version jdk-11
	 */
	@ApiOperation(value = "Obtener", notes = "Obtiene el objeto por el parametro id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<City> get(@PathVariable(value = "id") Long id) ;
    
	/**
	 * get - Obtiene el objeto por el parametro nombre. - Spring Boot
	 *
	 * @param Name - nombre de ciudad
	 * @return ResponseEntity<City>
	 * @author Jesus Garcia
	 * @since 1.0
	 * @version jdk-11 
	 */
	@ApiOperation(value = "Obtener", notes = "Obtiene el objeto por el parametro nombre")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<City> get(@PathVariable(value = "name") String name) ;
    
	/**
	 * delete - Elimina la ciudad por el parametro nombre. - Spring Boot
	 *
	 * @param Name - nombre de ciudad
	 * @return ResponseEntity<?> 
	 * @author Jesus Garcia
	 * @since 1.0
	 * @version jdk-11
	 */
	@ApiOperation(value = "Eliminar", notes = "Elimina la ciudad por el parametro nombre")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<?> delete(@PathVariable(value = "name") String name);
    
    
    
}
