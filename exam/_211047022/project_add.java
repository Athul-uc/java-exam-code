package _211047022;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  



@SuppressWarnings("serial")
public class project_add extends HttpServlet 
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
			 
			 	String rnum1= request.getParameter("id");
				int id = Integer.parseInt(rnum1);
				
				String title= request.getParameter("title");
				String keyword= request.getParameter("keyword");
				String domain= request.getParameter("domain");
				
				
				
				PreparedStatement ps=conn.prepareStatement("insert into project (id,title,keyword,Domain) values (?,?,?,?)");
				ps.setInt(1,id);
				ps.setString(2,title);
				ps.setString(3,keyword);
				ps.setString(4,domain);
				 
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
	

	      
	
