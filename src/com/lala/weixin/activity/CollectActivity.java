package com.lala.weixin.activity;

import java.util.ArrayList;
import java.util.List;

import com.lala.weixin.CollectModel;
import com.lala.weixin.R;
import com.lala.weixin.TitleHelper;
import com.lala.weixin.adapter.CollectAdapter;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CollectActivity extends Activity {
	private ListView mListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.collet);
		TitleHelper mTitleHelper =new TitleHelper();
		mTitleHelper.init(CollectActivity.this,true,"我的收藏");
		CollectAdapter adapter =new CollectAdapter(this);
		mListView=(ListView)findViewById(R.id.collet_list);
		List<CollectModel> datas =getData();
		adapter.setData(datas);
		mListView.setAdapter(adapter);
		
	}
	
	
	
	Integer colletFromIcon[]={R.drawable.collet_from_icon1,R.drawable.collet_from_icon2,R.drawable.collet_from_icon3,R.drawable.collet_from_icon1};
	String colletFromName[]={"小娜","无线技术圈","小娜","无线技术圈"};
	String colletItemTime[]={"15/4/4","15/3/16","15/3/14","15/3/4"};
	Integer colletItemIcon[]={R.drawable.collet_item_icon1,R.drawable.collet_item_icon2,R.drawable.collet_item_icon3,R.drawable.collet_item_icon4};
	String colletItemDes[]={"omniCommonUI框架","HTTP协议详解","曝光Facebook内部高效工作PPT指南","测试工程师手册：挑战与机遇"};
	String colletItemFrom[]={"QQ","cnblogs.com","职说","程序猿"};
	private List<CollectModel> getData() {
		// TODO Auto-generated method stub
		
		List<CollectModel> mDatas = new ArrayList<CollectModel>(); ;
		for(int i=0;i<colletFromIcon.length;i++){
			mDatas.add(getModel(i));			
		}		
		return mDatas;
	}
	private CollectModel getModel(int i) {
		// TODO Auto-generated method stub
		CollectModel model=new CollectModel();
		model.setColletFromIcon(colletFromIcon[i]);
		model.setColletFromName(colletFromName[i]);
		model.setColletItemDes(colletItemDes[i]);
		model.setColletItemFrom(colletItemFrom[i]);
		model.setColletItemIcon(colletItemIcon[i]);
		model.setColletItemTime(colletItemTime[i]);
		return model;
	}

}
