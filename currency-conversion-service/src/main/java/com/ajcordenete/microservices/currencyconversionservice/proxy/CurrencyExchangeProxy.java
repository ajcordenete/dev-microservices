package com.ajcordenete.microservices.currencyconversionservice.proxy;

import com.ajcordenete.microservices.currencyconversionservice.entity.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyConversion getCurrencyExchange(
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency
    );
}
