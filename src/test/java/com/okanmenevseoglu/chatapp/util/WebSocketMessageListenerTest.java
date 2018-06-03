package com.okanmenevseoglu.chatapp.util;

import com.okanmenevseoglu.chatapp.model.ChatMessage;
import com.okanmenevseoglu.chatapp.model.MessageAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.StompSubProtocolHandler;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WebSocketMessageListenerTest {

    @Mock
    private SimpMessageSendingOperations messagingTemplate;

    @InjectMocks
    private WebSocketMessageListener webSocketMessageListener;

    @Captor
    private ArgumentCaptor<ChatMessage> chatMessageArgumentCaptor;

    @Test
    public void shouldHandleWebSocketDisconnectListener() {
        HashMap<String, Object> headers = new HashMap<>();
        HashMap<String, String> sessionInfo = new HashMap<>();
        sessionInfo.put("username", "chatUser");
        headers.put("simpSessionAttributes", sessionInfo);

        SessionDisconnectEvent sessionDisconnectEvent = new SessionDisconnectEvent(new StompSubProtocolHandler(), new GenericMessage<>(new byte[0], headers), "12345", new CloseStatus(1000));

        webSocketMessageListener.handleWebSocketDisconnectListener(sessionDisconnectEvent);

        verify(messagingTemplate).convertAndSend(eq("/topic/chat"), chatMessageArgumentCaptor.capture());

        ChatMessage chatMessage = chatMessageArgumentCaptor.getValue();

        assertThat(chatMessage.getChatUser()).isEqualTo("chatUser");
        assertThat(chatMessage.getMessageAction()).isEqualTo(MessageAction.LEAVE);
        assertThat(chatMessage.getMessage()).isNull();
        assertThat(chatMessage.getMessageTime()).isNull();
    }
}