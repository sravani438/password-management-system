<%@page import="com.ty.projectManagement.dto.PasswordData"%>
<%@page import="com.ty.projectManagement.dao.PasswordDataDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table align = "center"  cellpadding="20px" border="1px">
<% HttpSession httpSession = request.getSession();
   int id = (Integer)httpSession.getAttribute("id");
   PasswordDataDao dao = new PasswordDataDao();
   PasswordData data = dao.getPasswordDataById(id);
%>
<tr align = "center">
<th> id </th>
<th> name </th>
<th> email </th>
<th> password </th>
<th> fb_password </th>
<th> gmail_password </th>
<th> insta_password </th>
<th> linkedin_password</th>
<th> phone </th>
<th> role </th>
<th> delete </th>
<th> update </th>
</tr>

<tr align = "center">
<td><%=data.getId() %> </td>
<td><%=data.getName() %></td>
<td><%= data.getEmail() %></td>
<td> <%= data.getPassword() %> </td>
<td> <%= data.getFb_password() %> </td>
<td> <%= data.getGmail_password() %> </td>
<td> <%= data.getInsta_password() %> </td>
<td> <%= data.getLinkedin_password() %> </td>
<td> <%= data.getPhone_num() %> </td>
<td> <%= data.getRole() %> </td>
<td><a href = "delete1?id=<%= data.getId() %>">delete</a></td>
<td><a href = "update1.jsp?id=<%= data.getId() %>">update</a></td>
</tr>


</table>
</body>
</html>