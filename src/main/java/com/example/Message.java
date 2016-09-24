package com.example;

import javax.persistence.*;

/**
 * Created by bearden-tellez on 9/24/16.
 */

@Entity
@Table(name = "chatmessages")

public class Message {

    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    User user;

    @Column(nullable = false)
    String messageText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Message (User user, String messageText) {
        this.user = user;
        this.messageText = messageText;
    }



}
