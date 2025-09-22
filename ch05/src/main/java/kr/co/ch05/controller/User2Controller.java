package kr.co.ch05.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class User2Controller {



    public String regitster(){
        return "register";
    }

    @GetMapping("/user2/list")
    public String list(){
        return "/user2/list";
    }
}
