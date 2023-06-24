package com.ajcordenete.microservices.currencyconversionservice.controller;

import com.ajcordenete.microservices.currencyconversionservice.entity.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

    @GetMapping("/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion calculateConversion(
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency,
            @PathVariable BigDecimal quantity
            ) {

        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("fromCurrency", fromCurrency);
        uriVariables.put("toCurrency", toCurrency);

        ResponseEntity<CurrencyConversion> response = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{fromCurrency}/to/{toCurrency}",
                CurrencyConversion.class,
                uriVariables
        );

        CurrencyConversion currencyConversion = response.getBody();

        return new CurrencyConversion(
                currencyConversion.getId(),
                currencyConversion.getFromCurrency(),
                currencyConversion.getToCurrency(),
                quantity,
                currencyConversion.getConversionMultiplier(),
                quantity.multiply(currencyConversion.getConversionMultiplier()),
                currencyConversion.getEnvironment()
        );
    }
}
