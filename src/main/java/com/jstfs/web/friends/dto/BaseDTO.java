package com.jstfs.web.friends.dto;

import java.io.Serializable;
import java.util.Date;

public class BaseDTO implements Serializable {
	private static final long serialVersionUID = -966683840987169884L;
	
	private String createdBy;
	private Date createTime;
	private String updatedBy;
	private Date updateTime;
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
