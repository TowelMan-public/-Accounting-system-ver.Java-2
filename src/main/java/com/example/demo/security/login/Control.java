package com.example.demo.security.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class Control {
	//ログイン画面の表示
    @GetMapping
    public String showDisplay() {
        return "/login";
    }

    //ログイン成功時に表示されるデフォルト画面表示
    @PostMapping
    public String showDefaultDisplay() {
        return "redirect:/home";
    }
}
