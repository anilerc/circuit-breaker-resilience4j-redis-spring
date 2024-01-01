package com.anilerc.publication.repository;

import com.anilerc.publication.domain.Publication;
import com.anilerc.publication.repository.entity.PublicationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends MongoRepository<PublicationEntity, Integer> {
}
