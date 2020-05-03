package com.jstfs.web.friends.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jstfs.web.friends.dao.FriendDAO;
import com.jstfs.web.friends.dao.FriendTypeDAO;
import com.jstfs.web.friends.dto.FriendDTO;
import com.jstfs.web.friends.dto.FriendTypeDTO;

public class FindFriendByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 7449167825510068684L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int friendId = Integer.parseInt(request.getParameter("friendId").toString());
		FriendDAO friendDAO = new FriendDAO();
		FriendDTO friend = friendDAO.getFriendById(friendId);
		FriendTypeDAO friendTypeDAO = new FriendTypeDAO();
		List<FriendTypeDTO> list = friendTypeDAO.getFriendTypes();

		request.setAttribute("friend", friend);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/friend/updateFriend.jsp").forward(request, response);
	}
}