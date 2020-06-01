package com.trung.nghia.web;

import com.trung.nghia.model.UserModel;
import com.trung.nghia.service.IUserService;
import com.trung.nghia.service.imp.UserSevice;
import com.trung.nghia.utils.FromUtils;
import com.trung.nghia.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap","/thoat" })
public class HelloController extends HttpServlet {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");


	private IUserService iUserService;

	public HelloController() {
		iUserService = new UserSevice();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
           String messages = req.getParameter("messages");
           String alert = req.getParameter("alert");
           if(messages != null && alert !=null)
           {
               req.setAttribute("messages",resourceBundle.getString(messages));
               req.setAttribute("alert",alert);
           }
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValu(req,"USERMODEL");
			resp.sendRedirect(req.getContextPath() + "/trang-chu");
		} else {
			req.getRequestDispatcher("/view/web/home.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel userModel = FromUtils.toModel(UserModel.class, req);
            userModel = iUserService.findByUserNameAndPasswordAndStatus(userModel.getUserName(),userModel.getPassword(), 1);
            if(userModel !=null)
            {
				SessionUtil.getInstance().putValue(req,"USERMODEL",userModel);

            	if(userModel.getRole().getCode().equals("ADMIN"))
            	{
            		resp.sendRedirect(req.getContextPath() + "/admin-home");
            	}else if(userModel.getRole().getCode().equals("USER"))
            	{
            		resp.sendRedirect(req.getContextPath() + "/trang-chu");
            	}
            }else
            {
            	resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&messages=user_password_invalid&alert=danger");
            }

		}

	}

}
