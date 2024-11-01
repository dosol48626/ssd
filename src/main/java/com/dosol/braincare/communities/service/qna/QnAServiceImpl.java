package com.dosol.braincare.communities.service.qna;

import com.dosol.braincare.communities.domain.QnA;
import com.dosol.braincare.communities.dto.QnADTO;
import com.dosol.braincare.communities.repository.QnARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class QnAServiceImpl implements QnAService {
    private final QnARepository qnARepository;
    private final ModelMapper modelMapper;

    @Override
    public Long register(QnADTO qnaDTO) {
        QnA qnA = modelMapper.map(qnaDTO, QnA.class);
        Long num = qnARepository.save(qnA).getNum();
        return num;
    }

    @Override
    public QnADTO readOne(Long num) {
        Optional<QnA> result = qnARepository.findById(num);
        QnA qnA = result.orElseThrow();
        qnA.updateVisitCount();
        QnADTO qnadto = modelMapper.map(qnA, QnADTO.class);
        return qnadto;
    }

    @Override
    public void modify(QnADTO qnADTO) {
        Optional<QnA> result = qnARepository.findById(qnADTO.getNum());

        QnA qnA = result.orElseThrow();
        qnA.change(qnADTO.getTitle(), qnA.getContent());
        qnARepository.save(qnA);
    }

    @Override
    public void remove(Long num) {
        qnARepository.deleteById(num);
    }

    @Override
    public List<QnA> readAll() {
        List<QnA> result = qnARepository.findAll();
        return result;
    }
}
