package com.dosol.braincare.service;

import com.dosol.braincare.dto.TodoDTO;
import com.dosol.braincare.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TodoDTO> getAllTodos() {
        log.info("할일가져오는중");
        return todoRepository.findAll().stream()
                .map(todo -> modelMapper.map(todo, TodoDTO.class)) // ModelMapper를 사용하여 변환
                .collect(Collectors.toList());
    }
}
