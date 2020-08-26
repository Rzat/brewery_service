package com.example.common.events;

import com.example.brewery_service.web.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvents implements Serializable {
    static final long serialVersionUID = -5183522351230881959L;

    private BeerDto beerDto;
}
