package com.dosol.braincare.repository;

import com.dosol.braincare.domain.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;


    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 5).forEach(i -> {
            Todo todo = Todo.builder()
                    .title("Title" + i)
                    .description("decription" + i)
                    .completed(false)
                    .dueDate(LocalDateTime.now().plusDays(i))
                    .build();

            Todo result = todoRepository.save(todo);
            log.info("NUM" + result.getNum());
        });
    }

    @Test
    public void testSelect() {
        Long num = 3L;

        var optionalTodo = todoRepository.findById(num);
        Todo todo = todoRepository.findById(num).orElse(null);

        log.info("NUM" + num);
    }
}
