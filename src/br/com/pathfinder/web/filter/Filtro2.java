package br.com.pathfinder.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filtro2  implements Filter{
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		resp.getWriter().println("ida2");
		chain.doFilter(req, resp);
		resp.getWriter().println("volts");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
