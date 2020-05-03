package com.jstfs.web.friends.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jstfs.web.friends.constant.WebConstant;
import com.jstfs.web.friends.dao.FriendDAO;

public class DeleteFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 7140165743913062039L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(WebConstant.CHARACTER_ENCODING_UTF8);
	   	int friendId = Integer.parseInt(request.getParameter("friendId"));
	   	String path = "/error.jsp";
	   	FriendDAO friendDAO = new FriendDAO();
	   	if(friendDAO.deleteFriendById(friendId)){
	   		path = "/success.jsp";
	   	}
	   	
	   	request.setAttribute("srcPage", "删除好友");
	   	request.getRequestDispatcher(path).forward(request, response);
	}
}