package com.udacity.jwdnd.spring_security_basics.service;

import com.udacity.jwdnd.spring_security_basics.mapper.MessageMapper;
import com.udacity.jwdnd.spring_security_basics.model.Message;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {
    private MessageMapper messageMapper;
    private List listOfMessages;


    public  MessageService (MessageMapper messageMapper){
        this.messageMapper = messageMapper;
        listOfMessages = new ArrayList<String>();
    }

    public void addMessage(Message message){
        messageMapper.insert(message);
    }

    public List<Message> getAllMessages(){
        return messageMapper.getAllMessages();
    }


}
