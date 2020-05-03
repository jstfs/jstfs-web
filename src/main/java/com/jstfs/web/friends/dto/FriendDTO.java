package com.jstfs.web.friends.dto;

public class FriendDTO extends BaseDTO {
	private static final long serialVersionUID = 2075896174405254130L;
	
	private int friendId;
	private int typeId;
	private String typeName;	//数据库未映射,用于显示
	private String friendName;
	private String friendAddress;
	private String friendTel;
	private String context;	
	private FriendTypeDTO friendType;
	
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getFriendAddress() {
		return friendAddress;
	}
	public void setFriendAddress(String friendAddress) {
		this.friendAddress = friendAddress;
	}
	public String getFriendTel() {
		return friendTel;
	}
	public void setFriendTel(String friendTel) {
		this.friendTel = friendTel;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public FriendTypeDTO getFriendType() {
		return friendType;
	}
	public void setFriendType(FriendTypeDTO friendType) {
		this.friendType = friendType;
	}
}