package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.regex.*;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

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
		        String username = request.getParameter("username");
		        String userpwd = request.getParameter("userpwd");
		        String userpwd2= request.getParameter("userpwd2");
		        UserDao dao = new UserDao();		       
				try {
						if(dao.findUser(username) != false){
							 out.println("用户名已存在！");
						} else {
							String reg =  "^\\d{6,10}$"; 
							String reg1 = "^[a-zA-Z][a-zA-Z0-9]{5,}$"; 
							Pattern pat = Pattern.compile(reg);  //Matcher mat = pat.matcher(userpwd);						
							Pattern pat1 = Pattern.compile(reg1);  //Matcher mat1 = pat1.matcher(userid);						
							boolean rs0 = pat.matcher(userpwd).find();
							boolean rs1 = pat1.matcher(username).find();
							 out.println("用户账号的正则表达式校验值："+"密码格式"+rs0+"&nbsp"+"用户名格式"+rs1+"<br>");
							 if(username==null||username==""){ out.println("用户名不能为空！");}
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
								  User u = new User();
							  	  u.setUsername(username);
							  	  u.setUserpwd(Integer.parseInt(userpwd));
							  	  dao.save(u);
								  out.println("欢迎您注册成功！");
							   }						
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					       					
			}		 										
	}


