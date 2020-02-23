package com.example.brewery_service.web.controller;

import com.example.brewery_service.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
@Validated
public class BeerController {

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
        //todo impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewbeer(@RequestBody BeerDto beerDto) {
        //todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PutMapping({"/{beerId"})
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
