package com.lambdaschool.todos.repositories;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long>
{
//    User findByUsername(String username);
//
//    List<User> findByUsernameContainingIgnoreCase(String name);

    void deleteByUser(User user);
}
