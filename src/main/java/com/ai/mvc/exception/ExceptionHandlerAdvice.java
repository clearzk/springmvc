package com.ai.mvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value= Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {

        ModelAndView modelAndView=new ModelAndView("error");//error 页面
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    public void addAttrbutes(Model model) {
        model.addAttribute("msg","额外信息");
    }

    @InitBinder
    public void intiBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }


}
