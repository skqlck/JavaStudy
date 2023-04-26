package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FIxDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;
import hello.core.service.OrderService;
import hello.core.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // app config가 스프링 컨테이너라는 곳이 있어요 == AppConfig
    @Bean
    public MemberService memberService(){
        //1번
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }
    @Bean
    public OrderService orderService(){
        //1번
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        //2번? 3번?
        System.out.println("call AppConfig.memberRepository");
//      아래가 우리가 구현객체를 변경할 부분
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//      아래가 우리가 구현객체를 변경할 부분
//        return new FIxDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
