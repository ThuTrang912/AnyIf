package sk2a.hello.chann.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk2a.hello.chann.dao.UserDao;
import sk2a.hello.chann.domain.User;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@Slf4j //sử dụng được Log hiển thị cả thông tin của dòng code và thông tin cần hiển thị
@RequiredArgsConstructor //chỉ cần viết cái ni thì không cần viết constructor cũng được
public class UserController {

    private final UserDao userDao;

    @ResponseBody
    @RequestMapping(value="/hello2", method= RequestMethod.GET)
    public User getUserById(){
        return userDao.selectUserById(1);
    }

    @ResponseBody
    @PostMapping("/hello3")
    public String insertUser(@ModelAttribute User user) {
        userDao.insertUser(user);
        return "insert OK";
    }

    @ResponseBody
    @RequestMapping(value="/hello4", method= RequestMethod.GET)
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("user_login") String user_login, @RequestParam("password") String password, Model model, HttpSession session){
        User user = userDao.getUserByUserLogin(user_login);
        log.info("loginUser={}", user);
        if(user != null && user.getPassword().equals(password)){
            model.addAttribute("user", user);
            // Lưu thông tin user vào session
            session.setAttribute("user", user);
            return "redirect:/home/" + user.getUser_login();
        }else{
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm (Model model){
        model.addAttribute("user" , new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user){
        log.info("registerUser={}", user);
        userDao.insertUser(user);
        return "/login"; }




}
