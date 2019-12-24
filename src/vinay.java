

import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.io.*;

/**
 * Servlet implementation class vinay
 */
@WebServlet("/vinay")
public class vinay extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try
		{
			Connection con;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
			Statement st=con.createStatement();
			String q1="select * from police";
			ResultSet rs=st.executeQuery(q1);
			String a=request.getParameter("val");
			int n=Integer.parseInt(request.getParameter("n"));
			
			
			switch(n)
			{
			
			case 1:
				int c=0;
				while(rs.next()) {
					if(rs.getString("area").equals(a))
					{
						out.println("area "+rs.getString("area")+rs.getString("phone"));
					c=1;	
					}
				}
					if(c==0)
					{
						out.println("police station not found");
					}
					break;
					
			case 2:
				int c1=0;
				while(rs.next()) {
					if(rs.getString("phone").equals(a))
					{
						out.println("area "+rs.getString("area")+rs.getString("phone"));
					c1=1;	
					}
				}
					if(c1==0)
					{
						out.println("police station not found");
					}	
					break;
			
			}
			
			
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
		
	}

}
