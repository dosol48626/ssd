package com.dosol.braincare.repository;

import com.dosol.braincare.domain.Member;
import com.dosol.braincare.domain.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 5).forEach(i -> {
            Member member = Member.builder()
                    .name("name" + i)
                    .password("password" + i)
                    .username("username" + i)
                    .email("email" + i)
                    .role("role" + i)
                    .build();
            Member result = memberRepository.save(member);
        });
    }

    @Test
    public void testSelect(){
        Long memberNum = 3L;

        var member = memberRepository.findById(memberNum);
        log.info(member);
    }
}
