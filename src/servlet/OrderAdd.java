package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Order;
import vo.User;
import factory.OrderFactory;
import factory.RoomFactory;
@WebServlet("/web/orderAdd")
public class OrderAdd extends HttpServlet{
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
		Order order = null;
		try {
			order = OrderFactory.get().findById(req.getParameter("number"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(order != null){
			map.put("order", "预订单已存在");
			req.setAttribute("error", map);
			req.getRequestDispatcher("orderAdd.jsp").forward(req, resp);
			return;
		}
		User user = null;
		order = new Order();
		user = new User();
		order.setId(req.getParameter("id"));
		order.setLeftTime(req.getParameter("leftTime"));
		order.setComeTime(req.getParameter("comeTime"));
		order.setRoomId(req.getParameter("number"));
		user.setPhone(req.getParameter("phone"));
		order.setPeople(Integer.parseInt(req.getParameter("people")));
		user.setName(req.getParameter("name"));
		user.setId(req.getParameter("userId"));
		order.setUser(user);
		try {
			flag = OrderFactory.get().doCreate(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			try {
				RoomFactory.get().orderState(order.getRoomId());
				RoomFactory.get().setorder(req.getParameter("id"), req.getParameter("number"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("order", "");
			resp.sendRedirect("roomList.jsp");
			return;
		}
			map.put("order", "添加失败,请重新添加");
			req.setAttribute("error", map);
			req.getRequestDispatcher("orderAdd.jsp").forward(req, resp);
			return;
	}
}
