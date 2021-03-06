package com.example.common.events;

import com.example.brewery_service.web.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvents {
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
