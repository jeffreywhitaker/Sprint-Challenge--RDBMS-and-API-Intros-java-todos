package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Role;
import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService
{

    @Autowired
    private TodoRepository todorepos;

    @Override
    public Todo save(Todo todo)
    {
     return todorepos.save(todo);
    }

    @Override
    public void deleteByUser(User user)
    {
        todorepos.deleteByUser(user);
    }
}
