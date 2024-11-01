package com.dosol.braincare.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String username; //이거 username 이라고 안하면 다른곳에서 설정 또 해야함.

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, length = 200)
    private String email;

    private String role;
}
