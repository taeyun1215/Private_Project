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

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
