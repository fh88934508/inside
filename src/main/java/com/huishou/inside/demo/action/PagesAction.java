package com.huishou.inside.demo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesAction {
    @RequestMapping("/zyhs")
    public String index(){
        return "zyhs.html";
    }
}
