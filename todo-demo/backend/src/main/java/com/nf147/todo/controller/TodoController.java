package com.nf147.todo.controller;

import com.nf147.todo.entity.Todo;
import com.nf147.todo.mapper.TodoMapper;
import com.nf147.todo.service.TodoServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoServic todoServic;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> home () {
        return todoServic.getTodos();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Todo> add (@RequestBody Todo todo) {
        return todoServic.addTodo(todo);
    }

//    修改状态的方法
    @RequestMapping(method = RequestMethod.PUT)
    public List<Todo> put (@RequestBody Todo todo){
        if ("done".equals(todo.getState())){
            todoServic.makeCancle(todo);
            return this.home();
        }else if("cancle".equals(todo.getState())){
            todoServic.makeDone(todo);
            return this.home();
        }
        return this.home();
    }
//    删除的方法
    @RequestMapping(method = RequestMethod.DELETE)
    public List<Todo> delete(@RequestBody Todo todo){
        todoServic.deleteTodo(todo);
        return this.home();
    }
}

