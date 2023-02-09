package com.neph.main.repo;

import com.neph.main.model.Continent;
import com.neph.main.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findCountryByCountryName(String name);
    List<Country> findCountriesByContinent(Continent continent);
    void deleteCountryByCountryName(String name);
}
