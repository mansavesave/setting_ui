package com.example.camerasettingui;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public class MainActivity extends Activity {
	MainSetting mMainSetting;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("wellsTest", "+onCreate");
		setContentView(R.layout.activity_main);
		mMainSetting = new MainSetting(this);
		printScreenWidth();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void printScreenWidth() {
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		float density = getResources().getDisplayMetrics().density;
		Log.d("wellsTest", "width:" + width + ", height:" + height + ", density:" + density);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			if (mMainSetting.isShow()) {
				mMainSetting.hide();
			} else {
				mMainSetting.show();
			}
			test();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void test() {
		ViewGroup.LayoutParams params = findViewById(android.R.id.tabs).getLayoutParams();
		Log.d("wellsTest", "params:" + params);
	}
}
