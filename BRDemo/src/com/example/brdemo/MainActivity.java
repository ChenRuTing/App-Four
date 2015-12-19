package com.example.brdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn1;
	private Button btn2; 
	private Button btn3;
	private EditText et1;
	private EditText et2;
	Intent iguangs, iches;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn1 = (Button) findViewById(R.id.b1);// ע��
		btn2 = (Button) findViewById(R.id.bt3);// ����
		btn3 = (Button) findViewById(R.id.b2);// ��¼

		et2 = (EditText) findViewById(R.id.editText2);
		et1 = (EditText) findViewById(R.id.editText1);

		// ע��
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				iguangs = new Intent();
				Bundle bundle = new Bundle();
				// ����Intent��class���ԣ���ת��SecondActivity
				iguangs.setClass(MainActivity.this, H.class);
				// Ϊintent��Ӷ������Ϣ
				bundle.putString("userName", et1.getText().toString());
				bundle.putString("phoneNum", et2.getText().toString());
				iguangs.putExtras(bundle);
				// ����Activity
				startActivity(iguangs);

			}
		});
		// ����
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://open.taobao.com");
				 iches = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(iches);
			}
		});
		// ��¼
		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				iguangs = new Intent();
				Bundle bundle = new Bundle();
				// ����Intent��class���ԣ���ת��SecondActivity
				iguangs.setClass(MainActivity.this, H.class);
				// Ϊintent��Ӷ������Ϣ
				bundle.putString("userName", et1.getText().toString());
				bundle.putString("phoneNum", et2.getText().toString());
				Toast.makeText(MainActivity.this, "�û�"+et1.getText() +"��¼�ɹ�", Toast.LENGTH_LONG).show();
				iguangs.putExtras(bundle);
				// ����Activity
				startActivity(iguangs);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

/*	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			// ��������MainActivity��Intent
			Intent intent = new Intent(this, MainActivity.class);
			// ��Ӷ����Flag����Activityջ�д���MainActivity֮�ϵ�Activity����
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case R.id.item1:
			Intent intent1 = new Intent(this, Help.class);
			startActivity(intent1);
			break;
		case R.id.item2:
			Intent intent2 = new Intent(this, Help.class);
			startActivity(intent1);
			break;
		case R.id.item2:
			Intent intent3 = new Intent(this, Help.class);
			startActivity(intent1);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}*/
}
