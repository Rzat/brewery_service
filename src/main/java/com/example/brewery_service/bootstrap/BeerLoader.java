package com.example.brewery_service.bootstrap;

import com.example.brewery_service.domain.Beer;
import com.example.brewery_service.repositories.BeerRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepositories beerRepositories;

    public BeerLoader(BeerRepositories beerRepositories) {
        this.beerRepositories = beerRepositories;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepositories.count() == 0) {
            beerRepositories.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .price(new BigDecimal("10.50"))
                    .minOnHand(12)
                    .build());

            beerRepositories.save(Beer.builder()
                    .beerName("Galaxy cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .price(new BigDecimal("11.50"))
                    .minOnHand(12)
                    .build());
        }
    }
}
