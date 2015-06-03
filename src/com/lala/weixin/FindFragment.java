package com.lala.weixin;

import com.lala.weixin.activity.NearActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class FindFragment extends Fragment{
	private View rootView;
	private TextView mTextViewNear;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView=inflater.inflate(R.layout.findfragment, null);	
		mTextViewNear=(TextView)rootView.findViewById(R.id.find_more_friend_near);
		mTextViewNear.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(getActivity(),NearActivity.class);
				startActivity(intent);
			}
		});
		
		return rootView;
	}

}
