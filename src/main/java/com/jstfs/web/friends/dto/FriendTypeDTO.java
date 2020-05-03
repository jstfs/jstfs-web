package com.jstfs.web.friends.dto;

public class FriendTypeDTO extends BaseDTO {
	private static final long serialVersionUID = 4381038322662118925L;
	
	private int typeId;
	private String typeName;
	private String context;	
		
	public FriendTypeDTO() {
	}
	public FriendTypeDTO(String typeName, String context) {
		super();
		this.typeName = typeName;
		this.context = context;
	}
	public FriendTypeDTO(int typeId, String typeName, String context) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.context = context;
	}
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
}