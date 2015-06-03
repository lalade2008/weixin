package com.lala.weixin;

import java.util.ArrayList;
import java.util.List;

import com.lala.weixin.adapter.ContactListAdapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

public class ContactFragment extends Fragment{
	private View rootView;
	private ExpandableListView expandableListView;
	private List<String> head_list;
	private List<List<String>> item_list_txt;
	private List<List<Integer>> item_list_pic;
	private ContactListAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView=inflater.inflate(R.layout.contactfragment, null);	
		//head_list=new ArrayList<String>();
		head_list=getHeadList();
		item_list_txt=getItemTxt();
		item_list_pic=getItemPic();
		
		mAdapter=new ContactListAdapter(this.getActivity());
		mAdapter.setDatas(head_list,item_list_txt,item_list_pic);
		expandableListView = (ExpandableListView) rootView.findViewById(R.id.contact_list);
		expandableListView.setAdapter(mAdapter);

		
		return rootView;
	}	
	
	String headTxt[]={"A","B","C","D","E","F","G","H","I","J"};
	String itemTxt1[]={"爱华","A应城","爱尔眼科"};
	String itemTxt2[]={"扁扁"};
	String itemTxt3[]={"陈爸","长安于滴"};
	Integer itempic1[]={R.drawable.contact_item_pic1,R.drawable.contact_item_pic1,R.drawable.contact_item_pic1};
	Integer itempic2[]={R.drawable.contact_item_pic1};
	Integer itempic3[]={R.drawable.contact_item_pic1,R.drawable.contact_item_pic1};

	private List<String> getHeadList() {
		List<String> mList =new ArrayList<String>();
		for(int i=0;i< headTxt.length;i++){
			mList.add(headTxt[i]);
		}
		return mList;
	}
	private List<List<Integer>> getItemPic() {
		List<List<Integer>> mListPic =new ArrayList<List<Integer>>();
		mListPic.add(getPicItem(itempic1));
		return mListPic;
	}

	private List<Integer> getPicItem(Integer[] itempic) {
		// TODO Auto-generated method stub
		List<Integer> mListPicItem =new ArrayList<Integer>();
		for(int i=0;i< itempic.length;i++){
			mListPicItem.add(itempic[i]);
		}
		return mListPicItem;
	}
	private List<List<String>> getItemTxt() {
		List<List<String>> mListTxt =new ArrayList<List<String>>();
		mListTxt.add(getTxtItem(itemTxt1));
		mListTxt.add(getTxtItem(itemTxt2));
		mListTxt.add(getTxtItem(itemTxt3));
		
		return mListTxt;
	}
	private List<String> getTxtItem(String[] itemTxt) {
		// TODO Auto-generated method stub
		List<String> mListTxtItem =new ArrayList<String>();
		for(int i=0;i< itemTxt.length;i++){
			mListTxtItem.add(itemTxt[i]);
		}
		return mListTxtItem;
	}

}
