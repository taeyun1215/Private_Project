package SpringBootCore.core;

import SpringBootCore.core.discount.DiscountPolicy;
import SpringBootCore.core.discount.FixDiscountPolicy;
import SpringBootCore.core.discount.RateDiscountPolicy;
import SpringBootCore.core.member.MemberService;
import SpringBootCore.core.member.MemberServiceImpl;
import SpringBootCore.core.member.MemoryMemberRepository;
import SpringBootCore.core.order.OrderService;
import SpringBootCore.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    private MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
