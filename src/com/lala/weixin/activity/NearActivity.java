package com.lala.weixin.activity;

import java.util.ArrayList;
import java.util.List;
import com.lala.weixin.NearbyModel;
import com.lala.weixin.R;
import com.lala.weixin.adapter.NearListAdapter;
import android.app.Activity;
import android.os.Bundle;
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
	
	
	Integer picId[]={R.drawable.near_item_icon1,R.drawable.near_item_icon2,R.drawable.near_item_icon3,R.drawable.near_item_icon4,R.drawable.near_item_icon5,R.drawable.near_item_icon6,R.drawable.near_item_icon7,R.drawable.near_item_icon8,R.drawable.near_item_icon9,R.drawable.near_item_icon10,R.drawable.near_item_icon11,R.drawable.near_item_icon12,R.drawable.near_item_icon12};
	String name[] ={"����","С��","Shut up","��������","����","����","��ʵ��","VS Wang","����","ţ��","�Ϻ�","����","��ɯ�ܵ繭���ֹ⻷"};
	Integer sexId[]={1,0,1,1,1,0,0,1,1,1,1,1,1};
	String distance[] ={"100������","100������","100������","200������","200������","200������","200������","500������","500������","500������","500������","500������","500������"};
	String description[] ={"12","���Ĺ���ÿһ�죡","�������Լ�����ġ�","�����ġ����á����䣬","2","3","5","8","�һ�һֱ���㣬ֱ����Ⱥ�п�����ı�Ӱ��","8","8","9","23"};
	private List<NearbyModel> getDatas() {
		List<NearbyModel> datas =new ArrayList<NearbyModel>();
		for(int i=0;i<name.length;i++){
			datas.add(getModel(i));			
		}
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

	
}
