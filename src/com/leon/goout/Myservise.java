package com.leon.goout;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class Myservise extends Service {
	static final String TAG = "LocalService";

	@Override
	public void onCreate() {

		Toast.makeText(this, "サービス起動", Toast.LENGTH_SHORT).show();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		Toast.makeText(this, "サービス開始", Toast.LENGTH_SHORT).show();
		// 明示的にサービスの起動、停止が決められる場合の返り値
		return START_STICKY;
	}

	@Override
	public void onDestroy() {

		Toast.makeText(this, "サービ終了", Toast.LENGTH_SHORT).show();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
}
