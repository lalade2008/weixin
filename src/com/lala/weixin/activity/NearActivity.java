package com.lala.weixin.activity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lala.weixin.R;
import com.lala.weixin.adapter.NearListAdapter;
import com.lala.weixin.model.NearbyModel;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;

public class NearActivity extends Activity {
	private ImageView mImageView;
	private ListView mListView;
	private NearListAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.near);
		mListView=(ListView)findViewById(R.id.near_list);
		mAdapter= new NearListAdapter(this);
		List<NearbyModel> datas =getDatas();
		mAdapter.setAdapterDatas(datas);
		mListView.setAdapter(mAdapter);		
		
		mImageView=(ImageView)findViewById(R.id.back);		
		mImageView.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	private List<NearbyModel> getDatas() {
		// TODO Auto-generated method stub
		String json = null;
		List<NearbyModel> datas =new ArrayList<NearbyModel>();
		try {
			InputStream in =getResources().getAssets().open("nearby_datas");
			byte[] buffer = new byte[in.available()];
			in.read(buffer);
			json=new String(buffer,"UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datas =JSON.parseArray(json, NearbyModel.class);
		return datas;
	}
	
	
	
	
	
	
	/*
	Integer picId[]={R.drawable.near_item_icon1,R.drawable.near_item_icon2,R.drawable.near_item_icon3,R.drawable.near_item_icon4,R.drawable.near_item_icon5,R.drawable.near_item_icon6,R.drawable.near_item_icon7,R.drawable.near_item_icon8,R.drawable.near_item_icon9,R.drawable.near_item_icon10,R.drawable.near_item_icon11,R.drawable.near_item_icon12,R.drawable.near_item_icon12};
	String name[] ={"无聊","小娜","Shut up","明天会更好","王涛","海洋","老实人","VS Wang","黑马","牛昆","紫涵","死神","阿莎受电弓黑手光环"};
	Integer sexId[]={1,0,1,1,1,0,0,1,1,1,1,1,1};
	String distance[] ={"100米以内","100米以内","100米以内","200米以内","200米以内","200米以内","200米以内","500米以内","500米以内","500米以内","500米以内","500米以内","500米以内"};
	String description[] ={"12","用心过好每一天！","生活是自己创造的。","曾经的“美好”回忆，","2","3","5","8","我会一直想你，直到人群中看到你的背影。","8","8","9","23"};
	private List<NearbyModel> getDatas() {
		List<NearbyModel> datas =new ArrayList<NearbyModel>();
		for(int i=0;i<name.length;i++){
			datas.add(getModel(i));			
		}
		//将List datas转化为json格式
		return datas;
	}
	private NearbyModel getModel(int i){
		NearbyModel model = new NearbyModel();
		model.setPicId(picId[i]);
		model.setName(name[i]);
		if (sexId[i]==0){
			model.setSexId(R.drawable.sex_women);
		}else model.setSexId(R.drawable.sex_men);	

		model.setDistance(distance[i]);
		model.setDescription(description[i]);
		return model;
	}
	*/

	
}
