package com.nf147.todo.controller;

import com.nf147.todo.entity.Todo;
import com.nf147.todo.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoMapper todoMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> home () {
        return todoMapper.getTodos();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Todo> add (@RequestBody Todo todo) {
        return todoMapper.addTodo(todo);
    }
}
