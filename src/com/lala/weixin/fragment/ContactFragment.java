package com.lala.weixin.fragment;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.lala.weixin.R;
import com.lala.weixin.adapter.ContactListAdapter;
import com.lala.weixin.model.ContactModel;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

public class ContactFragment extends Fragment{
	private View rootView;
	private ExpandableListView expandableListView;
	private ContactListAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView=inflater.inflate(R.layout.contactfragment, null);	
		
		mAdapter=new ContactListAdapter(this.getActivity());
		List<ContactModel> datas =getDatas();
		//List<String> headGroup=getHeadGroup();
		
	
		mAdapter.setDatas(datas);
		//获取Map的json格式
		String json = JSON.toJSONString(datas,true); 
	    Log.d("test1", "json= "+json);
	    
		expandableListView = (ExpandableListView) rootView.findViewById(R.id.contact_list);
		//设置默认箭头不展示
		expandableListView.setGroupIndicator(null);
		expandableListView.setAdapter(mAdapter);
		//设置expandableListView默认全部展开
		for (int i = 0; i < datas.size(); i++) {
			expandableListView.expandGroup(i);
		}
				
		return rootView;
	}	
	
	
	private List<ContactModel> getDatas() {
//		Map<String, List<ContactItemModel>> datas= new HashMap<String, List<ContactItemModel>>();
		String json = null ;
		try {
			InputStream in =getResources().getAssets().open("contact_datas");
			byte[] buffer =new byte[in.available()];
			in.read(buffer);
			json = new String(buffer,"UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<ContactModel> datas=JSON.parseArray(json,ContactModel.class);

		return datas;
	}//fastjson转化文：//http://www.tuicool.com/articles/zUbQfa
	
	
	
	/*
	String headTxt[]={"","企业号","A","B","C"};
	String name[]={"新的朋友","群聊","标签","公众号"};
	String name1[]={"快乐时代"};
	String name2[]={"爱华","A应城","爱尔眼科"};
	String name3[]={"扁扁","疤痕就"};
	String name4[]={"陈爸","长安于滴"};
	Integer itempic[]={R.drawable.contact_item_pic01,R.drawable.contact_item_pic02,R.drawable.contact_item_pic03,R.drawable.contact_item_pic04};
	Integer itempic1[]={R.drawable.contact_item_pic};
	Integer itempic2[]={R.drawable.contact_item_pic11,R.drawable.contact_item_pic12,R.drawable.contact_item_pic13};
	Integer itempic3[]={R.drawable.contact_item_pic21,R.drawable.contact_item_pic22};
	Integer itempic4[]={R.drawable.contact_item_pic31,R.drawable.contact_item_pic32};
	
	private List<ContactModel> getDatas() {
		List<ContactModel> datas= new ArrayList<ContactModel>();	
		
		List<ContactItemModel> itemDatas =new ArrayList<ContactItemModel>();
		List<ContactItemModel> itemDatas1 =new ArrayList<ContactItemModel>();
		List<ContactItemModel> itemDatas2 =new ArrayList<ContactItemModel>();
		List<ContactItemModel> itemDatas3 =new ArrayList<ContactItemModel>();
		List<ContactItemModel> itemDatas4 =new ArrayList<ContactItemModel>();
		
		for(int i=0;i<name.length;i++){
			ContactItemModel model =new ContactItemModel();
			model.setName(name[i]);
			model.setPicId(itempic[i]);
			itemDatas.add(model);
		}	
		ContactModel modelData =new ContactModel();
		modelData.setData(itemDatas);
		modelData.setTxt(headTxt[0]);
		datas.add(modelData);
		
		for(int i=0;i<name1.length;i++){
			ContactItemModel model =new ContactItemModel();
			model.setName(name1[i]);
			model.setPicId(itempic1[i]);
			itemDatas1.add(model);
		}
		ContactModel modelData1 =new ContactModel();
		modelData1.setData(itemDatas1);
		modelData1.setTxt(headTxt[1]);
		datas.add(modelData1);
		
		for(int i=0;i<name2.length;i++){
			ContactItemModel model =new ContactItemModel();
			model.setName(name2[i]);
			model.setPicId(itempic2[i]);
			itemDatas2.add(model);
		}
		ContactModel modelData2 =new ContactModel();
		modelData2.setData(itemDatas2);
		modelData2.setTxt(headTxt[2]);
		datas.add(modelData2);
		
		for(int i=0;i<name3.length;i++){
			ContactItemModel model =new ContactItemModel();
			model.setName(name3[i]);
			model.setPicId(itempic3[i]);
			itemDatas3.add(model);
		}
		ContactModel modelData3 =new ContactModel();
		modelData3.setData(itemDatas3);
		modelData3.setTxt(headTxt[3]);
		datas.add(modelData3);
		
		for(int i=0;i<name4.length;i++){
			ContactItemModel model =new ContactItemModel();
			model.setName(name4[i]);
			model.setPicId(itempic4[i]);
			itemDatas4.add(model);
		}
		ContactModel modelData4 =new ContactModel();
		modelData4.setData(itemDatas4);
		modelData4.setTxt(headTxt[4]);
		datas.add(modelData4);		
				
	
		return datas;
	}*/	

}
