package com.neph.main.repo;

import com.neph.main.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author NMuchiri
 **/
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
