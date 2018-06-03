package com.okanmenevseoglu.chatapp.service;

import com.okanmenevseoglu.chatapp.dto.ChatMessageDTO;
import com.okanmenevseoglu.chatapp.model.ChatMessage;
import com.okanmenevseoglu.chatapp.repository.ChatMessageRepository;
import com.okanmenevseoglu.chatapp.util.ChatMessageBinder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChatMessageServiceTest {

    @Mock
    private ChatMessageBinder chatMessageBinder;

    @Mock
    private ChatMessageRepository chatMessageRepository;

    @InjectMocks
    private ChatMessageService chatMessageService;

    @Test
    public void shouldSaveChatMessageToDBAndReturn() {
        ChatMessage chatMessage = ChatMessage.builder().build();
        ChatMessageDTO chatMessageDTO = ChatMessageDTO.builder().build();

        when(chatMessageBinder.bind(chatMessageDTO)).thenReturn(chatMessage);

        chatMessageService.saveChatMessageToDB(chatMessageDTO);

        verify(chatMessageBinder).bind(chatMessageDTO);
        verify(chatMessageRepository).save(chatMessage);
    }
}