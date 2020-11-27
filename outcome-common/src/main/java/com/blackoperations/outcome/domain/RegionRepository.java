package com.blackoperations.outcome.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region, Long> {

    List<Region> findAll();

    Region save(Region region);
}
