

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public register() {
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String section=request.getParameter("section");
		int year=Integer.parseInt(request.getParameter("year"));
		String password=request.getParameter("password");
		RegisterBean rb=new RegisterBean();
		rb.setId(id);
		rb.setName(name);
		rb.setEmail(email);
		rb.setYear(year);
		rb.setSection(section);
		rb.setPassword(password);
		DAO d=new DAO();
		try {
			d.initialize();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			int i=d.insert(rb);
			
			if(i>0)
			{
				response.sendRedirect("afreglogin.html");
			}
			else
			{
				PrintWriter pw=response.getWriter();
				pw.print("your registration is Failed");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
