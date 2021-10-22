package com.fang.legend.base.config.interceptor;

import org.apache.catalina.util.RequestUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SachsFang on 2021/5/23 9:10
 */
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("请求前执行");
        /*String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        if ("/userController/login".equals(url)) {
            return true;
        }else {
            String username =  (String)request.getSession().getAttribute("user");
            if(username == null){
                request.getRequestDispatcher("/page/index.jsp").forward(request, response);
                return false;
            }else
                return true;
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求后视图渲染前执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("视图渲染后执行");
    }
}
