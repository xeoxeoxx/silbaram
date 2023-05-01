package com.project.silbaram.service;


import com.project.silbaram.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    boolean addMember(MemberDTO memberDTO);

    Integer login(String userId, String password);

    boolean isDuplicatedUserId(String userId);


}