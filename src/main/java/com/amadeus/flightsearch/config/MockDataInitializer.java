package com.amadeus.flightsearch.config;

import com.amadeus.flightsearch.services.MockApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MockDataInitializer implements CommandLineRunner {

    private final MockApiService mockApiService;

    public MockDataInitializer(MockApiService mockApiService) {
        this.mockApiService = mockApiService;
    }

    @Override
    public void run(String... args) throws Exception {
        mockApiService.getDataAndSaveToDatabase();
    }
}