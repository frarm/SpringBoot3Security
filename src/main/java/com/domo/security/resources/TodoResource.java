package com.domo.security.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TodoResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<Todo> TODOS_LIST = List.of(
            new Todo("frarm", "Learn AWS"),
            new Todo("frarm", "Learn SpringBoot3"));

    @GetMapping(value = "/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS_LIST;
    }

    @GetMapping(value = "/users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping(value = "/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo entity) {
        // TODO: process POST request
        logger.info("Creating {} for {}", entity, username);
    }

}

record Todo(String username, String description) {
}