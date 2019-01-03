package com.b2w.swapi.repository;

import com.b2w.swapi.domain.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {

    Optional<Planet> findById(String id);
    Optional<Planet> findByName(String name);
}
