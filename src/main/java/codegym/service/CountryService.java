package codegym.service;


import codegym.model.Country;

public interface CountryService {

    Iterable<Country> findAll();

    Country findById(int id);

    void save(Country country);

    void remove(int id);


}
