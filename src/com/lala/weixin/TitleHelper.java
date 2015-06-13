package com.lala.weixin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class TitleHelper {
	private TextView nameText;
	private ImageButton searchButton;
	private ImageButton addButton;
	private ImageButton backButton;
	private View line;
	private ListView mListView;
	List<Map<Integer, String>> moreList; 
	public void init(final Activity activity,Boolean back,String titleName) {
		// TODO Auto-generated method stub
		backButton=(ImageButton)activity.findViewById(R.id.back);
		line =(View)activity.findViewById(R.id.line);
		nameText =(TextView)activity.findViewById(R.id.titlename);
		searchButton =(ImageButton)activity.findViewById(R.id.search);
		addButton =(ImageButton)activity.findViewById(R.id.more);
		if(!back){
			backButton.setVisibility(View.GONE);
			line.setVisibility(View.GONE);
		}else{
			backButton.setOnClickListener(new OnClickListener() {				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					activity.finish();
				}
			});
		}
		nameText.setText(titleName);
		searchButton.setBackgroundResource(R.drawable.search);
		addButton.setBackgroundResource(R.drawable.add);
		addButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				LayoutInflater inflater =activity.getLayoutInflater();
				View mView=inflater.inflate(R.layout.title_more_pop, null);
				mListView =(ListView)mView.findViewById(R.id.more_list);				
				SimpleAdapter adapter = new SimpleAdapter(activity,getDatas(),R.layout.more_list_item,new String[]{"itempic","itemname"},new int[]{R.id.more_item_pic,R.id.more_item_name});
				mListView.setAdapter(adapter);
				PopupWindow pop =new PopupWindow(mView,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
				pop.setFocusable(true);// 加上这个popupwindow中的ListView才可以接收点击事件
				pop.setTouchable(true);
				pop.setOutsideTouchable(true);
				pop.setBackgroundDrawable(new ColorDrawable(0));
				pop.showAsDropDown(activity.findViewById(R.id.main_title),500, 0);

			}
		});		
		
	}
	Integer pic[]={R.drawable.groupchat,R.drawable.addfriend,R.drawable.scan,R.drawable.help} ;
	String name[]={"发起群聊","添加朋友","扫一扫","帮助与反馈"};	
	private List<Map<String, Object>> getDatas() {  
		List< Map<String, Object>> mDatas =new ArrayList<Map<String,Object>>();		
		for(int i=0;i<name.length;i++){			 
	        mDatas.add(setMap(i));
		}	
		return mDatas;
    }
	private Map<String, Object> setMap(int i) {
		// TODO Auto-generated method stub
		Map<String,Object> hashmap = new HashMap<String,Object>();
		hashmap.put("itempic",pic[i]); 
	    hashmap.put("itemname",name[i]); 	       
		return hashmap;
	}
	
	

}
