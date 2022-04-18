package SpringBootCore.core.discount;

import SpringBootCore.core.annotation.MainDiscountPolicy;
import SpringBootCore.core.member.Grade;
import SpringBootCore.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return price;
        }
    }
}
