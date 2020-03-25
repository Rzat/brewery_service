package com.example.brewery_service.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto implements Serializable {

    static final long serialVersionUID = 330761661521231767L;

    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotNull
    private BeerStyleEnum beerStyle;

    @Null
    private Integer version;

    @Null
    @JsonFormat(pattern = "yyy-MM-dd'T'HH:MM:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null
    @JsonFormat(pattern = "yyy-MM-dd'T'HH:MM:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;


    @NotNull
    private String upc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive
    @NotNull
    private BigDecimal price;

    private Integer quantityOnHand;

}
