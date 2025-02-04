package com.example.chatbot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chat")
public class Chat {

  @Id
  private String id;
  private String message;

  public Chat(String message) {
    this.message = message;
  }

  // Getter & Setter
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}