package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/twotable")
public class twotable extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try(PrintWriter out=response.getWriter()){
			 response.setContentType("text/html");
			 ArrayList<Table1> ob=new ArrayList<Table1>();
			 ArrayList<Table2> ob1=new ArrayList<Table2>();
	    		Class.forName("com.mysql.jdbc.Driver");
	    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","prakash123");
	    		PreparedStatement ps=con.prepareStatement("select*from contacts");
	    		PreparedStatement ps1 = con.prepareStatement("select*from addresses");
	    		ResultSet rs1 = ps1.executeQuery();
	            ResultSet rs = ps.executeQuery();
	            while (rs1.next() && rs.next()) {
					String number1 = rs1.getString("mobile_number");
					String address = rs1.getString("address");
					String id = rs1.getString("address_id");
					String number = rs.getString("mobile_number");
		        	String name = rs.getString("name");
					ob1.add(new Table2(id,address,number));
				
		        	ob.add(new Table1(name,number));
		 
						//out.println(id+" "+name+" "+address+" "+number);
					}
	            Iterator<Table1> it = ob.iterator();
	            Iterator<Table2> it1 = ob1.iterator();
	            while (it.hasNext()&& it1.hasNext()) {
					Table1 next = it.next();
					Table2 next1 = it1.next();
					
					if (next.getNumber().equals(next1.getNumber())) {
						//out.println(next.getName());
						//out.println(next.getNumber());
						
						PreparedStatement si = con.prepareStatement("insert into contactdetails values(?,?,?,?)");
						//out.println(next1.getId());
						si.setString(1,next1.getId());
						si.setString(2,next.getName());
						si.setString(3,next1.getAddress());
						si.setString(4,next.getNumber());
						int ex = si.executeUpdate();
						if (ex>0) {
							System.out.println("update successfully");
						}
						else {
							System.out.println("update failed");
						}
						out.println(next1.getId()+" "+next.getName()+" "+next1.getAddress()+" "+next.getNumber());
					}
				}
	           
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		 
	         
	}

}



	
