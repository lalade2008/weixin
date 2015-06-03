package com.lala.weixin.adapter;

import java.util.List;

import com.lala.weixin.NearbyModel;
import com.lala.weixin.R;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NearListAdapter extends BaseAdapter{
	LayoutInflater mInflater;
	List<NearbyModel> mDatas;
	

	public NearListAdapter(Context context) {
		// TODO Auto-generated constructor stub
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas == null ? 0 : mDatas.size();
	}

	@Override
	public NearbyModel getItem(int position) {
		// TODO Auto-generated method stub
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(convertView==null){
			Log.d("test", "null-----"+position);
			convertView =mInflater.inflate(R.layout.near_list_itme, null);
			holder=new ViewHolder();
			holder.picId=(ImageView)convertView.findViewById(R.id.near_item_icon);
			holder.name=(TextView)convertView.findViewById(R.id.near_item_name);
			holder.sexId=(ImageView)convertView.findViewById(R.id.near_item_sex);
			holder.description=(TextView)convertView.findViewById(R.id.near_item_description);
			holder.distance=(TextView)convertView.findViewById(R.id.near_item_distance);
			convertView.setTag(holder);			
		}
		else{
			Log.d("test", "1111----"+position);
			holder =(ViewHolder)convertView.getTag();
		}		
		
		NearbyModel model =getItem(position);
		
		holder.picId.setImageResource(model.getPicId());
		holder.name.setText(model.getName());
		holder.sexId.setImageResource(model.getSexId());
		holder.description.setText(model.getDescription());
		holder.distance.setText(model.getDistance());
		if(TextUtils.isEmpty(holder.description.getText().toString())){
			holder.description.setVisibility(View.GONE);
		}
		return convertView;
	}

	public void setAdapterDatas(List<NearbyModel> datas) {
		// TODO Auto-generated method stub
		this.mDatas=datas;		
	}
	private class ViewHolder{
		ImageView picId;
		TextView name;
		ImageView sexId;
		TextView distance;
		TextView description;
	}

}
