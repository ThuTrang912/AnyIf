package sk2a.hello.chann.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk2a.hello.chann.domain.Board;

@Controller
public class HomeController {
    @RequestMapping(value = "/home/*", method = RequestMethod.GET)
    public String home(Model model){
        String search;
        model.addAttribute("search", "");
        return("home");
    }


}
