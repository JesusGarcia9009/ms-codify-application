package com.ms.codify.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.codify.entities.City;
import com.ms.codify.service.CityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ciudad")
public class CityControllerImpl implements CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@Valid @RequestBody City city) {
    	log.info("[save] :: Inicio del Metodo" );
        City data = cityService.save(city);
        log.info("[save] :: Fin del Metodo" );
        return new ResponseEntity<>(data, Objects.isNull(data) ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @GetMapping("/obtener-listado")
    public ResponseEntity<List<City>> getAll() throws SQLException {
    	log.info("[getAll] :: Inicio del Metodo" );
        List<City> cities = cityService.getAll();
        log.info("[getAll] :: Fin del Metodo" );
        return new ResponseEntity<>(cities, cities.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<City> get(@PathVariable(value = "id") Long id) {
    	log.info("[get::id] :: Inicio del Metodo" );
        Optional<City> city = cityService.get(id);
        log.info("[get::id] :: Fin del Metodo" );
        return new ResponseEntity<>(city.get(), !city.isPresent() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @GetMapping("/obtener/{name}")
    public ResponseEntity<City> get(@PathVariable(value = "name") String name) {
    	log.info("[get::name] :: Inicio del Metodo" );
        City city = cityService.getByName(name);
        log.info("[get::name] :: Fin del Metodo" );
        return new ResponseEntity<>(city, Objects.isNull(city) ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{name}")
    public ResponseEntity<City> delete(@PathVariable(value = "name") String name) {
    	log.info("[delete] :: Inicio del Metodo" );
        cityService.delete(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
