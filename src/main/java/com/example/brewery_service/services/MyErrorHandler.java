package com.example.brewery_service.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Slf4j
@Service
public class MyErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        log.error("Error in listener", t);
    }
}