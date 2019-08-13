package com.offcn.ssm.filter;

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

import com.offcn.ssm.pojo.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	private String[] keywords = {"car","order"};
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//1.如果当前已登录，直接放行
				HttpServletRequest rqs = (HttpServletRequest) request;
				HttpServletResponse rps = (HttpServletResponse) response;
				HttpSession session = rqs.getSession();
				User user = (User) session.getAttribute("user");
				if (user == null) {
					//未登录
					//判断该次请求是不是访问购物车或者订单,根据请求的url路径
					String url = rqs.getRequestURL().toString();
					//如果是访问订单或者购物车的路径，必定包含"car"或者"order"
					for (String keyword : keywords) {
						if (url.contains(keyword)) {
							//表示确实是访问购物车或者订单的请求，直接重定向跳转到login.jsp
							rps.sendRedirect(rqs.getContextPath()+"/login.action");
							
							//不放行了，代码就结束了
							return;
						}
					}
				}
				
				chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
