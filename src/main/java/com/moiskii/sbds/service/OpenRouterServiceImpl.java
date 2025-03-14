package com.moiskii.sbds.service;

import com.moiskii.sbds.config.KeyConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OpenRouterServiceImpl implements OpenRouterService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final KeyConfiguration keyConfiguration;

    @Override
    public String chatWithOpenRouter(String userMessage) {
        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + keyConfiguration.getOpenRouterAPIKey());

        // Prepare request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "deepseek/deepseek-r1-zero:free");

        // Create message payload
        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(Map.of("role", "user", "content", userMessage));
        requestBody.put("messages", messages);

        // Create HTTP entity
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Send request and get response
        ResponseEntity<String> response = restTemplate.exchange(keyConfiguration.getOpenRouterAPIUrl(), HttpMethod.POST, requestEntity, String.class);

        return response.getBody();
    }
}
