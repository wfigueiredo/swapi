package com.b2w.swapi.service;

import com.b2w.swapi.domain.Planet;
import com.b2w.swapi.domain.error.ApiException;
import com.b2w.swapi.domain.external.SWAPIResponse;
import com.b2w.swapi.infrastructure.clients.StarWarsPlanetsClient;
import com.b2w.swapi.repository.PlanetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanetService {

    private final PlanetRepository repository;
    private final StarWarsPlanetsClient client;

    public Optional<List<Planet>> findAll(){
        return Optional.ofNullable(repository.findAll());
    }

    public Optional<Planet> findById(String id){
        return repository.findById(id);
    }

    public Optional<Planet> findByName(String name){
        return repository.findByName(name);
    }

    public Planet create(Planet planet){
        getSWAPIPlanet(planet.getId())
            .ifPresent(apiPlanet -> {
                planet.setFilms(apiPlanet.getFilms().size());
                repository.insert(planet);
            });

        return planet;
    }

    private Optional<SWAPIResponse> getSWAPIPlanet(String id){
        try {
            return Optional.ofNullable(client.getSWAPIPlanet(id));
        } catch (Exception ex) {
            throw ApiException.builder()
                    .code("SWAPI001")
                    .reason("No Planet was found under SWAPI for given Planet Id.")
                    .message(ex.getMessage())
                    .build();
        }
    }
}
