package com.anilerc.publication.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PublicationRequestDto(@NotBlank String title, String coverImageUrl, @NotBlank String content) {}
