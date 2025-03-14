package com.moiskii.sbds.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class KeyConfiguration {
    @Value("${OPENROUTER_API_KEY}")
    private String openRouterAPIKey;

    @Value("${OPENROUTER_API_URL}")
    private String openRouterAPIUrl;

    @Value("${DEEPSEEK_API_KEY}")
    private String deepSeekAPIKey;

    @Value("${DEEPSEEK_API_URL}")
    private String deepSeekAPIUrl;
}
