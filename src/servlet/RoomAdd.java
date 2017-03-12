package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Room;
import factory.RoomFactory;
@WebServlet("/web/roomAdd")
public class RoomAdd extends HttpServlet{
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
		Room room = null;
		try {
			room = RoomFactory.get().findById(req.getParameter("number"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(room != null){
			map.put("room", "房间已存在");
			req.setAttribute("error", map);
			req.getRequestDispatcher("roomAdd.jsp").forward(req, resp);
			return;
		}
		room = new Room();
		room.setNumber(req.getParameter("number"));;
		room.setType(req.getParameter("type"));
		room.setPrice(req.getParameter("price"));
		room.setState("未住");
		try {
			flag = RoomFactory.get().doCreate(room);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		if(flag){
			map.put("room", "");
			resp.sendRedirect("roomList.jsp");
			return;
		}
			map.put("room", "添加失败,请重新添加");
			req.setAttribute("error", map);
			req.getRequestDispatcher("roomAdd.jsp").forward(req, resp);
			return;
	}
}
