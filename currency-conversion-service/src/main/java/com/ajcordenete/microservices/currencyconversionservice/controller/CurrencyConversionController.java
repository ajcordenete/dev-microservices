package com.ajcordenete.microservices.currencyconversionservice.controller;

import com.ajcordenete.microservices.currencyconversionservice.entity.CurrencyConversion;
import com.ajcordenete.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
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
                currencyConversion.getEnvironment() + " " + "rest template"
        );
    }

    @GetMapping("/currency-conversion-feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion calculateConversionUsingProxy(
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency,
            @PathVariable BigDecimal quantity
    ) {

        CurrencyConversion currencyConversion = proxy.getCurrencyExchange(fromCurrency, toCurrency);

        return new CurrencyConversion(
                currencyConversion.getId(),
                currencyConversion.getFromCurrency(),
                currencyConversion.getToCurrency(),
                quantity,
                currencyConversion.getConversionMultiplier(),
                quantity.multiply(currencyConversion.getConversionMultiplier()),
                currencyConversion.getEnvironment() + " " + "feign"
        );
    }
}
