package com.jstfs.web.friends.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 页码从1开始
 */
public class PageUtils {
	/**
	 * Oracle分页
	 */
	public static String getOracleDividePageSQL(String tableName, int pageSize, int currentPage) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM (");
		sql.append("SELECT T.*, ROWNUM rn FROM (");
		sql.append("SELECT * FROM ").append(tableName).append(") T WHERE ROWNUM <=").append(pageSize * currentPage);
		sql.append(") WHERE rn >").append((pageSize - 1) * currentPage);
		return sql.toString();
	}
	
	/**
	 * SQLServer分页
	 */
	public static String getSQLServerDividePageSQL(String tableName, String primaryKey, int pageSize, int currentPage) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT top ").append(pageSize).append(" * FROM ");
		sql.append(tableName).append(" WHERE ").append(primaryKey);
		sql.append(" NOT IN (SELECT TOP ").append((pageSize - 1) * currentPage).append(" ").append(primaryKey);
		sql.append(" FROM ").append(tableName);
		return sql.toString();
	}
	
	/**
	 * MySQL分页
	 */
	public static String getMySQLDividePageSQL(String tableName, String whereClause, int pageSize, int currentPage) {
		StringBuilder sql = new StringBuilder();
		if(StringUtils.isEmpty(whereClause)) {
			whereClause = " WHERE 1=1";
		}
		sql.append("SELECT * FROM ").append(tableName);
		sql.append(whereClause);
		sql.append(" LIMIT ");
		sql.append((currentPage - 1) * pageSize);
		sql.append(", ");
		sql.append(pageSize);
		return sql.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(PageUtils.getMySQLDividePageSQL("friend", null, 5, 1));
	}
}
