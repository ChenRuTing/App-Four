package com.example.brdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
//ϵͳʹ��MediaPlayer�������֣��������mp
    private MediaPlayer mey;
    private String TAG="Main";
    @Override
    public IBinder onBind(Intent intent) { 
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
//��ʼ��MediaPlayer����׼���������֣������ļ������ļ���/res/raw��
        mey = MediaPlayer.create(MyService.this, R.raw.zhou);
	    Intent intent = new Intent();  
        intent.putExtra("control", 1);  
        sendBroadcast(intent);
        mey.start();
        Log.i(TAG, "MusicService onCreate������");
    }
    
  @Override
public int onStartCommand(Intent intent, int flags, int startId) {
	// TODO Auto-generated method stub
//��ʼ��������
	 mey.start();
	 Log.i(TAG, "MusicService onStartCommand������");
	 return super.onStartCommand(intent, flags, startId);
	
}

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ֹͣ��������
            mey.stop();
        Log.i(TAG, "MusicService onDestroy������");
    }

}