package com.w3cservlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LogFilter
 */
public class LogFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LogFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// ��ȡ�ͻ����� IP ��ַ
		String ipAddress = request.getRemoteAddr();

		// ��¼ IP ��ַ�͵�ǰʱ���
		System.out.println("IP " + ipAddress + ", Time "
				+ new Date().toString());

		// �����󴫻ع�����
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// ��ȡ��ʼ������
		String testParam = fConfig.getInitParameter("test-param");

		// �����ʼ������
		System.out.println("Test Param: " + testParam);
	}

}
