package com.hdjd.grit.config.interceptor;

import com.hdjd.grit.controller.LoginController;
import com.hdjd.grit.core.ProjectConfig;
import com.hdjd.grit.model.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yuan
 * @Date: 2020/3/4 18:29
 * @Version 1.0
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("sessionid是" + request.getSession().getId());
//        System.out.println("logincontroller" + LoginController.SESSIONID);
//        String cookie = "init";
//        if (request.getHeader("cookie") != null){
//            cookie = request.getHeader("cookie").substring(10);
//            System.out.println("cookie是" + request.getHeader("cookie").substring(10));
//        }
//        System.out.println("结果是 " + !cookie.equals(LoginController.SESSIONID));
//        if (request.getSession().getAttribute("admin") == null && !cookie.equals(LoginController.SESSIONID)){
        if (request.getSession().getAttribute("admin") == null ){
            response.setCharacterEncoding("utf-8");
            response.getWriter().print("请先登录");
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
