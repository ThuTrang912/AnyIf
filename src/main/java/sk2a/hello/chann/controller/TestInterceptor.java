package sk2a.hello.chann.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestInterceptor {
    @GetMapping("/testInterception")
    public String testInterception(){
        return "interceptionOK";
    }
}
