package com.yy.bean;

public class Operator {

	//����Ա����
	private int wk_no ;
	//����Ա����
	private String password ;
	//����Ա����
	private String oname ;
	//�ֻ�����
	private String msisdn ;
	//��������1
	private int org_id ;
	//��������2
	private int site_id ;
	//�����ȼ�
	private String wk_level ;
	//����ʱ��
	private String insert_time ;
	//�޸�ʱ��
	private String modify_time ;
	//������ʼʱ��
	private String lock_begin ;
	//��������ʱ��
	private String lock_end ;
	//�������
	private int trytimes ;
	//�Ƿ�����,0��δ������	1������
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
