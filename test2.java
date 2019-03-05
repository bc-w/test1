public void doFilter(ServletRequest sreq, ServletResponse sres,
		FilterChain chain) throws IOException, ServletException {		
	HttpServletRequest request = (HttpServletRequest) sreq; 
	HttpServletResponse response = (HttpServletResponse) sres;
	
	LoginUserInfo userObj = (LoginUserInfo)request.getSession().getAttribute("LoginUserInfo");
	if (userObj != null ){
		chain.doFilter(request,response);
	}			 
	else
		if ("relogin".equals(request.getParameter("param")))
			chain.doFilter(request,response);
		else
			request.getRequestDispatcher("jsp/common/info.jsp").forward(request, response);			
}