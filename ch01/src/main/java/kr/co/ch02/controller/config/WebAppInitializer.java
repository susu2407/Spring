package kr.co.ch02.controller.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(jakarta.servlet.ServletContext servletContext) throws ServletException {

        // 스프링 애플리케이션 컨텍스트 생성
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        // 스프링 애플리케이션 구성 설정
        context.register(AppConfig.class);

        // DispatcherServlet 생성
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("DispatcherServlet", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

    }
}
