package vn.csc.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserLoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
	    String username = (String)session.getAttribute("userName");
	    if (username != null && !"".equals(username)) {
	    	chain.doFilter(request, response);
	    } else {
	      ((HttpServletResponse) response).sendRedirect("/student-management-web/");
	    }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}

