package com.jstfs.web.friends.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;

import com.jstfs.web.friends.dao.FriendDAO;
import com.jstfs.web.friends.dao.FriendTypeDAO;
import com.jstfs.web.friends.dto.FriendDTO;
import com.jstfs.web.friends.dto.FriendTypeDTO;

public class DividePageServlet extends HttpServlet {
	private static final long serialVersionUID = -922086522039817472L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		FriendDAO friendDAO = new FriendDAO();
		FriendTypeDAO friendTypeDAO = new FriendTypeDAO();
		
		List<FriendTypeDTO> allTypes = friendTypeDAO.getFriendTypes();
		Map<Integer, String> typeMap = new HashMap<>();
		listFillMap(allTypes, typeMap);
		
		int count = friendDAO.getFriendCount();
		int pageCount = 1;
		if(count > 0) {
			pageCount = (count % pageSize == 0) ? (count / pageSize) : ((count / pageSize) + 1);
		}
		List<FriendDTO> friends = friendDAO.getFriendsByPage(pageSize, currentPage);
		
		for(FriendDTO friend : friends) {
			friend.setTypeName(typeMap.get(friend.getTypeId()));
		}
		
		request.setAttribute("friends", friends);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("/friend/friendList.jsp").forward(request, response);
	}
	
	private void listFillMap(List<FriendTypeDTO> allTypes, Map<Integer, String> typeMap) {
		if(CollectionUtils.isNotEmpty(allTypes)) {
			for(FriendTypeDTO type : allTypes) {
				typeMap.put(type.getTypeId(), type.getTypeName());
			}
		}
	}
}