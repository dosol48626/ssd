package com.dosol.braincare.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long num;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDateTime dueDate;
}
