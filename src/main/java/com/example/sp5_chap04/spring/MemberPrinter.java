package com.example.sp5_chap04.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemberPrinter {
    private DateTimeFormatter dateTimeFormatter;

    public void print(Member member) {
        if(dateTimeFormatter == null) {
            System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
        }else {
            System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n", member.getId(), member.getEmail(), member.getName(),
                    dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }

    @Autowired
    public void setDateTimeFormatter(Optional<DateTimeFormatter> formatterOpt) {
        if(formatterOpt.isPresent()) {
            this.dateTimeFormatter = formatterOpt.get();
        }else {
            this.dateTimeFormatter = null;
        }
    }
}
