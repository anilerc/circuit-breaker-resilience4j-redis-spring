package com.anilerc.publication.controller;

import com.anilerc.publication.domain.Publication;
import com.anilerc.publication.dto.request.PublicationRequestDto;
import com.anilerc.publication.mapper.PublicationMapper;
import com.anilerc.publication.service.PublicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publications")
public class PublicationController {

    private final PublicationService publicationService;
    private final PublicationMapper publicationMapper;

    public PublicationController(PublicationService publicationService, PublicationMapper publicationMapper) {
        this.publicationService = publicationService;
        this.publicationMapper = publicationMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody PublicationRequestDto request) {
        var publication = publicationMapper.toPublication(request);
        publicationService.insert(publication);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Publication> findById(@PathVariable String id) {
        return new ResponseEntity<>(publicationService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Publication>> findAll() {
        return new ResponseEntity<>(publicationService.findAll(), HttpStatus.OK);
    }

}
