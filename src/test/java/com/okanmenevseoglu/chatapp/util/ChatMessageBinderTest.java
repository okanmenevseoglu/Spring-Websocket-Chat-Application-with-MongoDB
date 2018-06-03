package com.okanmenevseoglu.chatapp.util;

import com.okanmenevseoglu.chatapp.dto.ChatMessageDTO;
import com.okanmenevseoglu.chatapp.model.ChatMessage;
import com.okanmenevseoglu.chatapp.model.MessageAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ChatMessageBinderTest {

    @InjectMocks
    private ChatMessageBinder chatMessageBinder;

    @Test
    public void shouldBindChatMessageToChatMessageDTO() {
        ChatMessageDTO chatMessageDTO = ChatMessageDTO.builder()
                .message("message")
                .chatUser("chatUser")
                .messageAction("MESSAGE")
                .build();

        ChatMessage chatMessage = chatMessageBinder.bind(chatMessageDTO);

        assertThat(chatMessage.getMessage()).isEqualTo("message");
        assertThat(chatMessage.getChatUser()).isEqualTo("chatUser");
        assertThat(chatMessage.getMessageAction()).isEqualTo(MessageAction.MESSAGE);
        assertThat(chatMessage.getMessageTime()).isCloseTo(Calendar.getInstance().getTime(), 1000);
    }
}