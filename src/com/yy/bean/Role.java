package com.yy.bean;

public class Role {
	//角色编码
	private int role_id;
	//角色名称
	private String role_name;
	//角色级别
	private int role_level;
	//角色描述
	private String role_desc;
	//修改时间
	private String modify_date;
	//创建时间
	private String create_date;
	
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public int getRole_level() {
		return role_level;
	}
	public void setRole_level(int role_level) {
		this.role_level = role_level;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	@Override
	public String toString() {
		return "role [role_id=" + role_id + ", role_name=" + role_name
				+ ", role_level=" + role_level + ", role_desc=" + role_desc
				+ ", modify_date=" + modify_date + ", create_date="
				+ create_date + "]";
	}	
	

}
