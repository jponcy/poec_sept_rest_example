
package com.tact.poec.todo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MyBadRequestException {
    private final Object content;

    public MyBadRequestException(final Object content) {
        super();

        this.content = content;
    }

    public Object getContent() {
        return this.content;
    }
}
