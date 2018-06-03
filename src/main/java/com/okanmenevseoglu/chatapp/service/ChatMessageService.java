package com.okanmenevseoglu.chatapp.service;

import com.okanmenevseoglu.chatapp.dto.ChatMessageDTO;
import com.okanmenevseoglu.chatapp.model.ChatMessage;
import com.okanmenevseoglu.chatapp.repository.ChatMessageRepository;
import com.okanmenevseoglu.chatapp.util.ChatMessageBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {

    private final ChatMessageBinder chatMessageBinder;

    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageService(ChatMessageBinder chatMessageBinder, ChatMessageRepository chatMessageRepository) {
        this.chatMessageBinder = chatMessageBinder;
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessageDTO saveChatMessageToDB(ChatMessageDTO chatMessageDTO) {
        ChatMessage chatMessage = chatMessageBinder.bind(chatMessageDTO);
        chatMessageRepository.save(chatMessage);
        return chatMessageDTO;
    }
}