package com.huishou.inside.demo.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huishou.inside.demo.entity.BeanJsonReturn;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理没有权限的类
 * @author zhoukebo
 * @date 2018/9/5
 */
@Component
public class RestAuthAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        BeanJsonReturn beanJsonReturn = new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");
        beanJsonReturn.setErrmsg("您没有权限访问该资源");
        beanJsonReturn.setData(e.getMessage());
        JSONObject json = JSONObject.fromObject(beanJsonReturn);

        response.getWriter().write(json.toString());
    }
}
