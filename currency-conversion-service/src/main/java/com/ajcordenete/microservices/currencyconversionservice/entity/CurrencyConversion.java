package com.ajcordenete.microservices.currencyconversionservice.entity;

import java.math.BigDecimal;

public class CurrencyConversion {

    private Long id;
    private String fromCurrency;

    private String toCurrency;

    private BigDecimal conversionMultiplier;

    private BigDecimal quantity;

    private BigDecimal totalCalculatedAmount;

    private String environment;

    public CurrencyConversion() {}

    public CurrencyConversion(
            Long id,
            String fromCurrency,
            String toCurrency,
            BigDecimal quantity,
            BigDecimal conversionMultiplier,
            BigDecimal totalCalculatedAmount,
            String environment
    ) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.quantity = quantity;
        this.conversionMultiplier = conversionMultiplier;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.environment = environment;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
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

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
