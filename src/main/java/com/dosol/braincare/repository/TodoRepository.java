package com.dosol.braincare.repository;

import com.dosol.braincare.domain.Todo;
import com.dosol.braincare.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByCompleted(Boolean completed);
}
