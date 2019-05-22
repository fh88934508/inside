package com.huishou.inside.demo.action;
import com.huishou.inside.demo.mapper.UserMapper;
import com.huishou.inside.demo.entity.BeanJsonReturn;
import com.huishou.inside.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by echisan on 2018/6/23
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public BeanJsonReturn registerUser(User user){

        BeanJsonReturn beanJsonReturn = new BeanJsonReturn();
        if(userMapper.findByUsername(user.getUsername())!=null){
            beanJsonReturn.setErrcode("0");
            beanJsonReturn.setErrmsg("用户名已存在，注册失败");
        }else{
            if(user.getPassword()==null||user.getName()==null||user.getRole()==null||user.getUsername()==null){
                beanJsonReturn.setErrcode("0");
                beanJsonReturn.setErrmsg("账号,密码,角色,姓名不能为空");
            }else{
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                beanJsonReturn.setErrcode("1");
                beanJsonReturn.setErrmsg("注册成功");
                userMapper.save(user);
            }

        }
        return beanJsonReturn;
    }
    @PostMapping("/setpassword")
    public BeanJsonReturn modifyPassword(@RequestBody User user){
        BeanJsonReturn beanJsonReturn = new BeanJsonReturn();
        if(user.getPassword()==null){
            beanJsonReturn.setErrcode("0");
            beanJsonReturn.setErrmsg("密码不能为空");
        }else{
            if(user==null){
                beanJsonReturn.setErrcode("0");
                beanJsonReturn.setErrmsg("用户名不能为空");
            }else{
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                userMapper.updatePassword(user);
                beanJsonReturn.setErrcode("1");
                beanJsonReturn.setErrmsg("修改成功");
            }
        }




        return beanJsonReturn;
    }
}
