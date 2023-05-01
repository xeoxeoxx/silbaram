package com.project.silbaram.controller;

import com.project.silbaram.dto.MemberDTO;
import com.project.silbaram.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/project_ex")
public class MemberController {
    private final MemberServiceImpl memberService;

    @GetMapping("/sign_up")
    public void addMemberGET() {
        log.info("addMemberGET...");
    }
    @PostMapping("/sign_up")
    public String addMemberPOST(@Valid MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("addMemberPOST...");
        if (bindingResult.hasErrors()) {
            log.info("has error...");
            log.info(bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/project_ex/sign_up";
        }
        log.info(memberDTO);
        memberService.addMember(memberDTO);
        return "redirect:/project_ex/index";
    }

    @GetMapping("/login")
    public String login() {
        return "/project_ex/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String password, HttpSession session,
                        Model model) {
        Integer mid = memberService.login(userId, password);
        if(mid == null) {
            model.addAttribute("msg","아이디와 비밀번호를 확인해주세요");
            return "/project_ex/login";
        }
        session.setAttribute("mid", mid);
        return "redirect:/project_ex/hello";
    }

}