package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Role;
import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.models.Useremail;
import com.lambdaschool.todos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

    @Transactional
    @Override
    public Todo updateTodo(long todoid,
                       Todo updateTodo)
    {
        Todo oldTodo = todorepos.findById(todoid).orElseThrow(() -> new EntityNotFoundException(Long.toString(todoid)));

        if (updateTodo.getDescription() != null)
        {
            oldTodo.setDescription(updateTodo.getDescription());
        }

        if (updateTodo.getDatestarted() != null)
        {
            oldTodo.setDatestarted(updateTodo.getDatestarted());
        }

        if (updateTodo.getUser() != null)
        {
            oldTodo.setUser(updateTodo.getUser());
        }

        oldTodo.setCompleted(updateTodo.isCompleted());

        return todorepos.save(oldTodo);
    }
}
