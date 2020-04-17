package com.cy.web.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @Author: cy
 * @Date: 2019/2/21 17:48
 */
@Component
public class WebFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";// 前置过滤器
    }
    @Override
    public int filterOrder() {
        return 0;// 优先级为0，数字越大，优先级越低
    }
    @Override
    public boolean shouldFilter() {
        return true;// 是否执行该过滤器，此处为true，说明需要过滤
    }
    @Override
    public Object run() throws ZuulException {
        System.out.println("zuul过滤器...");//向header中添加鉴权令牌
        //得到request上下文
        RequestContext requestContext = RequestContext.getCurrentContext();//获取header
        //得到request域
        HttpServletRequest request = requestContext.getRequest();
        //得到头信息
        String header = request.getHeader("Authorization");
        //判断是否有头信息
        if(header!=null){
            //把头信息继续向下传
            requestContext.addZuulRequestHeader("Authorization",header);
        }
        return null;
    }
}
