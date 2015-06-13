package com.lala.weixin.adapter;

import java.util.List;
import com.lala.weixin.R;
import com.lala.weixin.model.ContactModel;

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
	List<ContactModel> datas;


	public ContactListAdapter(Context context) {
		// TODO Auto-generated constructor stub
		mInflater=LayoutInflater.from(context);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub

		Log.d("test", "getChild"+datas.get(groupPosition).getData().get(childPosition));
		return datas.get(groupPosition).getData().get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		Log.d("test", "childPosition="+childPosition);
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

		int picId =datas.get(groupPosition).getData().get(childPosition).getPicId();
		String name =datas.get(groupPosition).getData().get(childPosition).getName();
				
				
		itemHolder.itemImg.setBackgroundResource(picId);
		itemHolder.itemTxt.setText(name);
		

		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition ) {
		// TODO Auto-generated method stub	

		Log.d("test", "datas.get(groupPosition).getData().size()="+datas.get(groupPosition).getData().size());
		return datas.get(groupPosition).getData()==null ? 0 : datas.get(groupPosition).getData().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		Log.d("test", "group.get(groupPosition)="+datas.get(groupPosition));
		return datas.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		Log.d("test", "group.size()="+datas.size());
		return datas==null ? 0 : datas.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		Log.d("test", "groupPosition="+groupPosition);
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
		String txt =datas.get(groupPosition).getTxt();
//		if(txt==""){
//			groupHolder.headTxt.setVisibility(View.GONE);
//		}
		groupHolder.headTxt.setText(txt);
		
		
		//设置Group不可点击
		convertView.setClickable(true);
		
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


	class GroupHolder {
		  public TextView headTxt;
	}
		 
	class ItemHolder {
		  public ImageView itemImg;
		  public TextView itemTxt;
	}

	public void setDatas(List<ContactModel> datas) {
		// TODO Auto-generated method stub
		this.datas=datas;
	}


}
