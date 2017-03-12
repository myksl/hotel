package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.User;
import factory.UserFactory;
@WebServlet("/web/userAdd")
public class UserAdd  extends HttpServlet{
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
		User user = null;
		try {
			user = UserFactory.get().findById(req.getParameter("id"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(user != null){
			map.put("user", "用户已存在");
			req.setAttribute("error", map);
			req.getRequestDispatcher("userAdd.jsp").forward(req, resp);
			return;
		}
		user = new User();
		user.setName(req.getParameter("name"));
		user.setId(req.getParameter("id"));;
		user.setCardId(req.getParameter("cardId"));
		user.setPhone(req.getParameter("phone"));
		try {
			flag = UserFactory.get().doCreate(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			map.put("user", "");
			resp.sendRedirect("roomList.jsp");
			return;
		}
			map.put("user", "添加失败,请重新添加");
			req.setAttribute("error", map);
			req.getRequestDispatcher("UserAdd.jsp").forward(req, resp);
			return;
	}
}
