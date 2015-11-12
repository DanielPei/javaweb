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
 * Servlet implementation class DeleteCookies
 */
@WebServlet("/DeleteCookies")
public class DeleteCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//防止中文乱码
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
	      Cookie cookie = null;
		  Cookie[] cookies = null;
	      // 获取与该域相关的 Cookies 的数组
	      cookies = request.getCookies();
	      
		  // 设置响应内容类型
	      response.setContentType("text/html");
	 
	      PrintWriter out = response.getWriter();
	      String title = "Delete Cookies Example";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" );
	       if( cookies != null ){
	         out.println("<h2>Cookies 名称和值</h2>");
	         for (int i = 0; i < cookies.length; i++){
	            cookie = cookies[i];
	            if((cookie.getName( )).compareTo("first_name") == 0 ){
	                 cookie.setMaxAge(0);
	                 response.addCookie(cookie);
	                 out.print("已删除的 cookie：" + 
	                              cookie.getName( ) + "<br/>");
	            }
	            out.print("名称：" + cookie.getName( ) + "，");
	            out.print("值：" + cookie.getValue( )+" <br/>");
	         }
	      }else{
	          out.println(
	            "<h2>No cookies founds</h2>");
	      }
	      out.println("</body>");
	      out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
