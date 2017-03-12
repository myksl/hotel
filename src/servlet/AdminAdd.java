package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Admin;
import factory.AdminFactory;
@WebServlet("/web/adminAdd")
public class AdminAdd extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin admin;
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
		boolean have = false;
		admin = null;
		try {
			have = AdminFactory.get().find(req.getParameter("username"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(have){
			map.put("admin", "用户名已存在");
			req.setAttribute("error", map);
			req.getRequestDispatcher("adminAdd.jsp").forward(req, resp);
			return ;
		}
		admin = new Admin();
		admin.setLevel(req.getParameter("level"));
		admin.setPassword(req.getParameter("password"));;
		admin.setUsername(req.getParameter("username"));
		try {
			flag = AdminFactory.get().doCreate(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			map.put("admin", "");
			resp.sendRedirect("adminList.jsp");
			return ;
		}
			map.put("admin", "添加失败,请重新添加");
			req.setAttribute("error", map);
			req.getRequestDispatcher("adminAdd.jsp").forward(req, resp);
			 return;
	}
}
