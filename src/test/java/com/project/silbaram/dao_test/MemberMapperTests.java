package com.project.silbaram.dao_test;

import com.project.silbaram.dao.MemberDAO;
import com.project.silbaram.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class MemberMapperTests {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void insertMemberTest() {
        MemberVO memberVO = MemberVO.builder()
                .userId("아이디")
                .password("password123")
                .nickName("닉")
                .name("John Doe")
                .birthDate(LocalDate.of(2000,01,01))
                .gender("여")
                .phoneNumber("01012345678")
                .email("a@example.com")
//                .zipcode("12345")
//                .address("123 Main St, Anytown USA")
//                .socialLogin(false)
//                .isAdmin(false)
                .build();
        memberDAO.insertMember(memberVO);
    }

    @Test
    public void getMemberByIdTest() {
        MemberVO memberVO = memberDAO.getMemberById("aaaa");
        log.info(memberVO);
    }

    @Test
    public void countMemberByUserIdTest() {
        int count = memberDAO.countMemberByUserId("aaaa");
        log.info("count: " +count);
    }


}
