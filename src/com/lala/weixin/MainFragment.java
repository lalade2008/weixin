package com.lala.weixin;



import java.util.ArrayList;
import java.util.List;

import com.lala.weixin.adapter.HomeListAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
		List<HomeModel> datas=getDatas();
		mAdapter=new HomeListAdapter(this.getActivity());
		mAdapter.setAdapterDatas(datas);
		mListView.setAdapter(mAdapter);
		return rootView;
	}
	
	
	Integer PicId[]={R.drawable.itme_icon1,R.drawable.itme_icon2,R.drawable.itme_icon3,R.drawable.itme_icon4,R.drawable.itme_icon5,R.drawable.itme_icon6,R.drawable.itme_icon7,R.drawable.itme_icon8,R.drawable.itme_icon9};
	String name[] ={"��Ѷ��ҵ����","΢���Ŷ�","�ļ���������","���ĺ�","��Ѷ����","QAAQ","΢��֧��","eϴ��","��������"};
	String msg[] ={"��Ѷ��ҵ���䣺���ʼ�֪ͨ","��ӭ���ٴλص�΢�ţ��������ʹ�ù��������κ�������飬�ǵø��ҷ��ŷ���Ŷ��","[ͼƬ]","�㷢������:���㷢��20���꡿�㰮˭���������鿴����","���־�����ͷ��ǹץ���ӷ�","www.qufenqi.com","֧���ɹ�֪ͨ","�����Ჴ�������ص��������Ĳ��ִ�С�����뼴�ǹ���","Ϊ�˹���С���ڣ�����Ҳ����ƴ�ģ�"};
	String time[] ={"����14:57","����14:35","����14:22","����14:01","����08:14","15/4/27","15/4/27","15/4/25","15/4/22"};	
	
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



}
