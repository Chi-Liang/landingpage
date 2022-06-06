package com.hanye.info.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class LoginController {
	
	@GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginError")
    public String loginError(Model model, @RequestAttribute String errorMsg) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", errorMsg);

        return "login";
    }
    
    @GetMapping("/auth/dashboard")
    public String dashboard(Model model) {
        
        return "dashboard";
    }
    
    @GetMapping("/restlogin")
    @ResponseBody
	public String restlogin() throws IOException, InterruptedException {
		
		var inputJson = "{ \"username\":\"admin\", \"password\":\"1qaz2wsx\" }";
		 
        var request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:80/login"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(inputJson))
            .build();
 
        var client = HttpClient.newHttpClient();
 
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
		return "success";
		
	}
}
