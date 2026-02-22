package com.example.demo.controller;


import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
@CrossOrigin
public class ChatController {

    private final MessageRepository messageRepository;

    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        // Optional extra safety
        if (message.getSenderId() == null || message.getReceiverId() == null) {
            throw new RuntimeException("senderId/receiverId must be numeric (ex: 1,2)");
        }
        if (message.getMessage() == null || message.getMessage().trim().isEmpty()) {
            throw new RuntimeException("message cannot be empty");
        }
        return messageRepository.save(message);
    }

    // ✅ Fix 3: accept String and parse manually (so you can show your own error)
    @GetMapping("/conversation")
    public List<Message> getConversation(@RequestParam String sender, @RequestParam String receiver) {
        Long s, r;
        try {
            s = Long.parseLong(sender);
            r = Long.parseLong(receiver);
        } catch (NumberFormatException e) {
            throw new RuntimeException("sender/receiver must be numeric (ex: 1,2)");
        }

        return messageRepository
                .findBySenderIdAndReceiverIdOrReceiverIdAndSenderIdOrderByTimestampAsc(
                        s, r, r, s
                );
    }
}