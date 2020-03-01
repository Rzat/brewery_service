package com.example.brewery_service.web.controller;

import com.example.brewery_service.web.model.BeerDto;
import com.example.brewery_service.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(RestDocumentationExtension.class)
//@AutoConfigureRestDocs(uriScheme = "https", uriHost = "dev.spring.docs", uriPort = 80)
@AutoConfigureRestDocs
@WebMvcTest(BeerController.class)
@ComponentScan(basePackages = "com.example.brewery_service.web.mapper")
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/{beerId}", UUID.randomUUID().toString())
                .param("isCold", "yes")//query param example
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/beer-get",
                        pathParameters(
                                parameterWithName("beerId").description("UUID of desired beer to get.")
                        ),
                        requestParameters(
                                parameterWithName("isCold").description("Is Beer cold Query param")
                        ),
                        responseFields(
                                fieldWithPath("id").description("Id of Beer").type(UUID.class),
                                fieldWithPath("beerName").description("name of Beer"),
                                fieldWithPath("beerStyle").description("style of Beer"),
                                fieldWithPath("version").description("version of Beer"),
                                fieldWithPath("createdDate").description("creation date of Beer").type(OffsetDateTime.class),
                                fieldWithPath("lastModifiedDate").description("modified date of Beer").type(OffsetDateTime.class),
                                fieldWithPath("upc").description("upc of Beer"),
                                fieldWithPath("price").description("price of Beer"),
                                fieldWithPath("quantityOnHand").description("Quantity of Beer")
                        )));
    }

    @Test
    void saveNewbeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoToJson))
                .andExpect(status().isCreated())
                .andDo(document("v1/beer-new",
                        requestFields(
                                fieldWithPath("id").ignored(),
                                fieldWithPath("version").ignored(),
                                fieldWithPath("createdDate").ignored(),
                                fieldWithPath("lastModifiedDate").ignored(),
                                fieldWithPath("quantityOnHand").ignored(),
                                fieldWithPath("beerStyle").description("Beer style"),
                                fieldWithPath("lastModifiedDate").description("Beer lastModifiedDate"),
                                fieldWithPath("upc").description("upc"),
                                fieldWithPath("price").description("price"),
                                fieldWithPath("beerName").description("Beer Name")
                        )));
    }

    /*
    @Test
    void updateBeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoToJson))
                .andExpect(status().isNoContent());
    }
    */


    BeerDto getValidBeerDto() {
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(123123123123L)
                .build();
    }
}