package com.lala.weixin.adapter;

import java.util.List;

import com.lala.weixin.R;
import com.lala.weixin.model.HomeModel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeListAdapter extends BaseAdapter {
	LayoutInflater mInflater;
	List<HomeModel> mDatas;
	public HomeListAdapter(Context context) {
		mInflater=LayoutInflater.from(context);
		// TODO Auto-generated constructor stub
	}
	public void setAdapterDatas(List<HomeModel> datas){
		this.mDatas=datas;		
	}



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas == null ? 0 : mDatas.size();
	}

	@Override
	public HomeModel getItem(int position) {
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
			convertView =mInflater.inflate(R.layout.myweixin_list_item, null);
			holder=new ViewHolder();
			holder.icon=(ImageView)convertView.findViewById(R.id.item_icon);
			holder.name=(TextView)convertView.findViewById(R.id.item_name);
			holder.time=(TextView)convertView.findViewById(R.id.item_time);
			holder.msg=(TextView)convertView.findViewById(R.id.item_msg);
			convertView.setTag(holder);
		}
		else{
			Log.d("test", "1111----"+position);
			holder =(ViewHolder)convertView.getTag();
		}
		
		
		HomeModel model =getItem(position);
		int id =model.getPicId();
		Log.d("test","picid="+id );
		
		
		holder.icon.setImageResource(model.getPicId());
		holder.name.setText(model.getName());
		holder.time.setText(model.getTime());
		holder.msg.setText(model.getMsg());
		return convertView;
		

	}
	private class ViewHolder{
		ImageView icon;
		TextView name;
		TextView time;
		TextView msg;
	}
}
