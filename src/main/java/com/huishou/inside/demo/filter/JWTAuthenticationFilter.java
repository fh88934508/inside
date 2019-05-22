package com.huishou.inside.demo.filter;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.huishou.inside.demo.Mapper.UserMapper;
import com.huishou.inside.demo.bean.BeanJsonReturn;
import com.huishou.inside.demo.entity.User;
import com.huishou.inside.demo.utils.JwtTokenUtils;
import com.security.demo.entity.JwtUser;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by echisan on 2018/6/23
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Autowired
    UserMapper userMapper;

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        // 从输入流中获取到登录的信息

        String username = request.getParameter("username");
        String password = request.getParameter("password");




        return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>())
            );

    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    //登录成功返回数据
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();
        System.out.println("jwtUser:" + jwtUser.toString());
        boolean isRemember =true;
        String role = "";
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
        for (GrantedAuthority authority : authorities){
            role = authority.getAuthority();
        }

        User byUsername = userMapper.findByUsername(jwtUser.getUsername());
        String token = JwtTokenUtils.createToken(jwtUser.getUsername(), role, isRemember,byUsername.getName());
//        String token = JwtTokenUtils.createToken(jwtUser.getUsername(), false);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
        response.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + token);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        BeanJsonReturn beanJsonReturn = new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setErrmsg("登录成功");
        jwtUser.setToken(JwtTokenUtils.TOKEN_PREFIX + token);
        jwtUser.setName(byUsername.getName());
        jwtUser.setPassword(null);
        beanJsonReturn.setData(jwtUser);
        JSONObject json = JSONObject.fromObject(beanJsonReturn);
        String reason = json.toString();
        response.getWriter().write(new ObjectMapper().writeValueAsString(reason));

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        BeanJsonReturn beanJsonReturn = new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");
        beanJsonReturn.setErrmsg("登录失败");
        beanJsonReturn.setData("authentication failed, reason: " + failed.getMessage());
        JSONObject json = JSONObject.fromObject(beanJsonReturn);
        response.getWriter().write(json.toString());

    }
}
