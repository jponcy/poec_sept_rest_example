
package com.tact.poec.todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class TodoItem {
    /** The database ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    /** Describes the task to do. */
    private String label;

    /**
     * Tells if the task is accomplished.
     * <p>
     * <b>NOTE:</b> then not {@link #deleted}
     * </p>
     */
    private boolean finished;

    /**
     * Tells if the task is deleted.
     * <p>
     * <b>NOTE:</b> then not {@link #finished accomplished}
     * </p>
     */
    private boolean deleted;

    /** The default constructor. */
    public TodoItem() {
        this(null);
    }

    public TodoItem(final String label) {
        super();

        this.setLabel(label);
    }

    /** @return the id */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /** @return the label */
    public String getLabel() {
        return this.label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(final String label) {
        this.label = label;
    }

    /** @return the finished */
    public boolean isFinished() {
        return this.finished;
    }

    /**
     * @param finished the finished to set
     */
    public void setFinished(final boolean finished) {
        this.finished = finished;
    }

    /** @return the deleted */
    public boolean isDeleted() {
        return this.deleted;
    }

    /**
     * @param deleted the deleted to set
     */
    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }
}
