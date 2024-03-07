package MvcPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		Bean b = new Bean();

		b.setEmail(req.getParameter("email"));
		b.setPassword(req.getParameter("password"));
		UserDao sum = new DaoImpl();
		sum.update(b);
		if (sum != null) {
			out.println("<h1>Data Update successfully.</h1>");
		}

	}

}
