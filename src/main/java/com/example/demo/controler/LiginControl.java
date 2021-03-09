package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.LoginForm;

@Controller
@RequestMapping("/login")
public class LiginControl {
	//ログイン画面の表示
    @GetMapping
    public String showDisplay(LoginForm form) {
        return "/login";
    }

    //ログイン成功時に表示されるデフォルト画面表示
    @PostMapping
    public String showDefaultDisplay(LoginForm form) {
        return "redirect:/home";
    }
}
