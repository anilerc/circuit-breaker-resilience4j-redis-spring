package com.anilerc.publication.exception;

import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime timestamp, Integer statusCode, String message, String path){}
