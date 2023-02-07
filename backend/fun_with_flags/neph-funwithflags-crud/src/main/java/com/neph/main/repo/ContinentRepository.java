package com.neph.main.repo;

import com.neph.main.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author NMuchiri
 **/
public interface ContinentRepository extends JpaRepository<Continent, Integer> {

    Continent findContinentByContinentName(String name);
    Continent findContinentByAbbreviation(String abbreviation);

    void deleteContinentByContinentName(String name);
}
