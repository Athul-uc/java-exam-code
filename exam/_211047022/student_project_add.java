package _211047022;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  



@SuppressWarnings("serial")
public class student_project_add extends HttpServlet 
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
			 
			 	String rnum1= request.getParameter("rollno");
				int rollno = Integer.parseInt(rnum1);
				
				String rnum2= request.getParameter("id");
				int id = Integer.parseInt(rnum2);
				
				
				
				PreparedStatement ps=conn.prepareStatement("insert into student_project (rollno,id) values (?,?)");
				ps.setInt(1,rollno);
				ps.setInt(2,id);
				
				
				 
				ps.executeUpdate();
				
				
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<h1 align = \"center\"> Updated Successfully </h1>");
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
	

	      
	

