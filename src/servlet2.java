import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user="";
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Cookie[]  ck=request.getCookies();
		user=ck[0].getValue();
		out.println("Welcome "+user);
		
		ck[0].setMaxAge(0);
		ck[1].setMaxAge(0);
		
		response.addCookie(ck[0]);
		response.addCookie(ck[1]);
	}
}

