package com.trung.nghia.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trung.nghia.model.NewModel;
import com.trung.nghia.model.UserModel;
import com.trung.nghia.service.INewService;
import com.trung.nghia.service.imp.NewService;
import com.trung.nghia.utils.HttpUtils;
import com.trung.nghia.utils.SessionUtil;

@WebServlet(urlPatterns = "/api-admin-new")
public class NewApi extends HttpServlet {

	private INewService iNewService;

	public NewApi() {
		iNewService = new NewService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		NewModel newModel = HttpUtils.of(req.getReader()).toModel(NewModel.class);
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
		newModel.setCreatedBy(userModel.getUserName());
		newModel = iNewService.save(newModel);
		mapper.writeValue(resp.getOutputStream(), newModel);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		NewModel updateNew = HttpUtils.of(req.getReader()).toModel(NewModel.class);
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
        updateNew.setModifIedby(userModel.getUserName());
		updateNew =  iNewService.UpData(updateNew);
		mapper.writeValue(resp.getOutputStream(), updateNew);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		NewModel  newModel = HttpUtils.of(req.getReader()).toModel(NewModel.class);
		 iNewService.Delete(newModel.getIds());
		 mapper.writeValue(resp.getOutputStream(),"{}");
		  
		  
		  
	}
}
