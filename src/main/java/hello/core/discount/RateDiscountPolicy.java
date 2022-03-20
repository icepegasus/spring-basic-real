package hello.core.discount;

import hello.core.annotataion.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
//@Primary
public class RateDiscountPolicy implements DiscountPolicy {

    private double disCountRate = 10;

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return (int) (price * (disCountRate / 100));
        } else {
            return 0;
        }
    }
}
