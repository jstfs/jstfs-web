package com.jstfs.web.friends.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jstfs.web.friends.db.DBManager;
import com.jstfs.web.friends.dto.FriendDTO;
import com.jstfs.web.friends.utils.PageUtils;

public class FriendDAO {

	/**
	 * 增加朋友
	 */
	public boolean addFriend(FriendDTO friend) {
		String sql = "insert into friend(type_id, friend_name, friend_address, friend_tel, context) values("
				+ friend.getTypeId()
				+ ",'"
				+ friend.getFriendName()
				+ "','"
				+ friend.getFriendAddress()
				+ "','"
				+ friend.getFriendTel()
				+ "','"
				+ friend.getContext() + "')";
		DBManager dbm = new DBManager();
		boolean isSuccess = (dbm.executeUpdate(sql) == 1);
		dbm.closeConn();
		return isSuccess;
	}

	/**
	 * 根据Id删除朋友
	 */
	public boolean deleteFriendById(int friendId) {
		String sql = "delete from friend where friend_id = " + friendId;
		DBManager dbm = new DBManager();
		boolean isSuccess = (dbm.executeUpdate(sql) == 1);
		dbm.closeConn();
		return isSuccess;
	}
	
	/**
	 * 根据typeId删除朋友
	 */
	public void deleteFriendByTypeId(int typeId) {
		String sql = "delete from friend where type_id = " + typeId;
		DBManager dbm = new DBManager();
		dbm.executeUpdate(sql);
		dbm.closeConn();
	}

	/**
	 * 更新朋友
	 */
	public boolean updateFriend(FriendDTO friend) {
		String sql = "update friend set "
				+ "type_id = '" + friend.getTypeId() + "', "
				+ "friend_name='" + friend.getFriendName() + "', "
				+ "friend_address='" + friend.getFriendAddress() + "', "
				+ "friend_tel='" + friend.getFriendTel() + "',"
				+ "context='" + friend.getContext() + "' "
				+ "where friend_id = " + friend.getFriendId();
		DBManager dbm = new DBManager();
		boolean isSuccess = (dbm.executeUpdate(sql) == 1);
		dbm.closeConn();
		return isSuccess;
	}

	/**
	 * 根据Id查找朋友
	 */
	public FriendDTO getFriendById(int friendId) {
		String sql = "select friend_id, type_id, friend_name, friend_address, friend_tel, context from friend where friend_id = " + friendId;
		DBManager dbm = new DBManager();
		ResultSet rs = dbm.executeQuery(sql);
		FriendDTO friend = null;
		try {
			while(rs.next()) {
				if(friend != null) {
					break;
				}
				friend = new FriendDTO();
				friend.setFriendId(rs.getInt(1));
				friend.setTypeId(rs.getInt(2));
				friend.setFriendName(rs.getString(3));
				friend.setFriendAddress(rs.getString(4));
				friend.setFriendTel(rs.getString(5));
				friend.setContext(rs.getString(6));
			}
			dbm.closeConn();
		} catch (SQLException e) {		
			e.printStackTrace();
		}				
		return friend;
	}

	/**
	 * 查找所有朋友
	 */
	public List<FriendDTO> getFriends() {
		String sql = "select friend_id, type_id, friend_name, friend_address, friend_tel, context from friend";
		DBManager dbm = new DBManager();
		ResultSet rs = dbm.executeQuery(sql);		
		ArrayList<FriendDTO> list = new ArrayList<FriendDTO>();
		try {
			while(rs.next()){
				FriendDTO friend = new FriendDTO();
				friend.setFriendId(rs.getInt(1));
				friend.setTypeId(rs.getInt(2));
				friend.setFriendName(rs.getString(3));
				friend.setFriendAddress(rs.getString(4));
				friend.setFriendTel(rs.getString(5));
				friend.setContext(rs.getString(6));
				list.add(friend);
			}
			dbm.closeConn();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 分页方法
	 */
	public List<FriendDTO> getFriendsByPage(int pageSize, int currentPage){
		String sql = PageUtils.getMySQLDividePageSQL("friend", null, pageSize, currentPage);
		DBManager dbm = new DBManager();
		ResultSet rs = dbm.executeQuery(sql);
		ArrayList<FriendDTO> list = new ArrayList<FriendDTO>();
		try {
			if(rs != null) {
				while(rs.next()){
					FriendDTO friend = new FriendDTO();
					friend.setFriendId(rs.getInt(1));
					friend.setTypeId(rs.getInt(2));
					friend.setFriendName(rs.getString(3));
					friend.setFriendAddress(rs.getString(4));
					friend.setFriendTel(rs.getString(5));
					friend.setContext(rs.getString(6));
					list.add(friend);
				}
			}
			dbm.closeConn();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 获取朋友总数
	 */
	public int getFriendCount(){
		String sql = "select count(*) from friend";
		DBManager dbm = new DBManager();
		ResultSet rs = dbm.executeQuery(sql);
		int count = 0 ;
		try {
			while(rs.next()){
				count = rs.getInt(1);
			}
			dbm.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}