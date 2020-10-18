package org.logmein.cards.web.modules;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@ControllerAdvice
public class ValidationModule {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors()
                .stream()
                .collect(groupingBy(e ->
                                ((FieldError) e).getField(),
                        mapping(e -> e.getDefaultMessage(), toList())
                ));
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, List<String>> handleValidationExceptions(ConstraintViolationException ex) {
        return ex.getConstraintViolations()
                .stream()
                .collect(groupingBy(this::getField, mapping(ConstraintViolation::getMessage, toList())));
    }

    private String getField(ConstraintViolation<?> e) {
        String[] names = e.getPropertyPath().toString().split("\\.");
        return names[names.length - 1];
    }
}
