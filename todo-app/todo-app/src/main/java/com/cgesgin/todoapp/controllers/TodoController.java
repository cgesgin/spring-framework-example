package com.cgesgin.todoapp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cgesgin.todoapp.entities.Todo;
import com.cgesgin.todoapp.services.TodoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("todos")
    public String getTodos(ModelMap map) {

        map.addAttribute("todos", this.todoService.findByUsername(this.getUserName()));
        return "todoList";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam int id, ModelMap map) {
        if (this.todoService.findById(id) == null) {
            map.put("errro", "Data Not Found");
            return "redirect:todos";
        }
        this.todoService.delete(id);
        return "redirect:todos";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(ModelMap map) {
        Todo todo = new Todo();
        map.put("todo", todo);
        return "createTodo";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "createTodo";
        }
        todo.setUsername(getUserName());
        this.todoService.save(todo);
        return "redirect:todos";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String update(@RequestParam int id, ModelMap map) {
        Todo todo = this.todoService.findById(id);
        map.addAttribute("todo", todo);
        return "createTodo";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "createTodo";
        }
        todo.setUsername(getUserName());
        this.todoService.update(todo);
        return "redirect:todos";
    }

   
    @RequestMapping(value = "status", method = RequestMethod.GET)
    public String changeStatus(@RequestParam int id) {
        var entity = this.todoService.findById(id);
        if (entity == null) {
            return "redirect:todos";
        }
        entity.setStatus(!entity.isStatus());
        this.todoService.update(entity);
        return "redirect:todos";
    }

    private String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}