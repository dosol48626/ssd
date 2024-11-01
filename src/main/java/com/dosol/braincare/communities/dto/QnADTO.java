package com.dosol.braincare.communities.dto;

import com.dosol.braincare.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QnADTO {

    private Long num;

    private String title;

    private String content;

}
