package com.ms.codify.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.codify.entities.City;
import com.ms.codify.repository.CityRepository;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    
    public EntityManager entityManager;

    public void save(City city){
        cityRepository.save(city);
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City get(Long id){
        return cityRepository.findById(id);
    }

    public City getByName(String name){
        return cityRepository.findByName(name);
    }

    public void delete(String name){
        cityRepository.deleteByName(name);
    }
}
