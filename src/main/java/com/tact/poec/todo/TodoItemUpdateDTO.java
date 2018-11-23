
package com.tact.poec.todo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TodoItemUpdateDTO {
    @NotNull
    @NotBlank
    // @Pattern(regexp = "^[\\D]+$")
    private String label;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }
}
