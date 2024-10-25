package com.pmh.org.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
@CrossOrigin
public class TodoController {

    private final TodoRepository todoRepository;

    @PostMapping("save")
    public TodoEntity saveTodo(@RequestBody TodoEntity todo) {
        System.out.println(todo);
        return todoRepository.save(todo);
    }

}
