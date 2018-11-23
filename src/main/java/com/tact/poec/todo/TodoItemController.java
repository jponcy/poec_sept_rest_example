
package com.tact.poec.todo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST respect:
 * <ul>
 * <li>GET /resource => get resource list</li>
 * <li>POST /resource => create a new resource</li>
 * <li>GET /resource/PK => get the resource</li>
 * <li>PUT /resource/PK => update resource data</li>
 * <li>DELETE /resource/PK => remove the resource</li>
 * </ul>
 *
 * <p>
 * <b>NOTES:</b>
 * <ul>
 * <li>possibility to have a prefix before resource like /api/v2/resource</li>
 * <li>Others common verbs: OPTIONS (check CORS for example), HEAD (to know last
 * update date), ...</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping("todoitem")
public class TodoItemController {

    @Autowired
    private TodoItemService service;

    // @RequestMapping(name = "todo", method = RequestMethod.GET)
    @GetMapping
    public List<TodoItem> getAll() {
        final List<TodoItem> result = this.service.findAll();

        // Specific business - standard response is 200 [].
        if (result.isEmpty()) {
            throw new MyNotFoundException();
        }

        return result;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItem create(@Valid @RequestBody final TodoItemUpdateDTO dto) {
        final TodoItem item = new TodoItem(dto.getLabel());

        this.service.save(item);

        return item;
    }

    // @DeleteMapping // No, due to not real deletion, except if we want declare is
    // delete even if it is not.
    // Not RestFull, but common tips to add some action (for performance).
    @PutMapping("{id:^\\d+$}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final long id) {
        final TodoItem item = this.service.find(id);

        item.setDeleted(true);

        this.service.save(item);
    }

    /**
     * Rest defines the content for creation/update should be add as request
     * content.
     *
     * @param id
     * @param label
     */
    @PutMapping("{id:^\\d+$}")
    public void update(@RequestParam final long id, @RequestBody final TodoItemUpdateDTO dto) {
        final TodoItem item = this.service.find(id);

        item.setLabel(dto.getLabel());

        this.service.save(item);
    }

    @PutMapping("{id:^\\d+$}/done")
    public void done(@RequestParam final long id) {
        final TodoItem item = this.service.find(id);

        item.setFinished(true);

        this.service.save(item);
    }
}
