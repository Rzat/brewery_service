package com.example.brewery_service.events;

import com.example.brewery_service.web.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvents {
    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
