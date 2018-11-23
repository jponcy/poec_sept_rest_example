
package com.tact.poec.todo;

/**
 * @see ExceptionProcessor
 */
// @ResponseStatus(HttpStatus.NOT_FOUND)
public class MyNotFoundException extends RuntimeException {
    /** The serial number. */
    private static final long serialVersionUID = 6993240930361727900L;

    public MyNotFoundException() {
        super("Resource not found");
    }
}
