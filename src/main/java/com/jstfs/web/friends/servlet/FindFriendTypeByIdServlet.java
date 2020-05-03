package com.jstfs.web.friends.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jstfs.web.friends.dao.FriendTypeDAO;
import com.jstfs.web.friends.dto.FriendTypeDTO;

public class FindFriendTypeByIdServlet extends HttpServlet {
	private static final long serialVersionUID = -2083868804830558363L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		FriendTypeDAO friendTypeDAO = new FriendTypeDAO();
		FriendTypeDTO friendType = friendTypeDAO.getFriendTypeById(typeId);

		request.setAttribute("friendType", friendType);
		request.getRequestDispatcher("/friendType/updateFriendType.jsp").forward(request, response);
	}
}