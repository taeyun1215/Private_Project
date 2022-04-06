package SpringBootCore.core;

import SpringBootCore.core.member.Grade;
import SpringBootCore.core.member.Member;
import SpringBootCore.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appconfig = new AppConfig();
//        MemberService memberService = appconfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig에서 정의한 @Bean 설정 정보를 읽어와 memberService 객체를 생성후 초기화한다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // getBean은 AppConfig class에 memberService method를 사용하겠다는 뜻

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
