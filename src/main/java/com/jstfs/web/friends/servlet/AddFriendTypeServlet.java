package com.jstfs.web.friends.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.jstfs.web.friends.constant.WebConstant;
import com.jstfs.web.friends.dao.FriendTypeDAO;
import com.jstfs.web.friends.dto.FriendTypeDTO;

public class AddFriendTypeServlet extends HttpServlet {
	private static final long serialVersionUID = -4231678280517333042L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(WebConstant.CHARACTER_ENCODING_UTF8);

		String path = "/error.jsp";
		request.setAttribute("srcPage", "添加朋友类别");
		
		String typeName = request.getParameter("typeName");
		String context = request.getParameter("context");
		
		if (StringUtils.isEmpty(typeName)) {
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			FriendTypeDTO friendType = new FriendTypeDTO();
			friendType.setTypeName(typeName);
			friendType.setContext(context);
			FriendTypeDAO friendTypeDAO = new FriendTypeDAO();
			if(friendTypeDAO.addFriendType(friendType)) {
				path = "/success.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
}