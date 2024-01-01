package com.anilerc.publication.service;

import com.anilerc.publication.domain.Comment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {

    private static final String KEY = "Comment";

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(List<Comment> comments, String id) {
        redisTemplate.opsForHash().put(KEY, id, comments);
    }

    public List<Comment> findById(String id) {
        return (List<Comment>) redisTemplate.opsForHash().get(KEY, id);
    }
}
