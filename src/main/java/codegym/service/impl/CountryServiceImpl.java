package codegym.service.impl;


import codegym.model.Country;
import codegym.repository.CountryRepository;
import codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;


    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(int id) {
        return countryRepository.findOne(id);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void remove(int id) {
        countryRepository.delete(id);
    }
}
