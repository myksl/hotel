package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Live;
import vo.Room;
import factory.LiveFactory;
import factory.RoomFactory;
@WebServlet("/web/liveAdd")
public class LiveAdd extends HttpServlet{
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
		Live live = null;
		try {
			live = LiveFactory.get().findById(req.getParameter("number"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(live != null){
			map.put("live", "入住单已存在");
			req.setAttribute("error", map);
			req.getRequestDispatcher("liveAdd.jsp").forward(req, resp);
			return;
		}
		Room room = null;
		room = new Room();
		live = new Live();
		live.setId(req.getParameter("id"));
		live.setOrderId(req.getParameter("orderId"));
		live.setUserId(req.getParameter("userId"));
		live.setBillState(req.getParameter("billState"));
		live.setPeople(Integer.parseInt(req.getParameter("people")));
		room.setNumber(req.getParameter("number"));
		room.setPrice(req.getParameter("price"));
		room.setType(req.getParameter("type"));
		live.setRoom(room);
		try {
			flag = LiveFactory.get().doCreate(live);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			try {
				RoomFactory.get().liveState(live.getRoom().getNumber());
				RoomFactory.get().setlive(req.getParameter("id"), req.getParameter("number"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("live", "");
			resp.sendRedirect("roomList.jsp");
			return;
		}
			map.put("live", "添加失败,请重新添加");
			req.setAttribute("error", map);
			req.getRequestDispatcher("liveAdd.jsp").forward(req, resp);
			return;
	}
}
