package com.lala.weixin.adapter;

import java.util.List;

import com.lala.weixin.CollectModel;
import com.lala.weixin.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CollectAdapter extends BaseAdapter {
	List<CollectModel> mDatas;
	private ImageView colletFromIcon;
	private TextView colletFromName;
	private TextView colletItemTime;
	private ImageView colletItemIcon;
	private TextView colletItemDes;
	private TextView colletItemFrom;
	private LayoutInflater mInflater;

	public CollectAdapter( Context context) {
		// TODO Auto-generated constructor stub
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas==null  ? 0 :mDatas.size() ;
	}

	@Override
	public CollectModel getItem(int position) {
		// TODO Auto-generated method stub
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		View mView=mInflater.inflate(R.layout.collet_list_item, null);
		colletFromIcon=(ImageView)mView.findViewById(R.id.collet_from_icon);
		colletFromName=(TextView)mView.findViewById(R.id.collet_from_name);
		colletItemTime=(TextView)mView.findViewById(R.id.collet_item_time);
		colletItemIcon=(ImageView)mView.findViewById(R.id.collet_item_icon);
		colletItemDes=(TextView)mView.findViewById(R.id.collet_item_des);
		colletItemFrom=(TextView)mView.findViewById(R.id.collet_item_from);
		
		CollectModel model =getItem(position);
		colletFromIcon.setImageResource(model.getColletFromIcon());
		colletFromName.setText(model.getColletFromName());
		colletItemTime.setText(model.getColletItemTime());
		colletItemIcon.setImageResource(model.getColletItemIcon());
		colletItemDes.setText(model.getColletItemDes());
		colletItemFrom.setText(model.getColletItemFrom());
		
		return mView;
	}

	public void setData(List<CollectModel> datas) {
		// TODO Auto-generated method stub
		this.mDatas=datas;		
	}

}
