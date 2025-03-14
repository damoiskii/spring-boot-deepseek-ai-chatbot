package com.moiskii.sbds.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatbotServiceImpl implements ChatbotService {
    private final ChatClient chatClient;

    @Override
    public String chat(String message) {
        return chatClient.prompt(message).call().content();
    }
}
