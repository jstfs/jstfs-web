package com.jstfs.web.friends.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jstfs.web.friends.db.DBManager;
import com.jstfs.web.friends.dto.FriendTypeDTO;

public class FriendTypeDAO {

	/**
	 * 增加朋友类别
	 */
	public boolean addFriendType(FriendTypeDTO friendType){
		String sql = "insert into friend_type(type_name, context) values('" + friendType.getTypeName() + "','" + friendType.getContext() + "')";
		DBManager dbm = new DBManager();
		boolean isSuccess = (dbm.executeUpdate(sql) == 1);
		dbm.closeConn();
		return isSuccess;
	}
	
	/**
	 * 删除朋友类别
	 */
	public boolean deleteFriendTypeById(int typeId){
		String sql = "delete from friend_type where type_id = " + typeId;
		DBManager dbm = new DBManager();
		boolean isSuccess = (dbm.executeUpdate(sql) == 1);
		dbm.closeConn();
		return isSuccess;
	}
	
	/**
	 *  根据Id更新朋友类别
	 */
	public boolean updateFriendType(FriendTypeDTO friendType){
		String sql = "update friend_type set type_name = '"+ friendType.getTypeName() +"',context = '"+ friendType.getContext() +"' where type_id = "+ friendType.getTypeId();
		DBManager dbm = new DBManager();
		boolean isSuccess = (dbm.executeUpdate(sql) == 1);
		dbm.closeConn();
		return isSuccess;
	}
	
	/**
	 * 根据Id查找朋友类别
	 */
	public FriendTypeDTO getFriendTypeById(int typeId){
		String sql = "select type_id, type_name, context from friend_type where type_id = " + typeId;
		DBManager dbm = new DBManager();
		ResultSet rs = dbm.executeQuery(sql);
		FriendTypeDTO friendType = null;
		try {
			while(rs.next()){
				if(friendType != null) {
					break;
				}
				friendType = new FriendTypeDTO(rs.getInt(1),rs.getString(2),rs.getString(3));				
			}
			dbm.closeConn();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return friendType;
	}
	
	/**
	 * 返回所有朋友类别
	 */
	public List<FriendTypeDTO> getFriendTypes(){
		String sql = "select type_id, type_name, context from friend_type";
		DBManager dbm = new DBManager();
		ResultSet rs = dbm.executeQuery(sql);
		ArrayList<FriendTypeDTO> list = new ArrayList<>();
		try {
			while(rs.next()){
				FriendTypeDTO friendType = new FriendTypeDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(friendType);
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return list;
	}
}