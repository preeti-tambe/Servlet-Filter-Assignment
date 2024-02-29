

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class MyFilter implements Filter {

    
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		
		
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		
		if(uname.equals("")||upass.equals(""))
		{
			p.print("This is before filter<br>");

			p.print("<b>Please First Enter Your UserName and Password</b><br>");
            request.getRequestDispatcher("index.html").include(request, response);
		}
		
		else
		{
			chain.doFilter(request, response);
			p.print("<br>This is after Filter");
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}