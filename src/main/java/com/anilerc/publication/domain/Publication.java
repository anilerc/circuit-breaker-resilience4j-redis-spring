package com.anilerc.publication.domain;

import java.util.List;

public class Publication {

    private String title;
    private String coverImageUrl;
    private String content;
    private List<Comment> comments;

    public Publication(String title, String coverImageUrl, String content, List<Comment> comments) {
        this.title = title;
        this.coverImageUrl = coverImageUrl;
        this.content = content;
        this.comments = comments;
    }

    public Publication() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
