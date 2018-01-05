package osgi.test.helloworld.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = -4898114384506325266L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().write("hello osgi http servlet.time now is " + new Date());
	}
}
