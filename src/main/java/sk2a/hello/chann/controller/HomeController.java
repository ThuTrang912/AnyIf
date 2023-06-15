package sk2a.hello.chann.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sk2a.hello.chann.dao.UserDao;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private final UserDao userDao;

    public HomeController(UserDao userDao) {
        this.userDao = userDao;
    }

//    @ResponseBody
//   @RequestMapping(value = "/helloo", method = RequestMethod.GET)
//    public List<Map<String, Object>> hello() {
//        return userDao.getAllUsers();
//    }

}
