
package com.tact.poec.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

    @Query("SELECT COUNT(o) FROM TodoItem o")
    int mycount();


}
