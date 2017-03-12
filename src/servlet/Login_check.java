package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import vo.Admin;
import factory.AdminFactory;

@WebServlet("/login")
public class Login_check extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String,String> map = new  HashMap<String, String>();
		boolean flag = false;
		Admin admin = null;
		admin = new Admin();
		admin.setUsername(req.getParameter("username"));
		admin.setPassword(req.getParameter("password"));
		try {
			flag = AdminFactory.get().find(admin.getUsername());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(!flag){
			map.put("admin", "用户不存在");
			req.setAttribute("error", map);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		try {
			flag = AdminFactory.get().check(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			HttpSession session = req.getSession();
			session.setAttribute("admin", admin);
			resp.sendRedirect("main.jsp");
			return;
		}
			map.put("admin", "密码错误");
			req.setAttribute("error", map);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
	}
}
