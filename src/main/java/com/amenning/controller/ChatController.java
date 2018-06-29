package com.amenning.controller;

import com.amenning.model.ChatMessage;
import com.amenning.model.DiceSet;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private DiceSet diceSet;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        diceSet = new DiceSet(6, 6);
        //chatMessage.setContent(chatMessage.getContent() + diceSet.toString());
        chatMessage.setDiceSet(diceSet);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
        @Payload ChatMessage chatMessage,
        SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
