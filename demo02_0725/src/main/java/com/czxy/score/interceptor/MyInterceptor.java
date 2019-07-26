package com.czxy.score.interceptor;

import com.czxy.score.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        //1.放行无关资源
        if (url.startsWith("/index") ||url.contains("/login") || url.startsWith("/css") || url.startsWith("/images") || url.startsWith("/js") || url.startsWith("/fonts")) {
            return true;
        }
        //2.判断是否登录
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            //已登录 -->放行
            return true;
        } else {
            //4.未登录
            // 拦截页面 强行返回到登录页面
            response.sendRedirect("/index.html");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
