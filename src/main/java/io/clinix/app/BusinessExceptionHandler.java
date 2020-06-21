package io.clinix.app;

import io.clinix.app.service.ConflictingAppointmetnException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class BusinessExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConflictingAppointmetnException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            ConflictingAppointmetnException ex) {
        BusinessExceptionData execption = BusinessExceptionData.builder()
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(execption);
    }

    private ResponseEntity<Object> buildResponseEntity(BusinessExceptionData error) {
        return new ResponseEntity<>(error, error.getStatus());
    }
}