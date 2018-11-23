
package com.tact.poec.todo;

import java.util.Collections;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.tact.poec.todo")
public class ExceptionProcessor {
    private static final String NOT_FOUND_DEFAULT_MESSAGE = "Resource not ffound";

    @ExceptionHandler(MyNotFoundException.class)
    public ResponseEntity<?> notFound(final MyNotFoundException e) {
        return ResponseEntity.badRequest()
                .body(Collections.singletonMap("error",
                        Optional.ofNullable(e.getMessage()).orElse(ExceptionProcessor.NOT_FOUND_DEFAULT_MESSAGE)));
    }
}
