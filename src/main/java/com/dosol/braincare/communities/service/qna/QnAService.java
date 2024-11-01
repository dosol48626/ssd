package com.dosol.braincare.communities.service.qna;

import com.dosol.braincare.communities.domain.QnA;
import com.dosol.braincare.communities.dto.QnADTO;

import java.util.List;

public interface QnAService {
    Long register(QnADTO qnadto);
    QnADTO readOne(Long num);
    void modify(QnADTO qnadto);
    void remove(Long num);
    List<QnA> readAll();
}
