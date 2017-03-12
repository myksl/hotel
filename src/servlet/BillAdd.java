package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Bill;
import factory.BillFactory;
import factory.RoomFactory;
@WebServlet("/web/billAdd")
public class BillAdd extends HttpServlet{
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
		Bill bill = null;
		try {
			bill = BillFactory.get().findById(req.getParameter("number"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(bill != null){
			map.put("bill", "账单已存在");
			req.setAttribute("error", map);
			req.getRequestDispatcher("orderAdd.jsp").forward(req, resp);
			return; 
		}
		bill = new Bill();
		bill.setName(req.getParameter("name"));
		bill.setLiveId(req.getParameter("liveId"));
		bill.setOrderId(req.getParameter("orderId"));
		bill.setPrice(req.getParameter("price"));
		bill.setPs(req.getParameter("ps"));
		String id = req.getParameter("liveId");
		id.substring(1, 4);
		try {
			flag = BillFactory.get().doCreate(bill);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			try {
				RoomFactory.get().noState(bill.getLiveId());
				map.put("bill", "");
				resp.sendRedirect("roomList.jsp");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			map.put("bill", "添加失败,请重新添加");
			req.setAttribute("error", map);
			req.getRequestDispatcher("billAdd.jsp").forward(req, resp);
			return;
	}
}
