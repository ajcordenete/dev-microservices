package com.ajcordenete.microservices.limitsservice.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("limits-service")
@Component
public class LimitsConfiguration {

    private int minimum;
    private int maximum;

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMinimum(int minimumm) {
        this.minimum = minimumm;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
