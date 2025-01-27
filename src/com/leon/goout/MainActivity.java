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
		text.setText("曲を選択してください");
	}

	public void clash(View v) {
		text.setText("雰囲気を壊す系の曲");
		x = 1;
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("ゴミ", x);
		editor.commit();
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.setClass(MainActivity.this, TimeActivity.class);
		startActivity(intent);
		finish();
	}

	public void cute(View v) {
		x = 2;
		text.setText("かわいい系の曲");
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("ゴミ", x);
		editor.commit();
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.setClass(MainActivity.this, TimeActivity.class);
		startActivity(intent);
		finish();
	}

	public void iyasi(View v) {
		x = 3;
		text.setText("癒し系の曲");
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("ゴミ", x);
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
