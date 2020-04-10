package com.example.brewery_service.bootstrap;

import com.example.brewery_service.domain.Beer;
import com.example.brewery_service.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
   // public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");

    private final BeerRepository beerRepositories;


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
                    .upc(BEER_1_UPC)
                    .build());

            beerRepositories.save(Beer.builder()
                    .beerName("Galaxy cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .price(new BigDecimal("11.50"))
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .build());

            beerRepositories.save(Beer.builder()
                    .beerName("No Hammers on the bar")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .price(new BigDecimal("11.50"))
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .build());
        }
    }
}
