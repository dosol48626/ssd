package com.dosol.braincare.repository;

import com.dosol.braincare.communities.domain.QnA;
import com.dosol.braincare.communities.repository.QnARepository;
import com.dosol.braincare.domain.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class QnARepositoryTests {
    @Autowired
    private QnARepository qnARepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 5).forEach(i -> {
            QnA qnA = QnA.builder()
                    .title("title"+i)
                    .content("content"+i)
                    .build();
            QnA result = qnARepository.save(qnA);
        });
    }

    @Test
    public void testSelect(){
        Long qnaNum = 3L;

        var qnA = qnARepository.findById(qnaNum);
        log.info(qnaNum);
    }
}
