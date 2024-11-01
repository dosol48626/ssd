package com.dosol.braincare.communities.controller;

import com.dosol.braincare.communities.domain.QnA;
import com.dosol.braincare.communities.dto.QnADTO;
import com.dosol.braincare.communities.service.qna.QnAService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/qna")
public class QnAController {
    private final QnAService qnAService;
    private final ModelMapper modelMapper;

    @GetMapping("/list")
    public void list(QnADTO qnaDTO, Model model) {
        List<QnA> qnas = qnAService.readAll();
        model.addAttribute("qnas", qnas);
    }

    @GetMapping("/register")
    public void registerPost() {
    }

    @PostMapping("/register")
    public String registerGet(QnADTO qnaDTO,
                              RedirectAttributes redirectAttributes) {
        qnAService.register(qnaDTO);
        return "redirect:/qna/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long num, Model model) {
        log.info("Reading " + num);
        QnADTO qnaDTO = qnAService.readOne(num);
        model.addAttribute("qnaDTO", qnaDTO);
    }

    @PostMapping("/modify")
    public String modify(QnADTO qnaDTO) {
        qnaDTO.setTitle(qnaDTO.getTitle());
        qnaDTO.setContent(qnaDTO.getContent());
        log.info("Modifying " + qnaDTO);
        qnAService.modify(qnaDTO);
        return "redirect:/qna/read?num=" + qnaDTO.getNum();
    }

    @GetMapping("/remove")
    public String remove(Long num){
        qnAService.remove(num);
        return "redirect:/qna/list";
    }
}