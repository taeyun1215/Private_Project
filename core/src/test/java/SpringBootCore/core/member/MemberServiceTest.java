package SpringBootCore.core.member;

import SpringBootCore.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    // MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given, member변수 초기화
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when, join함수를 이용하여 member를 저장하고 findMember함수를 이용하여 저장한 함수를 찾음.
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then, isEqualTo함수를 이용하여 두 변수가 같은지 확인하기.
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
