package com.neph.main.repo;

import com.neph.main.entity.Country;
import com.neph.main.entity.Flag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
public interface FlagRepository extends JpaRepository<Flag, Integer> {

    Flag findFlagByCountryCountryName(String countryName);

    @Query("SELECT F FROM Flag F INNER JOIN F.country C INNER JOIN C.continent C2 WHERE C2.continentName=:continentName")
    List<Flag> findFlagsByContinent(@Param("continentName") String continentName);

    void deleteFlagByCountry(Country country);
}
