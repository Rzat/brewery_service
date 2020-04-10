package com.example.brewery_service.services.inventory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled //utility for manual testing
@SpringBootTest
class BeerInventoryServiceRestTemplateImplTest {

    @Autowired
    BeerInventoryService beerInventoryService;

    @Test
    void getOnHandInventory() {
      //  Integer onHand = beerInventoryService.getOnHandInventory(BeerLoader.BEER_1_UUID);
       // System.out.println("Quantity on Hand" + onHand);
    }
}