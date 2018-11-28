package com.yy.bean;

public class Operator {

	//操作员工号
	private int wk_no ;
	//操作员密码
	private String password ;
	//操作员名称
	private String oname ;
	//手机号码
	private String msisdn ;
	//归属编码1
	private int org_id ;
	//归属编码2
	private int site_id ;
	//隶属等级
	private String wk_level ;
	//创建时间
	private String insert_time ;
	//修改时间
	private String modify_time ;
	//锁定开始时间
	private String lock_begin ;
	//锁定结束时间
	private String lock_end ;
	//出错次数
	private int trytimes ;
	//是否锁定,0：未锁定；	1：锁定
	private int is_lock ;
	
	public int getWk_no() {
		return wk_no;
	}
	public void setWk_no(int wk_no) {
		this.wk_no = wk_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	public int getSite_id() {
		return site_id;
	}
	public void setSite_id(int site_id) {
		this.site_id = site_id;
	}
	public String getWk_level() {
		return wk_level;
	}
	public void setWk_level(String wk_level) {
		this.wk_level = wk_level;
	}
	public String getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(String insert_time) {
		this.insert_time = insert_time;
	}
	public String getModify_time() {
		return modify_time;
	}
	public void setModify_time(String modify_time) {
		this.modify_time = modify_time;
	}
	public String getLock_begin() {
		return lock_begin;
	}
	public void setLock_begin(String lock_begin) {
		this.lock_begin = lock_begin;
	}
	public String getLock_end() {
		return lock_end;
	}
	public void setLock_end(String lock_end) {
		this.lock_end = lock_end;
	}
	public int getTrytimes() {
		return trytimes;
	}
	public void setTrytimes(int trytimes) {
		this.trytimes = trytimes;
	}
	public int getIs_lock() {
		return is_lock;
	}
	public void setIs_lock(int is_lock) {
		this.is_lock = is_lock;
	}
	
	@Override
	public String toString() {
		return "Operator [wk_no=" + wk_no + ", password=" + password
				+ ", oname=" + oname + ", msisdn=" + msisdn + ", org_id="
				+ org_id + ", site_id=" + site_id + ", wk_level=" + wk_level
				+ ", insert_time=" + insert_time + ", modify_time="
				+ modify_time + ", lock_begin=" + lock_begin + ", lock_end="
				+ lock_end + ", trytimes=" + trytimes + ", is_lock=" + is_lock
				+ "]";
	}
	
}
