package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AutoAppConfigTest {

    @Test
    public void basicScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService bean = ac.getBean(MemberService.class);
        System.out.println("bean = " + bean);
        assertThat(bean).isInstanceOf(MemberService.class);


        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);

        DiscountPolicy discountPolicy = orderService.getDiscountPolicy();
        System.out.println("discountPolicy = " + discountPolicy);


    }
}