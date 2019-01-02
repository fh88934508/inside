package com.huishou.inside.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TokenVerifyService {
    public boolean verifyToken(String token){
        if (token.equals("666")){
            return true;
        }else{
            return false;
        }
    }
}
