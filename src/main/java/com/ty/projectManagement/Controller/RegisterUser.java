package com.ty.projectManagement.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.projectManagement.dao.PasswordDataDao;
import com.ty.projectManagement.dto.PasswordData;

@WebServlet("/registeruser")
public class RegisterUser extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String password = req.getParameter("password");
//	String fb_password = req.getParameter("fb_password");
//	String gmail_password = req.getParameter("gmail_password");
//	String insta_password = req.getParameter("insta_password");
//	String linkedin_password = req.getParameter("linkedin_password");
//    long phone = Long.parseLong(req.getParameter("phone"));
    String role = req.getParameter("role");
    
    PasswordData data = new PasswordData();
    data.setName(name);
    data.setEmail(email);
    data.setPassword(password);
//    data.setFb_password(fb_password);
//    data.setGmail_password(gmail_password);
//    data.setInsta_password(insta_password);
//    data.setLinkedin_password(linkedin_password);
//    data.setPhone_num(phone);
    data.setRole(role);
    
    PasswordDataDao dao = new PasswordDataDao();
    dao.savePasswordData(data);
    RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
    dispatcher.forward(req, resp);
}
}
