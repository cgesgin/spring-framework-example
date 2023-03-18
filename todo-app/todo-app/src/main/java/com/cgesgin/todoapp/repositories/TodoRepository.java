package com.cgesgin.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.cgesgin.todoapp.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUsername(String username);
}
