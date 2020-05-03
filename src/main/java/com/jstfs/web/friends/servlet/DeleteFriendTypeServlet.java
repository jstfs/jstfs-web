package com.jstfs.web.friends.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jstfs.web.friends.dao.FriendDAO;
import com.jstfs.web.friends.dao.FriendTypeDAO;

public class DeleteFriendTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 3344047431491137271L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FriendTypeDAO friendTypeDAO = new FriendTypeDAO();
		FriendDAO friendDAO = new FriendDAO();
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		String path = "/error.jsp";
		if(friendTypeDAO.deleteFriendTypeById(typeId)) {
			friendDAO.deleteFriendByTypeId(typeId);
			path = "/success.jsp";
		}

		request.setAttribute("srcPage", "删除好友类别");
		request.getRequestDispatcher(path).forward(request, response);
	}
}