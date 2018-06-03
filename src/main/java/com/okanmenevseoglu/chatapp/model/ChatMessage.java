package com.okanmenevseoglu.chatapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    @Id
    private String id;

    private String chatUser;

    private String message;

    private Date messageTime;

    private MessageAction messageAction;
}