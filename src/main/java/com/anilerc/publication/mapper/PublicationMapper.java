package com.anilerc.publication.mapper;

import com.anilerc.publication.domain.Publication;
import com.anilerc.publication.dto.request.PublicationRequestDto;
import com.anilerc.publication.repository.entity.PublicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicationMapper {

    PublicationEntity toPublicationEntity(Publication publication);

    Publication toPublication(PublicationEntity publicationEntity);

    Publication toPublication(PublicationRequestDto request);
}
