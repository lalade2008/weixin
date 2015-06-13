package com.lala.weixin.fragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lala.weixin.R;
import com.lala.weixin.R.id;
import com.lala.weixin.R.layout;
import com.lala.weixin.adapter.HomeListAdapter;
import com.lala.weixin.model.HomeModel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MainFragment extends Fragment{
	private View rootView;
	private ListView mListView;
	private HomeListAdapter mAdapter;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView=inflater.inflate(R.layout.mainfragment, null);	
		mListView=(ListView)rootView.findViewById(R.id.myweixin_list);
		//List<HomeModel> datas=getDatas();
		
		String json = null ;

		try {
			InputStream in = getResources().getAssets().open("home_datas");
			byte[] buffer =new byte[in.available()]; 
			in.read(buffer);
			json = new String(buffer,"UTF-8");
			Log.d("test-----", "json= "+json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (TextUtils.isEmpty(json)){
			
		}
		List<HomeModel> datas=JSON.parseArray(json,HomeModel.class);
		Log.d("test-----", "datas= "+datas);
		
		mAdapter=new HomeListAdapter(this.getActivity());
		mAdapter.setAdapterDatas(datas);
		mListView.setAdapter(mAdapter);
		return rootView;
	}
	
	/*
	Integer PicId[]={R.drawable.itme_icon1,R.drawable.itme_icon2,R.drawable.itme_icon3,R.drawable.itme_icon4,R.drawable.itme_icon5,R.drawable.itme_icon6,R.drawable.itme_icon7,R.drawable.itme_icon8,R.drawable.itme_icon9};
	String name[] ={"腾讯企业邮箱","微信团队","文件传输助手","订阅号","腾讯新闻","QAAQ","微信支付","e洗袋","凯撒旅游"};
	String msg[] ={"腾讯企业邮箱：新邮件通知","欢迎你再次回到微信，如果你在使用过程中有任何问题或建议，记得给我发信反馈哦。","[图片]","广发分享日:【广发卡20周年】你爱谁！点击进入查看详情","吉林警方接头持枪抓捕嫌犯","www.qufenqi.com","支付成功通知","【授尼泊尔和西藏地区】爱心不分大小，参与即是公益","为了过好小假期，我们也是蛮拼的！"};
	String time[] ={"下午14:57","下午14:35","下午14:22","下午14:01","早上08:14","15/4/27","15/4/27","15/4/25","15/4/22"};	
	
	private List<HomeModel> getDatas() {
		List<HomeModel> datas =new ArrayList<HomeModel>();
		for(int i=0;i<name.length;i++){
			datas.add(getModel(i));			
		}
		return datas;
	}
	private HomeModel getModel(int i) {
		HomeModel model =new HomeModel();			
		model.setPicId(PicId[i]);
		model.setName(name[i]);
		model.setTime(time[i]);
		model.setMsg(msg[i]);
		return model;
	}	
	*/



}
