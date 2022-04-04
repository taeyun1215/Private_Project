package SpringBootCore.core;

import SpringBootCore.core.member.Grade;
import SpringBootCore.core.member.Member;
import SpringBootCore.core.member.MemberService;
import SpringBootCore.core.order.Order;
import SpringBootCore.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig= new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
