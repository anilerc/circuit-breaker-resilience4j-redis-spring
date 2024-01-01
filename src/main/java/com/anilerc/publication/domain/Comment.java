package com.anilerc.publication.domain;

public class Comment {

    private String author;
    private String content;

    public Comment(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public Comment() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
