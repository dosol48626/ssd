package com.dosol.braincare.controller;

import com.dosol.braincare.dto.MemberDTO;
import com.dosol.braincare.dto.TodoDTO;
import com.dosol.braincare.service.memberservice.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public void registerMember(MemberDTO memberDTO) {
    }
}
