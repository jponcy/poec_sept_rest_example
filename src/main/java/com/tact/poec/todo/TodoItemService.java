
package com.tact.poec.todo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository repository;

    /**
     * Finds then returns the {@link TodoItem todo item} for given id.
     *
     * <p><b>NOTE:</b> Throw {@link MyNotFoundException} if not found.</p>
     * @param id
     * @return
     * @throws MyNotFoundException
     */
    public TodoItem find(final long id) {
        return this.repository.findById(id).orElseThrow(() -> new MyNotFoundException());
    }

    public List<TodoItem> findAll() {
        return this.repository.findAll();
    }

    @Transactional
    public void save(final TodoItem item) {
        this.repository.save(item);
    }
}
