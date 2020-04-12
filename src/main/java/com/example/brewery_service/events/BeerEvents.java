package com.example.brewery_service.events;

import com.example.brewery_service.web.model.BeerDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class BeerEvents implements Serializable {
    static final long serialVersionUID = -5183522351230881959L;

    private final BeerDto beerDto;
}
