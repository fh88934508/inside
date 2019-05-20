package com.huishou.inside.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @GetMapping("/test")
    @PreAuthorize("hasAnyRole('ROLE_SUPPERADMIN','ROLE_POWER')")
    public String hello1(){
        return "hello";
    }
}
