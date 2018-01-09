package me.ellios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://ellios.me");
        return "index";
    }

    @RequestMapping(value="/hi", method= RequestMethod.GET)
    public String postUser(@RequestParam(value = "type") Integer type) {
        if(type == 1){
            return "get type : " + type;
        }
        if (type == 2){
            throw new IllegalStateException();
        }
        return "type : " + type;
    }

}