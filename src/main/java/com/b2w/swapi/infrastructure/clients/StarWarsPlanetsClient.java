package com.b2w.swapi.infrastructure.clients;

import com.b2w.swapi.domain.external.SWAPIResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${swapi.external.apiurl}")
public interface StarWarsPlanetsClient {

    @GetMapping(value = "/planets/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    SWAPIResponse getSWAPIPlanet(@PathVariable("id") String id);
}
