package _211047022;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@SuppressWarnings("serial")
public class student_project_delete extends HttpServlet 
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
						int rollno = Integer.parseInt(rnum1);
										
						PreparedStatement ps=conn.prepareStatement("delete from student_project where rollno = ?");
						ps.setInt(1,rollno); 
						PrintWriter out = response.getWriter();
						response.setContentType("text/html");
						if (ps.executeUpdate() > 0) {
						
						
						out.println("<h1 align = \"center\"> Deleted Successfully </h1>");
						out.println("<br><br>");
						
						conn.close();
						}
						else
						{
							out.println("<h1 align = \"center\"> Record Not Found </h1>");
							out.println("<br><br>");
						}
		   		 
		   		 
				 }
				
		   		 
		   	 }
				 catch (SQLException e) 
			        {
			            e.printStackTrace();
			        }
			}
		}
			

			      
			
