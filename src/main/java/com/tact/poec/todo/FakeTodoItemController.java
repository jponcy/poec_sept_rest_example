
package com.tact.poec.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeTodoItemController {

    @Autowired
    private FakeTodoItemRepository repository;

    @RequestMapping("todo")
    public List<TodoItem> getAll() {
        return this.repository.findAll();
    }

    @RequestMapping("todo/create")
    public TodoItem create(@RequestParam final String label) {
        final TodoItem item = new TodoItem(label);

        this.repository.save(item);

        return item;
    }

    @RequestMapping("todo/delete")
    public void delete(@RequestParam final long id) {
        final TodoItem item = this.repository.findOne(id);

        item.setDeleted(true);

        this.repository.save(item);
    }

    @RequestMapping("todo/update")
    public void update(@RequestParam final long id, @RequestParam final String label) {
        final TodoItem item = this.repository.findOne(id);

        item.setLabel(label);

        this.repository.save(item);
    }

    @RequestMapping("todo/done")
    public void done(@RequestParam final long id) {
        final TodoItem item = this.repository.findOne(id);

        item.setFinished(true);

        this.repository.save(item);
    }
}
