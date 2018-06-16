package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbc.JdbcUtil;
import dao.UserDao;
public class FormCheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		        response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        request.setCharacterEncoding("UTF-8");

		        try {
		        String userid = request.getParameter("userid");
		        String userpwd = request.getParameter("userpwd");
		        int pwd=Integer.parseInt(userpwd);
		        String userpwd2= request.getParameter("userpwd2");
		        UserDao userdao = new UserDao();		        
					if(userdao.findUser(userid) != false){
						 out.println("用户名已存在！");
					} else {
						String reg =  "^\\d{6,10}$"; 
						String reg1 = "^[a-zA-Z][a-zA-Z0-9]{5,}$"; 
						Pattern pat = Pattern.compile(reg);  
						//Matcher mat = pat.matcher(userpwd);
						Pattern pat1 = Pattern.compile(reg1);  
						//Matcher mat1 = pat1.matcher(userid);
						boolean rs0 = pat.matcher(userpwd).find();
						boolean rs1 = pat1.matcher(userid).find();
						 out.println("用户账号的正则表达式校验值："+"密码格式"+rs0+"&nbsp"+"用户名格式"+rs1+"<br>");
						 if(userid==null||userid==""){ out.println("用户名不能为空！");}
						 else if(userpwd==null||userpwd==""){ out.println("密码不能为空！");}
						 else if(!rs1)//如果账号输入不符合规格
						  {
						   out.println("用户名格式不正确！");						 
						  }						
						 else if(!rs0)//如果账号输入不符合规格
						  {
						   out.println("您输入的密码必须是6-10位数字！");						 
						  }
						 else if(!userpwd.equals(userpwd2)){out.println("两次密码不一致！");}
						  else//如果账号符号规格
						  {							  
							  Connection conn = null;
							  conn = JdbcUtil.getConnection();
							  PreparedStatement ps = null;
								String sql = "insert into user value(?,?)";
								ps = conn.prepareStatement(sql);
								ps.setString(1, userid);
								ps.setInt(2, pwd);
								ps.executeUpdate();								
							  out.println("欢迎您注册成功！");							  
						   }						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}catch(NumberFormatException ex){ // handle your exception
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
		
				
			}
		 
										
	}


