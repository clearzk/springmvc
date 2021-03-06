package com.ai.mvc.controller;

import com.ai.mvc.pojo.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/anno")
public class DemoAnnoController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody  String index(HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access";
    }


//    参数绑定

    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String demoPathBVar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access,str: " + str;
    }

    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String passRequestParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access,id: " + id;
    }

    @RequestMapping(value = "/obj",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passObj(DemoObj obj, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access,obj id:" + obj.getId() + " obj name:" + obj.getName();
    }

    //方法映射
    @RequestMapping(value = {"/dm1","/dm2"},produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String dynamicMapping(HttpServletRequest request) {
        return "url: " + request.getRequestURI() + " can access";
    }

}
