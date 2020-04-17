package com.cy.user.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.jsonwebtoken.Claims;
import util.JwtUtil;

/**
 * @Author: cy
 * @Date: 2019/2/21 13:01
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");
        //无论如何都放行，具体能不能操作还是在具体的操作中去判断
        //拦截器只是负责把请求头中包含token的令牌进行一个解析验证
        final String authHeader = request.getHeader("Authorization");
        if(null != authHeader && !"".equals(authHeader)){
           //如果有包含有 Authorization头信息，就对其进行解析
            if(authHeader.startsWith("Bearer ")){
                //得到token
                String token = authHeader.substring(7);
                try {
                    //对令牌进行验证
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String)claims.get("roles");
                    if(null != roles && roles.equals("admin")){
                        request.setAttribute("claims_admin",token);
                    }
                    if(null != roles && roles.equals("user")){
                        request.setAttribute("claims_user",token);
                    }
                }catch (Exception e){
                    throw new RuntimeException("令牌不正确！");
                }
            }
        }
            return true;
    }
}
