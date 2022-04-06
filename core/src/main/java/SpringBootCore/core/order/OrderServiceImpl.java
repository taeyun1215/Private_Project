package SpringBootCore.core.order;

import SpringBootCore.core.discount.DiscountPolicy;
import SpringBootCore.core.member.Member;
import SpringBootCore.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // AppConfig class에서 discountPolicy method를 이용하여 RateDiscountPolicy를 매칭시킴.
        // DiscountPolicy interface -> AppConfig에서 메소드 확인 -> RateDiscountPolicy class ->

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
