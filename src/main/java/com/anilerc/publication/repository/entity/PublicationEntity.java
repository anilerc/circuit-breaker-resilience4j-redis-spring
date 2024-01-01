package com.anilerc.publication.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "publications")
public class PublicationEntity {

    @MongoId
    private String id;
    private String title;
    private String imageUrl;
    private String content;

    public PublicationEntity(String id, String title, String imageUrl, String content) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.content = content;
    }

    public PublicationEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
