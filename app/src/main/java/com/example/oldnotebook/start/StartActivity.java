package com.example.oldnotebook.start;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.oldnotebook.login.LoginActivity;
import com.example.oldnotebook.utils.NoteUtil;

import cn.bmob.v3.Bmob;


public class StartActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences sp = getSharedPreferences(NoteUtil.SHARED_NAME, MODE_PRIVATE);
		
		Bmob.initialize(getApplicationContext(), "78b513daedf6fbec9c8f442a7a20c5d0");
		
		//暂时取消第一次启动画面
		boolean first_start = sp.getBoolean(NoteUtil.FIRST_START, false);
		Intent intent = new Intent();
		if(first_start){
			intent.setClass(this, AppIntroduce.class);
		}else {
			intent.setClass(this, LoginActivity.class);
		}
		
		startActivity(intent);
		this.finish();
	}
}
