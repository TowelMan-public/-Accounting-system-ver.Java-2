package com.example.demo;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(classes = AccoutingSytemVer2Application.class)
class AccoutingSytemVer2ApplicationTests {

	//モック
    @Autowired
    private MockMvc mockMvc;

    void loginMaster() throws Exception {
    	//Master
        this.mockMvc.perform(formLogin("/login")
                .user("1")
                .password("test")).andDo(print())
	        .andExpect(status().is3xxRedirection())
	        .andExpect(redirectedUrl("/home"));
    }
    
    void loginUser() throws Exception {
    	//Master
        this.mockMvc.perform(formLogin("/login")
                .user("2")
                .password("test")).andDo(print())
	        .andExpect(status().is3xxRedirection())
	        .andExpect(redirectedUrl("/home"));
    }
    
    @Test
    void ログイン出来る() throws Exception {
    	//Master
        this.mockMvc.perform(formLogin("/login")
                .user("1")
                .password("test")).andDo(print())
	        .andExpect(status().is3xxRedirection())
	        .andExpect(redirectedUrl("/home"));
    	loginUser();
    	//User
        this.mockMvc.perform(formLogin("/login")
                .user("2")
                .password("test")).andDo(print())
	        .andExpect(status().is3xxRedirection())
	        .andExpect(redirectedUrl("/home"));
    }
    
    @Test
    void ログインできない() throws Exception {
    	//Master
        this.mockMvc.perform(formLogin("/login")
                .user("1")
                .password("o")).andDo(print())
	        .andExpect(status().is3xxRedirection())
	        .andExpect(redirectedUrl("/login?error"));
    }
    
    @WithUserDetails(value="1", userDetailsServiceBeanName="com.example.demo.security.login.SecurityService")
    @Test
    void ログインしてアクセスできる1() throws Exception {
    	//home
    	this.mockMvc.perform(get("/home")).andDo(print())
    	.andExpect(status().isOk());
    	//insert
    	this.mockMvc.perform(get("/insert")).andDo(print())
    	.andExpect(status().isOk());
    	//select
    	this.mockMvc.perform(get("/select")).andDo(print())
    	.andExpect(status().isOk());
    }
    
    @WithUserDetails(value="2", userDetailsServiceBeanName="com.example.demo.security.login.SecurityService")
    @Test
    void ログインしてアクセスできる2() throws Exception {
    	//home
    	this.mockMvc.perform(get("/home")).andDo(print())
    	.andExpect(status().isOk());
    	//insert
    	this.mockMvc.perform(get("/insert")).andDo(print())
    	.andExpect(status().isOk());
    	//select
    	this.mockMvc.perform(get("/select")).andDo(print())
    	.andExpect(status().isOk());
    }
    
    @WithUserDetails(value="1", userDetailsServiceBeanName="com.example.demo.security.login.SecurityService")
    @Test
    void Master権限の効果がある() throws Exception {
    	//confingration
    	this.mockMvc.perform(get("/confinguration")).andDo(print())
    		.andExpect(status().isOk());
    }
    
    @WithUserDetails(value="2", userDetailsServiceBeanName="com.example.demo.security.login.SecurityService")
    @Test
    void User権限わきまえがある() throws Exception {
    	//confingration
    	this.mockMvc.perform(get("/confinguration")).andDo(print())
	    	.andExpect(status().isForbidden());
    }
    
    @Test
    void ログインなしでアクセス可能がOK() throws Exception {
        //login
        this.mockMvc.perform(get("/login")).andDo(print())
            .andExpect(status().isOk());
        //makeNewCompanyAccount
        this.mockMvc.perform(get("/makeNewCompanyAccount")).andDo(print())
        	.andExpect(status().isOk());
    }

    @Test
    void ログインなしでloginに飛ばされる() throws Exception {
        //insert
        this.mockMvc.perform(get("/insert")).andDo(print())
        	.andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("http://localhost/login"));
        //home
        this.mockMvc.perform(get("/home")).andDo(print())
	        .andExpect(status().is3xxRedirection())
	        .andExpect(redirectedUrl("http://localhost/login"));
    }
    
    
}
