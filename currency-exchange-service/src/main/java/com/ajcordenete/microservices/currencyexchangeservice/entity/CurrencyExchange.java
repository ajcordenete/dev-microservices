package com.ajcordenete.microservices.currencyexchangeservice.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency")
    private String fromCurrency;

    @Column(name = "to_currency")
    private String toCurrency;

    @Column(name = "conversion_multiplier")
    private BigDecimal conversionMultiplier;

    @Column(name = "environment")
    private String environment;

    public CurrencyExchange() {}

    public CurrencyExchange(Long id, String fromCurrency, String toCurrency, BigDecimal conversionMultiplier) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionMultiplier = conversionMultiplier;
    }

    public Long getId() {
        return id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public BigDecimal getConversionMultiplier() {
        return conversionMultiplier;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public void setConversionMultiplier(BigDecimal conversionMultiplier) {
        this.conversionMultiplier = conversionMultiplier;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "CurrencyExchange{" +
                "id=" + id +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", currencyMultiplier=" + conversionMultiplier +
                ", environment='" + environment + '\'' +
                '}';
    }
}
