package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();//고정 할인 정책

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //1.우선 멤버를 조회
        Member member = memberRepository.findById(memberId);
        //2.회원 등급에 따른 할인 여부를 적용
        /* 할인 여부를 discountPolicy에게 위임하고 결과만 달라고함 => DIP를 잘 지킨 코드다 */
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
