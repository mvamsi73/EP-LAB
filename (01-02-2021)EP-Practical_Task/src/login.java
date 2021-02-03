

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		DAO d=new DAO();
		try {
			if(d.validate(email, pass))
			{
				RequestDispatcher rd=request.getRequestDispatcher("feedback.html");
				rd.include(request, response);
				Cookie ck=new Cookie("email",email);
				response.addCookie(ck);
			}
			else
			{
				PrintWriter pw=response.getWriter();
				request.getRequestDispatcher("login.html").include(request, response);
				pw.print("Your Username or Password doesn't match please try again");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
