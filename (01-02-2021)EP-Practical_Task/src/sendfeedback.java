

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sendfeedback
 */
@WebServlet("/sendfeedback")
public class sendfeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendfeedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Cookie ck[]=request.getCookies();
		String email="";
		if(ck!=null)
		{
			email=ck[0].getValue();
		String feedback=request.getParameter("feedback");
		DAO d=new DAO();
		PrintWriter pw=response.getWriter();
		try {
			int i=d.sendfeedback(email,feedback);
			if(i>0)
			{
				request.getRequestDispatcher("feedback.html").include(request, response);
				pw.print("\nYour Feedback is taken Successfully \nThank You  :)");
			}
			else
			{
				request.getRequestDispatcher("feedback.html").include(request, response);
				pw.print("\nYour Feedback is Already Taken :)");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
			request.getRequestDispatcher("index.html").include(request, response);
		}
		
	}

}
