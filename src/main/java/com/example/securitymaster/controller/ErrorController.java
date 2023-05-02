package com.example.securitymaster.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Throwable.class)
    public String exception(Throwable t,HttpServletResponse response, Model model){
//        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
        String msg = t !=null ? t.getMessage() : "Unknown Error";
        model.addAttribute("msg",msg);
        model.addAttribute("statusCode",response.getStatus());  
//        model.addAttribute("errorMsg",getMessage());
//        model.addAttribute("causeMsg",getCause().getMessage());
        return "error";
    }
}
