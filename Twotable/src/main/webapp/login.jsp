<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<jsp:useBean id="d" class="com.Details"></jsp:useBean>
<jsp:setProperty property="*" name="d"/>
<%@page import="com.SqlConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String name=request.getParameter("uname");
String num=request.getParameter("unum");

Connection con=SqlConnection.getConnection();

PreparedStatement ps=con.prepareStatement("select * from contactdetails where name=? and number=?");

d.setName(name);
d.setNumber(num);

ps.setString(1, d.getName());
ps.setString(2, d.getNumber());

ResultSet rs=ps.executeQuery();

if(rs.next()){
	
	%>
	
	<%="Welcome "+name %>
<%	
}

else{
	
	%>
	
	<%="Username or password is incorrect" %>
	
	<%
}
con.close();
%>
</body>
</html>