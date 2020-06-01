package com.trung.nghia.admin;

import com.trung.nghia.constant.SystemConstant;
import com.trung.nghia.model.NewModel;
import com.trung.nghia.paging.PageRequest;
import com.trung.nghia.paging.Pageble;
import com.trung.nghia.service.ICategoryService;
import com.trung.nghia.service.INewService;
import com.trung.nghia.service.imp.CateService;
import com.trung.nghia.service.imp.NewService;
import com.trung.nghia.sort.Sorter;
import com.trung.nghia.utils.FromUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/admin-new")
public class Newcontroller extends HttpServlet {

    private INewService iNew;
    private ICategoryService iCategoryService;

    public Newcontroller() {
        iNew = new NewService();
        iCategoryService = new CateService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewModel model = FromUtils.toModel(NewModel.class, req);
        String view = "";
        if (model.getType().equals(SystemConstant.LIST)) {

            Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
                    new Sorter(model.getSortName(), model.getSortBy()));
            model.setListResult(iNew.findAll(pageble));
            model.setTotalItem(iNew.getTotalItem());
            model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
            view = "/view/admin/new/list.jsp";
        } else if (model.getType().equals(SystemConstant.EDIT)) {

            if (model.getId()!=  null) {
                model = iNew.findOne(model.getId());
            }
            req.setAttribute("categories", iCategoryService.findAll());
            view = "/view/admin/new/edit.jsp";
        }
        if(req.getParameter("message") != null)
        {
            String messageResponse = "" ;
            String alert = "" ;
            String message = req.getParameter("message");

            if(message.equals("insert_success"))
            {
                messageResponse = "insert success";
                alert = "success" ;
            }else if(message.equals("update_success")){
                messageResponse = "update success" ;
                alert = "success" ;
            }else if(message.equals("delete_success")){
                messageResponse = "delete success" ;
                alert = "success" ;
            }else if(message.equals("orror_system")){
                messageResponse = "orror system" ;
                alert = "danger" ;
            }
            req.setAttribute("messageResponse" , messageResponse);
            req.setAttribute("alert",alert);
        }

        req.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

}
