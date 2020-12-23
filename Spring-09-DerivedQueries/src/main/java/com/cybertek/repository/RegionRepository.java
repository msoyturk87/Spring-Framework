package com.cybertek.repository;

import com.cybertek.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region,Integer> {

    //Display all regions in canada
    List<Region> findByCountry(String country);

    //Display all regions in canada without distinct
    List<Region> findDistinctByCountry(String country);

    //Display all regions with country name includes United
    List<Region> findAllByCountryContains(String string);

    //Display all regions with country name includes United
    List<Region> findAllByCountryContainsOrderByCountry(String string);




}
