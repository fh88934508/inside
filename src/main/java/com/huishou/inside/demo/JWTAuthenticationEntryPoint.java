package com.huishou.inside.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huishou.inside.demo.bean.BeanJsonReturn;
import net.sf.json.JSONObject;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by echisan on 2018/6/24
 */
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        BeanJsonReturn beanJsonReturn = new BeanJsonReturn();
        beanJsonReturn.setErrcode("2");
        beanJsonReturn.setErrmsg("请重新登陆");
        beanJsonReturn.setData(authException.getMessage());
        JSONObject json = JSONObject.fromObject(beanJsonReturn);
        String reason = json.toString();
        response.getWriter().write(new ObjectMapper().writeValueAsString(reason));
    }
}
