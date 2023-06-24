package com.ajcordenete.microservices.currencyexchangeservice.repository;

import com.ajcordenete.microservices.currencyexchangeservice.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
