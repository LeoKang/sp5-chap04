package com.example.sp5_chap04.config;

import com.example.sp5_chap04.spring.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc() {
//        return new MemberRegisterService(memberDao());
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
//        ChangePasswordService pwdSvc = new ChangePasswordService();
//        pwdSvc.setMemberDao(memberDao());
//        return pwdSvc;
        return new ChangePasswordService();
    }

    /*
        @Bean
        public MemberPrinter memberPrinter() {
            return new MemberPrinter();
        }
    */
    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter() {
//        return new MemberListPrinter(memberDao(), memberPrinter());
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//        infoPrinter.setMemberDao(memberDao());
//        infoPrinter.setPrinter(memberPrinter());
//        return infoPrinter;
//        return new MemberInfoPrinter();
        // 128page
        infoPrinter.setPrinter(memberPrinter2());

        return infoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
