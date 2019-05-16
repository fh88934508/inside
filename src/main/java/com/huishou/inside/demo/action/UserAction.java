package com.huishou.inside.demo.action;

import com.huishou.inside.demo.Mapper.UserMapper;
import com.huishou.inside.demo.bean.BeanJsonReturn;
import com.huishou.inside.demo.bean.BeanUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAction {
    @Autowired
    UserMapper userMapper;
    @GetMapping ("/123")
    public String adduser(){
        String asd = "asd";
        return asd;
    }
    @GetMapping("/api/admin/login")
    public BeanJsonReturn login(@RequestHeader String username,@RequestHeader String password){
        BeanJsonReturn beanJsonReturn = new BeanJsonReturn();
        BeanUser user = userMapper.getUser(username);
        if(user==null){
            beanJsonReturn.setErrcode("0");
            beanJsonReturn.setErrmsg("账号不存在");
        }else{
            if (user.getPassword().equals(password)){
                beanJsonReturn.setErrcode("1");
                beanJsonReturn.setErrmsg("登录成功");
                user.setPassword("");
                beanJsonReturn.setData(user);
            }else{
                beanJsonReturn.setErrcode("2");
                beanJsonReturn.setErrmsg("密码错误");
            }
        }
        return beanJsonReturn;
    }
}
