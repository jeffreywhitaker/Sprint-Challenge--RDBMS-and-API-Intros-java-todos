package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Role;
import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.User;

import java.util.List;

public interface TodoService
{
    Todo save(Todo todo);

    void deleteByUser(User user);
}
