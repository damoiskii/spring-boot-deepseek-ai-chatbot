package com.moiskii.sbds.service;

import com.moiskii.sbds.config.KeyConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DeepSeekServiceImpl implements DeepSeekService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final KeyConfiguration keyConfiguration;

    @Override
    public String chatWithDeepSeek(String userMessage) {
        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + keyConfiguration.getDeepSeekAPIKey());

        // Prepare request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "deepseek-reasoner");

        // Create message payload
        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(Map.of("role", "user", "content", userMessage));
        requestBody.put("messages", messages);

        // Create HTTP entity
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Send request
        ResponseEntity<String> response = restTemplate.exchange(keyConfiguration.getDeepSeekAPIUrl(), HttpMethod.POST, requestEntity, String.class);

        return response.getBody();
    }
}
