package com.udacity.jwdnd.spring_security_basics.model;

public class Message {
    private Integer messageid;
    private String username;
    private String messagetext;

    public  Message(){}
    public Message(Integer messageid, String username, String messagetext) {
        this.messageid = messageid;
        this.username = username;
        this.messagetext = messagetext;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getUsername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }
}
