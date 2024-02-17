package com.ty.projectManagement.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.projectManagement.dao.PasswordDataDao;
import com.ty.projectManagement.dto.PasswordData;

@WebServlet("/delete1")
public class Delete1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession httpSession = req.getSession();
    	   int id = (Integer)httpSession.getAttribute("id");
    	   PasswordDataDao dao = new PasswordDataDao();
    	  dao.deletePasswordDataById(id);
    	  RequestDispatcher dispatcher = req.getRequestDispatcher("register.html");
    	  dispatcher.forward(req, resp);
    }
}
