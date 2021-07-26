package com.site.ex0721;

import java.sql.Timestamp;

public class BoardVo {

	
	
	public BoardVo() {}
	
	private int bid;
	private String btitle;
	private String bcontent;
	private String bname;
	private int bgroup;
	private int bstep;
	private int binent;
	private Timestamp bdate; 
	private String bupload;
	private int bhit;
	
	public BoardVo(String btitle, String bcontent, String bname, String bupload) {
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bname = bname;
		this.bupload = bupload;
	}

	
	public BoardVo(int bid, String btitle, String bcontent, String bname, int bgroup, int bstep, int binent,
			Timestamp bDate, String bupload, int bhit) {
		this.bid = bid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bname = bname;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.binent = binent;
		this.bdate = bDate;
		this.bupload = bupload;
		this.bhit = bhit;
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}


	public int getBgroup() {
		return bgroup;
	}


	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}


	public int getBstep() {
		return bstep;
	}


	public void setBstep(int bstep) {
		this.bstep = bstep;
	}


	public int getBinent() {
		return binent;
	}


	public void setBinent(int binent) {
		this.binent = binent;
	}


	public Timestamp getbDate() {
		return bdate;
	}


	public void setbDate(Timestamp bDate) {
		this.bdate = bDate;
	}


	public String getBupload() {
		return bupload;
	}


	public void setBupload(String bupload) {
		this.bupload = bupload;
	}


	public int getBhit() {
		return bhit;
	}


	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	
	
}
