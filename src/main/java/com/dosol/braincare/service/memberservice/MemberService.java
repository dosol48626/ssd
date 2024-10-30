package com.dosol.braincare.service.memberservice;

import com.dosol.braincare.domain.Member;
import com.dosol.braincare.dto.MemberDTO;

public interface MemberService {
    void saveMember(MemberDTO memberDTO);
}
