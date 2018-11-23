
package com.tact.poec.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class FakeTodoItemRepository {

    /** Fake DB. */
    private static List<TodoItem> entities = new ArrayList<>();
    private final AtomicLong ids = new AtomicLong();

    public FakeTodoItemRepository() {
        super();

        // Add fake identifiers.
        // FakeTodoItemRepository.entities.forEach(e -> this.save(e));
        Arrays.asList(
                new TodoItem("Définir REST"),
                new TodoItem("Apprendre théorie REST"),
                new TodoItem("Faire du REST"),
                new TodoItem("Aller en pause"),
                new TodoItem("Manger un barbecue"))
                .forEach(this::save);
    }

    public List<TodoItem> findAll() {
//        return FakeTodoItemRepository.entities.stream().map(e -> e).collect(Collectors.toList());
        return FakeTodoItemRepository.entities;
    }

    public void save(final TodoItem item) {
        if (item.getId() == null) { // Insert.
            item.setId(this.ids.incrementAndGet());
            FakeTodoItemRepository.entities.add(item);
        } else { // Update.
            // Nothing to do.
        }
    }

    public TodoItem findOne(final long id) {
        return FakeTodoItemRepository.entities.get((int) id - 1);
//        return FakeTodoItemRepository.entities.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}
