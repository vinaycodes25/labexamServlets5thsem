import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("name");
		String panid=request.getParameter("panid");
		Cookie[] ck=new Cookie[2];
ck[0]=new Cookie("user",user);
ck[1]=new Cookie("panid",panid);
		response.addCookie(ck[0]);
		response.addCookie(ck[1]);
		request.getRequestDispatcher("servlet2").forward(request, response);
		}

}
