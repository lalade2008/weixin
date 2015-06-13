package com.lala.weixin;

import com.lala.weixin.fragment.ContactFragment;
import com.lala.weixin.fragment.FindFragment;
import com.lala.weixin.fragment.MainFragment;
import com.lala.weixin.fragment.MeFragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {
	private ViewPager mViewPager;
	private TextView tab_weixin;
	private TextView tab_contact;
	private TextView tab_find;
	private TextView tab_me;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		tab_weixin=(TextView)findViewById(R.id.tab_weixin);
		tab_contact=(TextView)findViewById(R.id.tab_contact);
		tab_find=(TextView)findViewById(R.id.tab_find);
		tab_me=(TextView)findViewById(R.id.tab_me);
		tab_weixin.setOnClickListener(this);
		tab_contact.setOnClickListener(this);
		tab_find.setOnClickListener(this);
		tab_me.setOnClickListener(this);
		TitleHelper mTitleHelper =new TitleHelper();
		mTitleHelper.init(MainActivity.this,false,"微信");
		mViewPager=(ViewPager)findViewById(R.id.ViewPager);
		mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
	}	
	
	private class ViewPagerAdapter extends FragmentPagerAdapter{

		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			Fragment mFragment = null;
			if(position==0){
				mFragment=new MainFragment();
			}
			if(position==1){
				mFragment=new ContactFragment();
			}
			if(position==2){
				mFragment=new FindFragment();
	
			}
			if(position==3){
				mFragment=new MeFragment();
	
			}
			return mFragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 4;
		}		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tab_weixin:
			mViewPager.setCurrentItem(0, false);
			changeTabIcon(0);
			break;
		case R.id.tab_contact:
			mViewPager.setCurrentItem(1, false);
			changeTabIcon(1);
			break;
		case R.id.tab_find:
			mViewPager.setCurrentItem(2, false);
			changeTabIcon(2);
			break;
		case R.id.tab_me:
			mViewPager.setCurrentItem(3, false);
			changeTabIcon(3);
			break;	

		default:
			break;
		}
		
	}
	private void changeTabIcon(int position){
		if(position==0){
			changeTabIcon(R.drawable.wx_onicon,tab_weixin);
			tabTextColor(0,tab_weixin);
		}else {
			changeTabIcon(R.drawable.wx_icon,tab_weixin);
			tabTextColor(1,tab_weixin);
		}
		if(position==1){
			changeTabIcon(R.drawable.contact_onicon,tab_contact);
			tabTextColor(0,tab_contact);
		}else {
			changeTabIcon(R.drawable.contact_icon,tab_contact);
			tabTextColor(1,tab_contact);
		}
		if(position==2){
			changeTabIcon(R.drawable.find_onicon,tab_find);
			tabTextColor(0,tab_find);
		}else {
			changeTabIcon(R.drawable.find_icon,tab_find);
			tabTextColor(1,tab_find);
		}
		if(position==3){
			changeTabIcon(R.drawable.me_onicon,tab_me);
			tabTextColor(0,tab_me);
		}else {
			changeTabIcon(R.drawable.me_icon,tab_me);
			tabTextColor(1,tab_me);
		}		
	}
	private void tabTextColor(int i, TextView tabName) {
		// TODO Auto-generated method stub

		if(i==0){			
			tabName.setTextColor(Color.parseColor("#45c01a"));
		}else{
			tabName.setTextColor(Color.parseColor("#999999"));
		}		
	}
	private void changeTabIcon(int icon, TextView tabName) {
		// TODO Auto-generated method stub
		Drawable mIcon=getResources().getDrawable(icon);
		mIcon.setBounds(0, 0, mIcon.getMinimumWidth(), mIcon.getMinimumHeight());
		tabName.setCompoundDrawables(null, mIcon, null, null); 		
	}	
}
