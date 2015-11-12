package com.w3cservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookies
 */
@WebServlet("/WriteCookies")
public class WriteCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteCookies() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ֹ��������
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		// Ϊ���ֺ����ϴ��� Cookies
		Cookie firstName = new Cookie("first_name",
				request.getParameter("first_name"));
		Cookie lastName = new Cookie("last_name",
				request.getParameter("last_name"));

		// Ϊ���� Cookies ���ù�������Ϊ 24 Сʱ��
		firstName.setMaxAge(60 * 60 * 24);
		lastName.setMaxAge(60 * 60 * 24);

		// ����Ӧͷ��������� Cookies
		response.addCookie(firstName);
		response.addCookie(lastName);

		// ������Ӧ��������
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String title = "���� Cookies ʵ��";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
				+ "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title
				+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
				+ "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>����</b>��" + request.getParameter("first_name")
				+ "\n" + "  <li><b>����</b>��" + request.getParameter("last_name")
				+ "\n" + "</ul>\n" + "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
