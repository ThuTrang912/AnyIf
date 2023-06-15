package sk2a.hello.chann.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController{
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/hello")
    public String hello(String yourname, Model model){
        model.addAttribute("yourname",yourname);
        return "hello";
    }
}


