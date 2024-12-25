package org.sergey_white.statement.exception;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.sergey_white.statement.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RefusalClientException.class)
    public ResponseEntity<ErrorResponse> handleRefusalClientException(RefusalClientException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("IllegalArgumentException: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
    }
    @ExceptionHandler(WebClientResponseException.BadRequest.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(WebClientResponseException.BadRequest ex) throws JsonProcessingException {
        String responseBody = ex.getResponseBodyAsString();
        ErrorResponse errorResponse = new ObjectMapper().readValue(responseBody, ErrorResponse.class);
        log.warn("WebClientResponseException.BadRequest: {}", errorResponse.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errorResponse.getMessage()));
    }
    @ExceptionHandler(WebClientResponseException.Conflict.class)
    public ResponseEntity<ErrorResponse> handleConflictException(WebClientResponseException.Conflict ex) throws JsonProcessingException {
        String responseBody = ex.getResponseBodyAsString();
        ErrorResponse errorResponse = new ObjectMapper().readValue(responseBody, ErrorResponse.class);
        log.warn("WebClientResponseException.Conflict: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(errorResponse.getMessage()));
    }
}
