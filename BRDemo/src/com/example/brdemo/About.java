package com.example.brdemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class About extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		ActionBar actionBar = getActionBar();// ��ȡActionBar����
		actionBar.setDisplayShowHomeEnabled(true);// ��ʾӦ�ó���ͼ��
		actionBar.setDisplayHomeAsUpEnabled(true);// ��Ӧ�ó���ͼ��ת��Ϊ�ɵ��ͼ�꣬�����һ�����ؼ�ͷ��
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			//��������MainActivity��Intent
			Intent iabout=new Intent();
			iabout.setClass(this,H.class);
			//��Ӷ����Flag����Activityջ�д���MainActivity֮�ϵ�Activity����
			iabout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(iabout);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
