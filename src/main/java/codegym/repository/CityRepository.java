package codegym.repository;

import codegym.model.City;
import codegym.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Integer> {

    Page<City> findAllByNameContaining(String city, Pageable pageable);

    Iterable<City> findAllByCountry(Country country);


}
