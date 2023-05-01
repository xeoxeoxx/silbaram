package com.project.silbaram.dao;
import com.project.silbaram.dto.MemberDTO;
import com.project.silbaram.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDAO {
    // 회원가입
    void insertMember(MemberVO memberVO);

    // 로그인
    MemberVO getMemberById(String userId);

    // 중복아이디 체크
    int countMemberByUserId(String userId);


    // 회원 정보 수정
    void updateMember(MemberDTO memberDTO);

    // 회원 삭제
    void deleteMember(int mid);

    // 회원 한 명 정보 조회
    MemberVO selectOneMember(int mid);

    // 모든 회원 정보 조회
    List<MemberVO> selectAllMembers();

    // 회원 아이디 중복 체크
    void checkUserId(String userId);

    // 회원 닉네임 중복 체크
    public void checkNickName(String nickName);

    // 회원 아이디로 정보 조회
    public MemberVO selectOneMemberByUserId(String userId);



}