package com.hanye.info.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class SysLoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        handle(request, response, exception);
    }

    protected void handle(HttpServletRequest request,
                          HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        request.setAttribute("errorMsg", "帳號或密碼錯誤");
        String targetUrl = "/loginError";

        request.getRequestDispatcher(targetUrl).forward(request, response);

    }
}
