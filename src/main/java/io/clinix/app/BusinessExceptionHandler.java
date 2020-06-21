package io.clinix.app;

import io.clinix.app.service.ConflictingAppointmetnException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class BusinessExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConflictingAppointmetnException.class)
    protected ResponseEntity<Object> handleBusinessException(
            ConflictingAppointmetnException ex) {
        BusinessExceptionData exception = BusinessExceptionData.builder()
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(exception);
    }

    @ExceptionHandler(TransactionSystemException.class)
    protected ResponseEntity<Object> handleBusinessException(
            TransactionSystemException ex) {
        if(ex.getCause().getCause() instanceof  ConstraintViolationException) {
            StringBuilder builder = new StringBuilder();
            ((ConstraintViolationException) ex.getCause().getCause()).getConstraintViolations().forEach((error) -> {
                builder.append(error.getMessage()).append("\n");
            });
            BusinessExceptionData exception = BusinessExceptionData.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .timestamp(LocalDateTime.now())
                    .message(builder.toString())
                    .build();
            return buildResponseEntity(exception);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder builder = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            builder.append(fieldName).append(": ").append(errorMessage).append("\n");
        });
        BusinessExceptionData exception = BusinessExceptionData.builder()
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now())
                .message(builder.toString())
                .build();
        return buildResponseEntity(exception);
    }

    private ResponseEntity<Object> buildResponseEntity(BusinessExceptionData error) {
        return new ResponseEntity<>(error, error.getStatus());
    }
}