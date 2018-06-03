package com.okanmenevseoglu.chatapp.repository;

import com.okanmenevseoglu.chatapp.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, Long> {
}