package com.example.brewery_service.services.brewing;

import com.example.brewery_service.config.JmsConfig;
import com.example.brewery_service.domain.Beer;
import com.example.brewery_service.repositories.BeerRepository;
import com.example.brewery_service.web.model.BeerDto;
import com.example.common.events.BrewBeerEvent;
import com.example.common.events.NewInventoryEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;


    /*  @Transactional
      @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
      public void listen(BrewBeerEvent event) {
          BeerDto beerDto = event.getBeerDto();

          Beer beer = beerRepository.getOne(beerDto.getId());

          beerDto.setQuantityOnHand(beer.getQuantityToBrew());

          NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

          log.debug("Brewed Beer " + beer.getMinOnHand() + " : QOH " + beerDto.getQuantityOnHand());
          jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
      }
      */

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen2(String string) {
        BrewBeerEvent brewBeerEvent = null;
        try {
            brewBeerEvent = objectMapper.readValue(string, BrewBeerEvent.class);
            BeerDto beerDto = brewBeerEvent.getBeerDto();

            Beer beer = beerRepository.getOne(beerDto.getId());

            beerDto.setQuantityOnHand(beer.getQuantityToBrew());

            NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

            log.debug("Brewed Beer " + beer.getMinOnHand() + " : QOH " + beerDto.getQuantityOnHand());
            jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
