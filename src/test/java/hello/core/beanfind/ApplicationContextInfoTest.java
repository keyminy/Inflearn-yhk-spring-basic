package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    public void findAllBean(){
        String[] beanDefinitionNames =  ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "object = " + bean);
        }
    }
    /*
    name = appConfigobject = hello.core.AppConfig$$EnhancerBySpringCGLIB$$1ce5f4e5@77d2e85
    name = memberServiceobject = hello.core.member.MemberServiceImpl@3ecd267f
    name = memberRepositoryobject = hello.core.member.MemoryMemberRepository@58ffcbd7
    name = orderServiceobject = hello.core.order.OrderServiceImpl@555cf22
    name = discountPolicyobject = hello.core.discount.RateDiscountPolicy@6bb2d00b
    */
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    public void findApplicationBean(){
        String[] beanDefinitionNames =  ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            //ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "object = " + bean);
            }

        }
    }
}
