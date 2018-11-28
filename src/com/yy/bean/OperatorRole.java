package com.yy.bean;

public class OperatorRole {
	//操作员工号
	private int wk_no;
	//角色编码
	private int role_id;
	
	public int getWk_no() {
		return wk_no;
	}
	public void setWk_no(int wk_no) {
		this.wk_no = wk_no;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	@Override
	public String toString() {
		return "OperatorRole [wk_no=" + wk_no + ", role_id=" + role_id + "]";
	}

	
	
	
}
