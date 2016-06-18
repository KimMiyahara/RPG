package br.com.pathfinder.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletT extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6730707063061301984L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.getWriter().println(req.getParameter("nome"));
		res.getWriter().println("Servlet GET 1");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.getWriter().println("Servlet POST 1");
	}
	
	public void init() throws ServletException {
		System.out.println("Servlet 1 - init");
	}

	public void destroy() {
		System.out.println("Servlet 1 - destroy");
	}
}
