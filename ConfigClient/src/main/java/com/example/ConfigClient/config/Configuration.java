package com.example.ConfigClient.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="config-client-service")
public class Configuration {

    @Setter
    @Getter
    private Double minBalance;
    @Setter
    @Getter
    private Double maxBalance;
}
