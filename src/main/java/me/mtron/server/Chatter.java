package me.mtron.server;

import me.mtron.client.ChatClientITF;

public class Chatter {
    public String name;
    public ChatClientITF client;

    public Chatter(String name, ChatClientITF client) {
        this.name = name;
        this.client = client;
    }

    public String getName() {
        return this.name;
    }

    public ChatClientITF getClient() {
        return this.client;
    }
}