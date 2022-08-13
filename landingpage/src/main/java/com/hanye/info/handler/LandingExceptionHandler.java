package com.hanye.info.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages= {"com.hanye.info.controller"})
public class LandingExceptionHandler {
	
    @ExceptionHandler(value = { Exception.class })
    public String exceptionHandler(Model model,Exception e) {
    	model.addAttribute("errorMsg", e.getMessage());
        return "error";
    }
}
