package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Service
public class SecurityRepository {

    @Autowired
    static PasswordEncoder passwordEncoder;

    //原文をパスワードエンコーダーを使って暗号化する
    static public String encryption(String originalStr) {
        return passwordEncoder.encode(originalStr);
    }
}
