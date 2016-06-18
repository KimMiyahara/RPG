package br.com.pathfinder.web.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletT2 extends HttpServlet {
	int count =0;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3560463803329605673L;
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.getWriter().println("Servlet GET 2 - " + this.count++);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.getWriter().println("Servlet POST 2");
	}
	
	public void init() throws ServletException {
		System.out.println("Servlet 2 - init");
	}

	public void destroy() {
		System.out.println("Servlet 2 - destroy");
	}
}
