package _211047022;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  



@SuppressWarnings("serial")
public class student_add extends HttpServlet 
{   
	String dbURL1 = "jdbc:sqlserver://LAPTOP-R07JHSTN:1433;databaseName=student1;encrypt=true;trustServerCertificate=true;";
	String user = "athul";
	String pass = "athul";
	Connection conn = null;

	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	
		 try {
    		 
	         	
	         	conn = DriverManager.getConnection(dbURL1, user, pass);
	         } 
		 
	         catch (SQLException  ex)
	         {
	             ex.printStackTrace();
	         }
		 try {

		 if (conn != null) {
			 
			 	String rnum1= request.getParameter("roll_no");
				int roll_no = Integer.parseInt(rnum1);
				
				String name= request.getParameter("name");
				String branch= request.getParameter("branch");
				String Address= request.getParameter("Address");
				
				
				
				PreparedStatement ps=conn.prepareStatement("insert into student (roll_no,name,branch,Address) values (?,?,?,?)");
				ps.setInt(1,roll_no);
				ps.setString(2,name);
				ps.setString(3,branch);
				ps.setString(4,Address);
				 
				ps.executeUpdate();
				
				PrintWriter out = response.getWriter();
				
				
				response.setContentType("text/html");
				out.println("<h1 align = \"center\"> Student Added Successfully </h1>");
				out.println("<br><br>");
				
				conn.close();
   		 
   		 
		 }
		
   		 
   	 }
		 catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	}
}
	

	      
	
