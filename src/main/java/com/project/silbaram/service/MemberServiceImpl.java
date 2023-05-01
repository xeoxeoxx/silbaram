package com.project.silbaram.service;


import com.project.silbaram.dao.MemberDAO;
import com.project.silbaram.dto.MemberDTO;
import com.project.silbaram.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{


    private final MemberDAO memberDAO;
    private final ModelMapper modelMapper;


    @Override
    public boolean addMember(MemberDTO memberDTO) {
        log.info(modelMapper);
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.insertMember(memberVO);
        log.info(memberVO);
        return true;
    }

    @Override
    public boolean isDuplicatedUserId(String userId) {
        int count = memberDAO.countMemberByUserId(userId);
        return count > 0;
    }

    @Override
    public Integer login(String userId, String password) {
        MemberVO memberVO = memberDAO.getMemberById(userId);
        if (memberVO == null) {
            return null;
        }
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        if(memberDTO.getPassword().equals(password)) {
            return memberDTO.getMid();
        }
        return null;
    }




}