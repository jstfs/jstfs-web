package com.jstfs.web.friends.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.jstfs.web.friends.constant.WebConstant;
import com.jstfs.web.friends.dao.FriendDAO;
import com.jstfs.web.friends.dto.FriendDTO;

public class AddFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 3868944132062962909L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(WebConstant.CHARACTER_ENCODING_UTF8);

		String path = "/error.jsp";
		request.setAttribute("srcPage", "添加朋友");

		String typeId = request.getParameter("typeId");
		String friendName = request.getParameter("friendName");
		String friendAddress = request.getParameter("friendAddress");
		String friendTel = request.getParameter("friendTel");
		String context = request.getParameter("context");
		if("0".equals(typeId)) {
			request.getRequestDispatcher(path).forward(request, response);
		} else if (StringUtils.isEmpty(friendName)) {
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			FriendDTO friend = new FriendDTO();
			friend.setTypeId(Integer.parseInt(typeId));
			friend.setFriendName(friendName);
			friend.setFriendAddress(friendAddress);
			friend.setFriendTel(friendTel);
			friend.setContext(context);
			FriendDAO friendDAO = new FriendDAO();
			if(friendDAO.addFriend(friend)) {
				path = "/success.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
}