package com.zz91.zzwork.desktop.domain.hr;

import java.io.Serializable;
import java.util.Date;

/***
 * 
 * @author root
 *
 */
public class Attendance implements Serializable {
      
	/**
	 * 员工出勤信息
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String  name;
	private String  code;
	private String  account;
	private Date    gmtWork;
	private Date    gmtCreated;
	private Date    modeified;
	
	public Attendance() {
		
		
	}
	public Attendance(Integer id ,String name,String code,String account,Date gmtWork,
			Date gmtCreated,Date modeified){
		this.id = id;
		this.name = name;
		this.code =code;
		this.account = account;
		this.gmtWork = gmtWork;
		this.gmtCreated =gmtCreated;
		this.modeified = modeified;
		
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getGmtWork() {
		return gmtWork;
	}
	public void setGmtWork(Date gmtWork) {
		this.gmtWork = gmtWork;
	}
	public Date getGmtCreated() {
		return gmtCreated;
	}
	public void setGmtCreated(Date gmtCreated) {
		this.gmtCreated = gmtCreated;
	}
	public Date getModeified() {
		return modeified;
	}
	public void setModeified(Date modeified) {
		this.modeified = modeified;
	}
}
