package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {


    public MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(getDiscountPolicy(), getMemberRepository());
    }


}
