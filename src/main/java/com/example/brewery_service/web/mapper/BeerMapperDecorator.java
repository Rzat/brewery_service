package com.example.brewery_service.web.mapper;

import com.example.brewery_service.domain.Beer;
import com.example.brewery_service.services.inventory.BeerInventoryService;
import com.example.brewery_service.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

//@RequiredArgsConstructor
public abstract class BeerMapperDecorator implements BeerMapper {


    private BeerInventoryService beerInventoryService;
    private BeerMapper beerMapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setBeerMapper(BeerMapper beerMapper) {
        this.beerMapper = beerMapper;
    }


    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        BeerDto dto = beerMapper.beerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnHandInventory(beer.getId()));
        return dto;
    }



    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        return beerMapper.beerDtoToBeer(beerDto);
    }
}
