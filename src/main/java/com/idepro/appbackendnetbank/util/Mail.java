package com.idepro.appbackendnetbank.util;

import java.util.Map;
/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 15/12/2021.
 */
public class Mail {

    private String from;
    private String to;
    private String subject;
    private Map<String, Object> model;

    public Mail() {

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
