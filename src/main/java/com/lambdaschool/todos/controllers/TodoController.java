package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.services.TodoService;
import com.lambdaschool.todos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/todos")
public class TodoController
{
    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    // PUT updates a todo based on todoid. Can be done by any user. Note: null boolean is not a thing - it
    // is false, so jsut set comlpeteed to whatever comes across in the RequestBody.
    // localhost:2019/todos/todoid/{todoid}
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping(value = "/todoid/{todoid}", consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Todo updateTodo, @PathVariable long todoid)
    {
        todoService.updateTodo(todoid, updateTodo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
