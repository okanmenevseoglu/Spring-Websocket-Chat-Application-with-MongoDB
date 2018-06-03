package com.okanmenevseoglu.chatapp.util;

import com.okanmenevseoglu.chatapp.dto.ChatMessageDTO;
import com.okanmenevseoglu.chatapp.model.ChatMessage;
import com.okanmenevseoglu.chatapp.model.MessageAction;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class ChatMessageBinder {

    public ChatMessage bind(ChatMessageDTO chatMessageDTO) {
        Date messageTime = Calendar.getInstance().getTime();
        setMessageTime(chatMessageDTO, messageTime);

        return ChatMessage.builder()
                .chatUser(chatMessageDTO.getChatUser())
                .message(chatMessageDTO.getMessage())
                .messageAction(Enum.valueOf(MessageAction.class, chatMessageDTO.getMessageAction()))
                .messageTime(messageTime)
                .build();
    }

    private void setMessageTime(ChatMessageDTO chatMessageDTO, Date messageTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String formattedMessageTime = dateFormat.format(messageTime);
        chatMessageDTO.setMessageTime(formattedMessageTime);
    }
}