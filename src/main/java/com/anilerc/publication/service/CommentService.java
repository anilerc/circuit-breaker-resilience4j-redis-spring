package com.anilerc.publication.service;

import com.anilerc.publication.client.CommentClient;
import com.anilerc.publication.domain.Comment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentClient commentClient;
    private final RedisService redisService;

    public CommentService(CommentClient commentClient, RedisService redisService) {
        this.commentClient = commentClient;
        this.redisService = redisService;
    }

    @CircuitBreaker(name = "comments", fallbackMethod = "getCommentsFallback")
    public List<Comment> getComments(String id) {
        var comments = commentClient.getComments(id);
        redisService.save(comments, id);
        return commentClient.getComments(id);
    }

    private List<Comment> getCommentsFallback(String id, Throwable cause) {
        System.out.println("[WARN] Running fallback with id: " + id);
        return redisService.findById(id);
    }


}
