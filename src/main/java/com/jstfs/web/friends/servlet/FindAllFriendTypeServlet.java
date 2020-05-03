package com.jstfs.web.friends.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jstfs.web.friends.constant.WebConstant;
import com.jstfs.web.friends.dao.FriendTypeDAO;
import com.jstfs.web.friends.dto.FriendTypeDTO;

public class FindAllFriendTypeServlet extends HttpServlet {
	private static final long serialVersionUID = -558607060490803294L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(WebConstant.CHARACTER_ENCODING_UTF8);
		String forward = request.getParameter("forward");

		FriendTypeDAO friendTypeDAO = new FriendTypeDAO();
		List<FriendTypeDTO> list = friendTypeDAO.getFriendTypes();
		request.setAttribute("list", list);
		if(forward.equals("friend")) {
			request.getRequestDispatcher("/friend/addFriend.jsp").forward(request, response);
		}
		if(forward.equals("friendType")) {
			request.getRequestDispatcher("/friendType/friendTypeList.jsp").forward(request, response);
		}
	}
}
