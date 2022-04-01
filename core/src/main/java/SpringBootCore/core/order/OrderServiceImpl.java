package SpringBootCore.core.order;

import SpringBootCore.core.discount.DiscountPolicy;
import SpringBootCore.core.discount.FixDiscountPolicy;
import SpringBootCore.core.member.Member;
import SpringBootCore.core.member.MemberRepository;
import SpringBootCore.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
