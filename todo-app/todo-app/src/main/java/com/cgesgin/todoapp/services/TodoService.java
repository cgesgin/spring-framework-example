package com.cgesgin.todoapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cgesgin.todoapp.entities.Todo;
import com.cgesgin.todoapp.repositories.TodoRepository;


@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        return this.todoRepository.findAll();
    }

    public Todo findById(int id) {
        Optional<Todo> entity = this.todoRepository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        return null;
    }

    public List<Todo> findByUsername(String username) {
        var entity = this.todoRepository.findByUsername(username);
        if (entity != null) {
            return entity;
        }
        return null;
    }

    public Todo save(Todo entity) {
        return this.todoRepository.save(entity);
    }

    public void delete(int id) {
        Optional<Todo> entity = this.todoRepository.findById(id);
        if (entity.isPresent()) {
            this.todoRepository.delete(entity.get());
        }
    }

    public void update(Todo entity){
        this.todoRepository.save(entity);
    }
}