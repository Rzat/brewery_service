package com.example.brewery_service.services.brewing;

import com.example.brewery_service.config.JmsConfig;
import com.example.brewery_service.domain.Beer;
import com.example.brewery_service.repositories.BeerRepository;
import com.example.brewery_service.services.inventory.BeerInventoryService;
import com.example.brewery_service.web.mapper.BeerMapper;
import com.example.common.events.BrewBeerEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {
    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;
    
    @Scheduled(fixedRate = 5000)
    public void checkForLowInventory() {
        List<Beer> beerList = beerRepository.findAll();
        beerList.forEach(beer -> {
            Integer invQOH = beerInventoryService.getOnHandInventory(beer.getId());

            log.debug("Min OnHand is: " + beer.getMinOnHand());
            log.debug("Inventory is: " + invQOH);

            if (beer.getMinOnHand() >= invQOH) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
