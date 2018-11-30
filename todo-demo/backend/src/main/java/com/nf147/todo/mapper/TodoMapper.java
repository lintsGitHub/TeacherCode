package com.nf147.todo.mapper;

import com.nf147.todo.entity.Todo;

import java.util.List;

public interface TodoMapper {
    List<Todo> getTodos();
    List<Todo> addTodo(Todo todo);
    void deleteTodo(Todo todo);
    void makeDone(Todo todo);
    void makeCancle(Todo todo);
}
