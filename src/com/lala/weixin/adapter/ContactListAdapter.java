package com.lala.weixin.adapter;

import java.util.List;

import com.lala.weixin.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactListAdapter extends BaseExpandableListAdapter {
	LayoutInflater mInflater;
	private List<String> head_list;
	private List<List<String>> item_list_txt;
	private List<List<Integer>> item_list_pic;
	private ImageView itemImg;
	private TextView itemTxt;



	public ContactListAdapter(Context context) {
		// TODO Auto-generated constructor stub
		mInflater=LayoutInflater.from(context);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return item_list_txt.get(groupPosition).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		// TODO Auto-generated method stub
		ItemHolder itemHolder;
		if(convertView==null){
			convertView=mInflater.inflate(R.layout.contact_itemlist, null);
			itemHolder=new ItemHolder();
			itemHolder.itemImg=(ImageView) convertView.findViewById(R.id.contact_item_pic);
			itemHolder.itemTxt=(TextView) convertView.findViewById(R.id.contact_item_txt);
			convertView.setTag(itemHolder);
		}else{
			itemHolder=(ItemHolder) convertView.getTag();
		}
		itemHolder.itemImg.setBackgroundResource(item_list_pic.get(groupPosition).get(childPosition));
		itemHolder.itemTxt.setText(item_list_txt.get(groupPosition).get(childPosition));

		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition ) {
		// TODO Auto-generated method stub
		Log.d("test-----", "groupPosition="+groupPosition+"   size="+item_list_txt.get(groupPosition).size());
		return item_list_txt.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return head_list.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return head_list.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		GroupHolder groupHolder ;
		if(convertView==null){
			convertView=mInflater.inflate(R.layout.contact_headlist, null);
			groupHolder=new GroupHolder();
			groupHolder.headTxt=(TextView)convertView.findViewById(R.id.contact_head_txt);
			convertView.setTag(groupHolder);
		}else{
			groupHolder=(GroupHolder)convertView.getTag();
		}
		
		groupHolder.headTxt.setText(head_list.get(groupPosition));
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

	public void setDatas(List<String> head_list,
			List<List<String>> item_list_txt, List<List<Integer>> item_list_pic) {
		// TODO Auto-generated method stub
		this.head_list=head_list;
		this.item_list_pic=item_list_pic;
		this.item_list_txt=item_list_txt;
		
	}
	class GroupHolder {
		  public TextView headTxt;
	}
		 
	class ItemHolder {
		  public ImageView itemImg;
		  public TextView itemTxt;
	}


}
