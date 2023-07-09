package sk2a.hello.chann;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sk2a.hello.chann.controller.TestInterceptor;
import sk2a.hello.chann.interceptor.MyInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/home/*", "/board", "/board/*", "/boards","/hello2", "/*.ico", "/error", "/*/*.css", "/*/*/*.css", "/*/*.js", "/*/*/*.js",
                        "/*.png", "*/*.map.css");
    }
}
