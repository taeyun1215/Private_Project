package SpringBootCore.core;

import SpringBootCore.core.discount.FixDiscountPolicy;
import SpringBootCore.core.member.MemberService;
import SpringBootCore.core.member.MemberServiceImpl;
import SpringBootCore.core.member.MemoryMemberRepository;
import SpringBootCore.core.order.OrderService;
import SpringBootCore.core.order.OrderServiceImpl;

public class Appconfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
