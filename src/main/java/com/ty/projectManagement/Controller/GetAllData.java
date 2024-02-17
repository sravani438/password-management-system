package com.ty.projectManagement.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.projectManagement.dao.PasswordDataDao;
import com.ty.projectManagement.dto.PasswordData;

@WebServlet("/getalldata")
public class GetAllData extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PasswordDataDao dao = new PasswordDataDao();
    	List<PasswordData> listdata =dao.getAllPasswordDatasDetails();
    	req.setAttribute("listdata", listdata);
    	RequestDispatcher dispatcher = req.getRequestDispatcher("getAlldata.jsp");
    	dispatcher.forward(req, resp);	
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PasswordDataDao dao = new PasswordDataDao();
    	List<PasswordData> listdata =dao.getAllPasswordDatasDetails();
    	req.setAttribute("listdata", listdata);
    	RequestDispatcher dispatcher = req.getRequestDispatcher("getAlldata.jsp");
    	dispatcher.forward(req, resp);
    	
    	
    }
}
