package com.w3cservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBox
 */
@WebServlet("/CheckBox")
public class CheckBox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBox() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ֹ��������
		response.setCharacterEncoding("GBK");
		request.setCharacterEncoding("GBK");
		
		//���÷������� 
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String title="��ȡ��ѡ������";
		String outputHtml="<html>\n"
					+"<head>\n"+
					"<title>"+title+"</title>\n"
					+"</head>\n"
					+"<body bgcolor='#f0f0f0'>\n";
		outputHtml+="<h1 align='center'>"+title+"</h1>\n"
				+"<ul>\n"
				+"<li><b>��ѧ��ʶ</b>:"+request.getParameter("maths")+"</li>"
				+"<li><b>�����ʶ</b>:"+request.getParameter("physics")+"</li>"
				+"<li><b>��ѧ��ʶ</b>:"+request.getParameter("chemistry")+"</li>"
				+"</ul></body></html>";
		out.print(outputHtml);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
