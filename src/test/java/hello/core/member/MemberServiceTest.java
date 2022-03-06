package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    public void join() {

        Member member = new Member(1L, "testMember", Grade.BASIC);

        memberService.join(member);

        Member findMember = memberService.findMember(member.getId());

        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
