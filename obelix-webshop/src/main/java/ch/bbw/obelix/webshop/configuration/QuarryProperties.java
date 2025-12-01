package ch.bbw.obelix.webshop.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "quarry")
public record QuarryProperties(String baseUrl) {}
