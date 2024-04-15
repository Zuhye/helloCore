package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // 설정 정보

    @Bean // 각 메소드들이 스프링컨테이너에 등록
    public MemberService memberService() { // memberService 역할
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() { // orderService 역할
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public MemoryMemberRepository memberRepository() { // memoryRepository 역할
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
