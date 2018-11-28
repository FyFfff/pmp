package com.yy.bean;

public class Menutree {
	//功能代码
	private int id;
	//功能名称
	private String mname;
	//父功能编码
	private int parentid;
	//访问地址
	private String url;
	//状态
	private String state;
	//功能级别
	private int t_level;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getT_level() {
		return t_level;
	}
	public void setT_level(int t_level) {
		this.t_level = t_level;
	}
	
	@Override
	public String toString() {
		return "menutree [id=" + id + ", mname=" + mname + ", parentid="
				+ parentid + ", url=" + url + ", state=" + state + ", t_level="
				+ t_level + "]";
	}
	
	

}
