package com.banksystem.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: LoginHandlerInterceptor <br>
 * version: 1.0 <br>
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUserId");
        if (loginUser == null) { // If there is no session, it means the user is not logged in, so intercept the request.
            request.setAttribute("message", "Not logged in. Please log in first!!!");
            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}