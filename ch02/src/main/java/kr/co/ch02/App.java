package kr.co.ch02;


import kr.co.ch02.sub1.Hello;
import kr.co.ch02.sub1.Welcome;

/**
 * Hello world!
 *
 */
public class App {

    // 기존 객체 제어 방식
    Hello hello = new Hello();
    Welcome welcome = new Welcome();

    hello.show();
    welcome.show();

    /// //////////////////////////////////////////////////////
    // IoC/DI(제어의 역전)
    /// //////////////////////////////////////////////////////
    // 스프링 컨테이너 등록
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    // 객체 가져오기
    Hello helloBean = context.getBean(Hello.class);
    helloBean.show();

    Welcome welcomeBean = (Welcome) context.getBean("wc");
    welcomeBean.show();

    Computer com = (Computer) context.getBean("computher");
    com.show();

    /// //////////////////////////////////////////////////////
    // Spring AOP
    /// //////////////////////////////////////////////////////

    Service service = (Service) context.getBean("service");

    service.findById();
    service.register();
    service.modify();
    service.remove();


}
