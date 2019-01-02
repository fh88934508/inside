package com.huishou.inside.demo.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAction {
    @GetMapping ("/123")
    public String adduser(){
        String asd = "asd";
        return asd;
    }
}
