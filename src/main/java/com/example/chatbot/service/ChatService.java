package com.example.chatbot.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {
  public void saveMessage(String message) {
    // 메시지 저장 로직 구현
    System.out.println("Message saved: " + message);
  }
}
