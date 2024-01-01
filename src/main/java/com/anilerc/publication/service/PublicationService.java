package com.anilerc.publication.service;

import com.anilerc.publication.client.CommentClient;
import com.anilerc.publication.domain.Publication;
import com.anilerc.publication.exception.FallbackException;
import com.anilerc.publication.mapper.PublicationMapper;
import com.anilerc.publication.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {

    private final PublicationRepository publicationRepository;
    private final PublicationMapper publicationMapper;
    private final CommentService commentService;

    public PublicationService(PublicationRepository publicationRepository, PublicationMapper publicationMapper, CommentService commentService) {
        this.publicationRepository = publicationRepository;
        this.publicationMapper = publicationMapper;
        this.commentService = commentService;
    }


    public void insert(Publication publication) {
        var publicationEntity = publicationMapper.toPublicationEntity(publication);
        publicationRepository.save(publicationEntity);
    }

    public List<Publication> findAll() {
        var publicationEntities = publicationRepository.findAll();

        return publicationEntities.stream().map(publicationMapper::toPublication).toList();
    }

    public Publication findById(String id) {

        var publication = publicationRepository.findById(Integer.valueOf(id)).map(publicationMapper::toPublication).orElseThrow(RuntimeException::new);
        var comments = commentService.getComments(id);

        publication.setComments(comments);

        return publication;

    }

}
