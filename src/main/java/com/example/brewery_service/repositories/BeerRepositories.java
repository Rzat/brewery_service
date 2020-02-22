package com.example.brewery_service.repositories;

import com.example.brewery_service.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepositories extends PagingAndSortingRepository<Beer, UUID> {
}
