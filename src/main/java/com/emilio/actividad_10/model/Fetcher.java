package com.emilio.actividad_10.model;

import com.emilio.actividad_10.dto.ApplicationRequest;
import com.emilio.actividad_10.dto.LogRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class Fetcher {

    @Value("${loghub.base-url:http://localhost:8081}")
    private String baseUrl;

    @Value("${loghub.app-id:}")
    private String appId;

    @Value("${loghub.api-key:}")
    private String apiKey;

    private WebClient webClient;

    @PostConstruct
    void init() {
        this.webClient = WebClient.builder().baseUrl(baseUrl).build();
    }

    public Map<String, Object> registerApp(String name, String description, String email) {
        ApplicationRequest body = new ApplicationRequest(name, description, email);
        return webClient.post()
                .uri("/api/application")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();
    }

    public String logRequest(LogLevel logLevel, String message) {
        if (appId == null || appId.isBlank() || apiKey == null || apiKey.isBlank()) {
            System.out.println("[Fetcher] loghub.app-id / loghub.api-key sin configurar, log omitido");
            return null;
        }
        LogRequest body = new LogRequest(appId, logLevel, message);
        return webClient.post()
                .uri("/api/log")
                .header("X-API-KEY", apiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}