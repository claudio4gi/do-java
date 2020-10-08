package br.com.jccf.springmvc.jms.artemis.entity;

import java.io.Serializable;

public class Mail implements Serializable {

    private static final long serialVersionUID = 1;

    private String content;

    public Mail() {}

    public Mail(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
