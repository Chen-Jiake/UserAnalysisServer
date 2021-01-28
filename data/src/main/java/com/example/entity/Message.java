package com.example.entity;

public class Message {
    private String content;
    private Long time;
    private String app;

    public Message(){

    }

    public Message(String content, Long time, String app) {
        this.content = content;
        this.time = time;
        this.app = app;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getApp(){
        return app;
    }

    public void setApp(String app){
        this.app = app;
    }
}
