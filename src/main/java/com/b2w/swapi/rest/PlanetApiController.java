package com.b2w.swapi.rest;

import com.b2w.swapi.domain.Planet;
import com.b2w.swapi.domain.error.ApiError;
import com.b2w.swapi.domain.error.ApiException;
import com.b2w.swapi.service.PlanetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlanetApiController {

    private final PlanetService service;

    @GetMapping(value = "/planet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll()
    {
        return service.findAll()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/planet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getById(@PathVariable(value = "id") String id)
    {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/planet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getByName(@RequestParam(value = "name") String name)
    {
        return service.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/planet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getByName(@RequestBody @Valid Planet planet)
    {
        try{
            final Planet newPlanet = service.create(planet);
            return new ResponseEntity(newPlanet, HttpStatus.CREATED);
        } catch (ApiException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new ApiError(ex));
        }
    }
}
