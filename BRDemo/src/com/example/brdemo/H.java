package com.example.brdemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class H extends Activity {
		
	public Button  btn2, btn3;
	private TextView tv1, tv2;
	Intent intent = new Intent();
	Bundle bundle = new Bundle();
	

	
	/*
	 * Intent iBzhu = new Intent();// �������� Intent iGyu = new Intent();// ���ڽ���
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lly);

		
		btn2 = (Button) findViewById(R.id.bt2);// �˳���ť
		btn3 = (Button) findViewById(R.id.bt3);// ���ð�ť

		tv1 = (TextView) findViewById(R.id.montext);// ʱ��
		tv2 = (TextView) findViewById(R.id.titletext);// ����
		registerForContextMenu(tv2);// �����Ĳ˵���ע��

		bundle = getIntent().getExtras();

		ActionBar actionBar = getActionBar();// ��ȡActionBar����
		actionBar.setDisplayShowHomeEnabled(true);// ��ʾӦ�ó���ͼ��
		actionBar.setDisplayHomeAsUpEnabled(true);// ��Ӧ�ó���ͼ��ת��Ϊ�ɵ��ͼ�꣬�����һ�����ؼ�ͷ��

		// ��Intent��ö�����Ϣ������ΪTextView���ı�
		// tv1.setText("��������ǣ�" + intent.getStringExtra("useName"));
		tv1.setText(bundle.getString("userName") + "," + "���Ϻã�");

		final Button  btn1 = (Button) findViewById(R.id.bt1);// ��ʼ��ť;
	    final PopupMenu pop = new PopupMenu(this, btn1);
	    pop.inflate(R.menu.popupmenu);
		// ��ʼ��ť
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
                pop.show();
				intent.setClass(H.this, CheckActivity.class);
				intent.addCategory(Intent.CATEGORY_APP_MUSIC);
				startActivity(intent);
				H.this.finish();

			}
		});
pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				// TODO Auto-generated method stub
				switch (arg0.getItemId()) {
				case R.id.menu_red:
					btn2.setBackgroundResource(R.drawable.bgfocus);
					btn1.setBackgroundResource(R.drawable.bgfocus);
					btn3.setBackgroundResource(R.drawable.bgfocus);
					break;
				case R.id.menu_green:
					btn2.setBackgroundResource(R.drawable.bgpress);
					btn1.setBackgroundResource(R.drawable.bgpress);
					btn3.setBackgroundResource(R.drawable.bgpress);
					break;
				case R.id.menu_blue:
					btn2.setBackgroundResource(R.drawable.bghover);
					btn1.setBackgroundResource(R.drawable.bghover);
					btn3.setBackgroundResource(R.drawable.bghover);
					break;
				default:
					break;
				}
				return false;
			}
		});
		// ������ť
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				H.this.finish();

			}
		});
		// ���ð�ť
		btn3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent.setClass(H.this, MainActivity.class);// ��ʱ������תΪ�����棬�����ý�����������ת
				intent.addCategory(Intent.CATEGORY_APP_MUSIC);
				startActivity(intent);
				H.this.finish();
			}
		});

	}

	// �������˵�
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	// ��������ʵ���¼�
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			// ����
			Intent i1 = new Intent(this, Help.class);
			startActivity(i1);
			break;
		case R.id.item2:
			// ���ڽ���
			Intent i2 = new Intent(this, About.class);
			startActivity(i2);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	// �����Ĳ˵��ı���
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.context, menu);
		menu.setHeaderTitle("��ѡ�񱳾���ɫ");

	}
	// �����Ĳ˵����¼�
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		item.setChecked(true);
		switch (item.getItemId()) {
		case R.id.red:
			item.setChecked(true);
			tv2.setBackgroundColor(Color.RED);
			break;
		case R.id.green:
			item.setChecked(true);
			tv2.setBackgroundColor(Color.GREEN);
			break;
		case R.id.blue:
			item.setChecked(true);
			tv2.setBackgroundColor(Color.BLUE);
			break;

		default:
			break;
		}
		return true;
	}

}