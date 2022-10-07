package dev.danvega.todoservice.controller;

import dev.danvega.todoservice.exception.ErrorsHandler;
import dev.danvega.todoservice.exception.TodoNotFoundException;
import dev.danvega.todoservice.model.Todo;
import dev.danvega.todoservice.service.TodoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController extends ErrorsHandler {

    private final TodoService todoService;
    private final RestTemplate restTemplate;

    public TodoController(TodoService todoService, RestTemplate restTemplate) {
        this.todoService = todoService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("All")
    public List<Todo> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Todo findById(@PathVariable("id") int id) throws TodoNotFoundException {
        return todoService.findById(id);
    }

}
