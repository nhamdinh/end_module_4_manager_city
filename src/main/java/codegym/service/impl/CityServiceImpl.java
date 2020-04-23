package codegym.service.impl;

import codegym.model.City;
import codegym.model.Country;
import codegym.repository.CityRepository;
import codegym.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CityServiceImpl implements CityService {
    
    
    @Autowired
    private CityRepository cityRepository;


    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public City findById(int id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(int id) {
        cityRepository.delete(id);
    }

    @Override
    public Iterable<City> findAllByCountry(Country country) {
        return cityRepository.findAllByCountry(country);
    }

    @Override
    public Page<City> findAllByNameContaining(String name, Pageable pageable) {
        return cityRepository.findAllByNameContaining(name, pageable);
    }
}
