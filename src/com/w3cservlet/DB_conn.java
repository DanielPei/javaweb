package com.w3cservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DB_conn
 */
@WebServlet("/DB_conn")
public class DB_conn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DB_conn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("GBK");
		request.setCharacterEncoding("GBK");
	      // JDBC ���������ƺ����ݿ�� URL
	      final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	      final String DB_URL="jdbc:mysql://localhost/world";

	      //  ���ݿ��ƾ��
	      final String USER = "root";
	      final String PASS = "Daniel.891003";
	      
	      Connection conn=null;
	      Statement stmt=null;

	      // ������Ӧ��������
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      String title = "���ݿ���";
	      String docType =
	        "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
	         out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<h1 align=\"center\">" + title + "</h1>\n");
	      try{
	         // ע�� JDBC ������
	         Class.forName("com.mysql.jdbc.Driver");

	         // ��һ������
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);

	         // ִ�� SQL ��ѯ
	         stmt = conn.createStatement();
	         String sql;
	         sql = "SELECT * FROM world.city limit 0,10";
	         ResultSet rs = stmt.executeQuery(sql);

	         // �ӽ��������ȡ����
	         while(rs.next()){
	            // ���������Ƽ���
	            int id  = rs.getInt("ID");
	            int population = rs.getInt("Population");
	            String name = rs.getString("Name");

	            // ��ʾֵ
	            out.println("ID: " + id + "<br>");
	            out.println("NAME: " + name + "<br>");
	            out.println(", Population: " + population + "<br>");
	         }
	         out.println("</body></html>");

	         // ������
	         rs.close();
	         stmt.close();
	         conn.close();
	      }catch(SQLException se){
	         // ���� JDBC ����
	         se.printStackTrace();
	      }catch(Exception e){
	         // ���� Class.forName ����
	         e.printStackTrace();
	      }finally{
	         // ��������ڹر���Դ�Ŀ�
	         try{
	            if(stmt!=null)
	               stmt.close();
	         }catch(SQLException se2){
	         }// ���ǲ�����ʲô
	         try{
	            if(conn!=null)
	            conn.close();
	         }catch(SQLException se){
	            se.printStackTrace();
	         }//end finally try
	      } //end try
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
