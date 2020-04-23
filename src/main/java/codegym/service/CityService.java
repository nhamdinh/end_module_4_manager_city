package codegym.service;

import codegym.model.City;
import codegym.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {


    Page<City> findAll(Pageable pageable);

    City findById(int id);

    void save(City City);

    void remove(int id);

    Iterable<City> findAllByCountry(Country country);

    Page<City> findAllByNameContaining(String name, Pageable pageable);

}
