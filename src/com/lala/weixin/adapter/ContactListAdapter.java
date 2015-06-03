package com.lala.weixin.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

public class ContactListAdapter extends BaseExpandableListAdapter {
	LayoutInflater mInflater;
	private List<String> head_list;
	private List<List<String>> item_list_txt;
	private List<List<Integer>> item_list_pic;



	public ContactListAdapter(Context context) {
		// TODO Auto-generated constructor stub
		mInflater=LayoutInflater.from(context);
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
			ViewGroup arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return head_list.size();
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setDatas(List<String> head_list,
			List<List<String>> item_list_txt, List<List<Integer>> item_list_pic) {
		// TODO Auto-generated method stub
		this.head_list=head_list;
		this.item_list_pic=item_list_pic;
		this.item_list_txt=item_list_txt;
		
	}

}
