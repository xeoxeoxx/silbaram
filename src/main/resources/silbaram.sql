CREATE TABLE `member` (
                          `mid` INT NOT NULL AUTO_INCREMENT,   -- 회원 고유번호
                          `userId` VARCHAR(15) NOT NULL UNIQUE,   -- 회원 아이디 (중복 불가)
                          `password` VARCHAR(20) NOT NULL,   -- 비밀번호
                          `nickName` VARCHAR(15) NOT NULL UNIQUE,   -- 회원 닉네임 (중복 불가)
                          `name` VARCHAR(20) NOT NULL,   -- 이름
                          `birthDate` DATE NOT NULL,   -- 생년월일
                          `gender` VARCHAR(2) NOT NULL,   -- 성별
                          `phoneNumber` VARCHAR(11) NOT NULL,   -- 전화번호
                          `email` VARCHAR(30) NOT NULL UNIQUE,   -- 이메일 (중복 불가)
                          `zipcode` VARCHAR(5) NULL,   -- 우편번호
                          `address` VARCHAR(100) NULL,   -- 주소
                          `socialLogin` BOOLEAN NULL DEFAULT FALSE,   -- 소셜로그인 여부
                          `isAdmin` BOOLEAN NOT NULL DEFAULT FALSE,   -- 관리자 여부
                          `regDate` DATETIME NULL DEFAULT NOW(),   -- 가입일자
                          `uuid` varchar(50) DEFAULT NULL, -- 쿠키(자동로그인)
                          PRIMARY KEY (`mid`)
);
