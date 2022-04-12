package SpringBootCore.core;

import SpringBootCore.core.discount.DiscountPolicy;
import SpringBootCore.core.discount.FixDiscountPolicy;
import SpringBootCore.core.discount.RateDiscountPolicy;
import SpringBootCore.core.member.MemberService;
import SpringBootCore.core.member.MemberServiceImpl;
import SpringBootCore.core.member.MemoryMemberRepository;
import SpringBootCore.core.order.OrderService;
import SpringBootCore.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository

    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
