package com.neph.main.repo;

import com.neph.main.entity.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
public interface ContinentRepository extends JpaRepository<Continent, Integer> {

    Continent findContinentByContinentName(String name);
    Continent findContinentByAbbreviation(String abbreviation);

    List<String> findAllContinentName();
    void deleteContinentByContinentName(String name);
}
