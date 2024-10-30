package com.dosol.braincare.controller;

import com.dosol.braincare.dto.TodoDTO;
import com.dosol.braincare.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/list")
    public void getAllTodos(Model model) {
        List<TodoDTO> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
    }

}
