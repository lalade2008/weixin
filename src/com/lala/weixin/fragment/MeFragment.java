package com.lala.weixin.fragment;

import com.lala.weixin.R;
import com.lala.weixin.R.id;
import com.lala.weixin.R.layout;
import com.lala.weixin.activity.CollectActivity;
import com.lala.weixin.activity.NearActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MeFragment extends Fragment {
	private View rootView;
	private TextView mTextView;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView=inflater.inflate(R.layout.mefragment, null);	
		mTextView=(TextView)rootView.findViewById(R.id.my_collect);
		mTextView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(getActivity(),CollectActivity.class);
				startActivity(intent);
			}
		});
		return rootView;
	}

}
