package com.leon.goout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	int x = 0;
	SharedPreferences prefs;
	TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		prefs = getSharedPreferences("goout", Context.MODE_PRIVATE);
		setContentView(R.layout.activity_main);
		SharedPreferences prefs = getSharedPreferences("goout",
				Context.MODE_PRIVATE);
		text = (TextView) findViewById(R.id.textView1);
		text.setText("�Ȃ�I�����Ă�������");
	}

	public void clash(View v) {
		text.setText("���͋C���󂷌n�̋�");
		x = 1;
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("�S�~", x);
		editor.commit();
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.setClass(MainActivity.this, TimeActivity.class);
		startActivity(intent);
		finish();
	}

	public void cute(View v) {
		x = 2;
		text.setText("���킢���n�̋�");
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("�S�~", x);
		editor.commit();
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.setClass(MainActivity.this, TimeActivity.class);
		startActivity(intent);
		finish();
	}

	public void iyasi(View v) {
		x = 3;
		text.setText("�����n�̋�");
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("�S�~", x);
		editor.commit();
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.setClass(MainActivity.this, TimeActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
