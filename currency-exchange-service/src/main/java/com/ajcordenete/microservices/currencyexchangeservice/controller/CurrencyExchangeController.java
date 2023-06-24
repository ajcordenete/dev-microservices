package com.ajcordenete.microservices.currencyexchangeservice.controller;

import com.ajcordenete.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.ajcordenete.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyExchange getCurrencyExchange(
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency
    ) {
        CurrencyExchange exchange = repository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);

        if(exchange == null) {
            throw new RuntimeException("Unable to find data for " + fromCurrency + " and " + toCurrency);
        }

        String port = environment.getProperty("local.server.port");
        exchange.setEnvironment(port);

        return exchange;
    }
}
