package com.leon.goout;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class Myservise extends Service {
	static final String TAG = "LocalService";

	@Override
	public void onCreate() {

		Toast.makeText(this, "�T�[�r�X�N��", Toast.LENGTH_SHORT).show();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		Toast.makeText(this, "�T�[�r�X�J�n", Toast.LENGTH_SHORT).show();
		// �����I�ɃT�[�r�X�̋N���A��~�����߂���ꍇ�̕Ԃ�l
		return START_STICKY;
	}

	@Override
	public void onDestroy() {

		Toast.makeText(this, "�T�[�r�I��", Toast.LENGTH_SHORT).show();
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
}
