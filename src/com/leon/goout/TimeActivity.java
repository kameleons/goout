package com.leon.goout;

import java.io.IOException;
import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class TimeActivity extends Activity {
	int time = 0;
	int min = 0;
	int hour;
	int x = 0;
	int z;
	TextView text;
	MediaPlayer mp;

	SharedPreferences prefs;
	TextView text2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time);
		prefs = getSharedPreferences("goout", Context.MODE_PRIVATE);
		z = prefs.getInt("ƒSƒ~", 0);
		text = (TextView) findViewById(R.id.textView1);
		text2 = (TextView) findViewById(R.id.textView2);
		if (z == 1) {
			text2.setText("•µˆÍ‹C‚ğ‰ó‚·");
			mp = MediaPlayer.create(this, R.drawable.clash);
		} else if (z == 2) {
			text2.setText("‰Âˆ¤‚¢H");
			mp = MediaPlayer.create(this, R.drawable.chime);
		} else if (z == 3) {
			text2.setText("–ü‚µŒn");
			mp = MediaPlayer.create(this, R.drawable.hiil);
		}

		try {
			mp.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void m1(View v) {
		if (x == 0) {

			min = min + 1;
			time = time + 1000 * 60;
			if (min >= 60) {
				min = min - 60;
				hour = hour + 1;
			}
			if (hour == 0) {
				text.setText(String.valueOf(min) + "•ª");
			} else {
				text.setText(String.valueOf(hour) + "ŠÔ" + String.valueOf(min)
						+ "•ª");
			}
		}
	}

	public void m5(View v) {
		if (x == 0) {

			min = min + 5;
			time = time + 1000 * 60 * 5;
			if (min >= 60) {
				min = min - 60;
				hour = hour + 1;
			}
			if (hour == 0) {
				text.setText(String.valueOf(min) + "•ª");
			} else {
				text.setText(String.valueOf(hour) + "ŠÔ" + String.valueOf(min)
						+ "•ª");
			}
		}
	}

	public void m10(View v) {
		if (x == 0) {

			min = min + 10;
			time = time + 1000 * 60 * 10;
			if (min >= 60) {
				min = min - 60;
				hour = hour + 1;
			}
			if (hour == 0) {
				text.setText(String.valueOf(min) + "•ª");
			} else {
				text.setText(String.valueOf(hour) + "ŠÔ" + String.valueOf(min)
						+ "•ª");
			}
		}
	}

	public void m15(View v) {
		if (x == 0) {

			min = min + 15;
			time = time + 1000 * 60 * 15;
			if (min >= 60) {
				min = min - 60;
				hour = hour + 1;
			}
			if (hour == 0) {
				text.setText(String.valueOf(min) + "•ª");
			} else {
				text.setText(String.valueOf(hour) + "ŠÔ" + String.valueOf(min)
						+ "•ª");
			}
		}
	}

	public void m30(View v) {
		if (x == 0) {

			time = time + 1000 * 60 * 30;
			min = min + 30;
			if (min >= 60) {
				min = min - 60;
				hour = hour + 1;
			}
			if (hour == 0) {
				text.setText(String.valueOf(min) + "•ª");
			} else {
				text.setText(String.valueOf(hour) + "ŠÔ" + String.valueOf(min)
						+ "•ª");
			}
		}

	}

	public void h1(View v) {
		if (x == 0) {

			time = time + 1000 * 60 * 60;
			hour = hour + 1;

			if (hour == 0) {
				text.setText(String.valueOf(min) + "•ª");
			} else {
				text.setText(String.valueOf(hour) + "ŠÔ" + String.valueOf(min)
						+ "•ª");
			}
		}
	}

	public void ok(View v) {
		startService(new Intent(TimeActivity.this, Myservise.class));

		if (x == 0) {

			Calendar calendar = Calendar.getInstance();
			int hour2 = calendar.get(Calendar.HOUR_OF_DAY);
			int min2 = calendar.get(Calendar.MINUTE);
			hour2 = hour2 + hour;
			min2 = min2 + min;

			if (min2 >= 60) {
				min2 = min2 - 60;
				hour2 = hour2 + 1;
			}
			if (hour2 >= 24) {
				hour2 = hour2 - 24;
			}

			text.setText(String.valueOf(hour2) + "" + String.valueOf(min2)
					+ "•ª‚ÉÄ¶‚³‚ê‚Ü‚·");

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					text.setText("Ä¶’†");
					mp.start();
					new Handler().postDelayed(new Runnable() {
						@Override
						public void run() {
							/*
							 * mp.release(); finish();
							 */
						}
					}, 10000);
				}
			}, time);
			x = 1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mp.release();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.time, menu);
		return true;
	}

}
