package com.example.chatbot.controller;

import org.springframework.web.bind.annotation.RequestBody;
import com.example.chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat") // API 엔드포인트
public class ChatController {

  @Autowired
  private ChatService chatService;

  @GetMapping("/test")
  public String testConnection() {
    return "Server is running!";
  }

  @PostMapping("/saveMessage")
  public String saveMessage(@RequestBody String message) {
    chatService.saveMessage(message);
    return "Message saved!";
  }
}
