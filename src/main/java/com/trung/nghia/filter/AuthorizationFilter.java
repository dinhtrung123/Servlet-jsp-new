package com.trung.nghia.filter;

import com.trung.nghia.constant.SystemConstant;
import com.trung.nghia.model.UserModel;
import com.trung.nghia.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private  ServletContext context ;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url =  request.getRequestURI();
        if(url.startsWith("/new_jdbc_war/admin"))
        {
            UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
            if(userModel != null)
            {
                if(userModel.getRole().getCode().equals(SystemConstant.ADMIN))
                {
                    chain.doFilter(servletRequest,servletResponse);
                }else if(userModel.getRole().getCode().equals(SystemConstant.USER)){
                    response.sendRedirect("/new_jdbc_war/dang-nhap?action=login&messages=not_permission&alert=danger");
            }
            }else {
                response.sendRedirect("/new_jdbc_war/dang-nhap?action=login&messages=not_login&alert=danger");
            }

        }else
        {
            chain.doFilter(servletRequest,servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
