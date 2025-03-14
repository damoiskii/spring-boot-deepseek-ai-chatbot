package com.moiskii.sbds.controller;

import com.moiskii.sbds.service.ChatbotService;
import com.moiskii.sbds.service.ChatbotServiceImpl;
import com.moiskii.sbds.service.DeepSeekServiceImpl;
import com.moiskii.sbds.service.OpenRouterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatbotController {
    final ChatbotServiceImpl chatbotService;
    final DeepSeekServiceImpl deepSeekService;
    final OpenRouterServiceImpl openRouterService;

//    @PostMapping
//    public ResponseEntity<String> chat(@RequestBody String message) {
//        String response = chatbotService.chat(message);
//        return ResponseEntity.ok(response);
//    }

//    @PostMapping
//    public ResponseEntity<String> chat(@RequestBody String message) {
//        return ResponseEntity.ok(deepSeekService.chatWithDeepSeek(message));
//    }

    @PostMapping
    public ResponseEntity<String> chat(@RequestBody String message) {
        return ResponseEntity.ok(openRouterService.chatWithOpenRouter(message));
    }
}
