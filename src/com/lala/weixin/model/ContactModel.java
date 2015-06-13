package com.lala.weixin.model;

import java.util.List;

public class ContactModel {
	private String txt;
	private List<ContactItemModel> data;
	
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public List<ContactItemModel> getData() {
		return data;
	}
	public void setData(List<ContactItemModel> data) {
		this.data = data;
	}



}
