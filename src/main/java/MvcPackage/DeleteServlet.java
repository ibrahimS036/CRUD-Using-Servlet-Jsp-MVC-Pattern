package MvcPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		Bean b = new Bean();
		
		b.setEmail(req.getParameter("email"));
		UserDao sum = new DaoImpl();
		sum.delete(b);
		if (sum != null) {
			out.println("<h1>Data Deleted successfully.</h1>");
		}

		
		
	}

}
