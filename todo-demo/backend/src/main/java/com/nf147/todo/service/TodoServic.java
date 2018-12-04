package com.nf147.todo.service;

import com.nf147.todo.entity.Todo;
import com.nf147.todo.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoServic {
    @Autowired
    private TodoMapper todoMapper;

    public List<Todo> getTodos() {
        return todoMapper.getTodos();
    }

    public int addTodo(Todo todo) {
        return todoMapper.addTodo(todo);
    }

    public void deleteTodo(Todo todo) {
        todoMapper.deleteTodo(todo);
    }

    public void makeDone(Todo todo) {
        todoMapper.makeDone(todo);
    }

    public void makeCancle(Todo todo) {
        todoMapper.makeCancle(todo);
    }
}
