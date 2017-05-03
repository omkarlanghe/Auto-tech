package com.example.autotech;

import java.io.IOException;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BatteryStatus extends Activity {
	private TextView batteryPercent;
	private TextView brightLevel;
	// broadcast class is used as a nested class
	private BroadcastReceiver mbcr = new BroadcastReceiver() {
		// onReceive method will receive updates
		public void onReceive(Context c, Intent i) {
			// initially level has 0 value
			// after getting update from broadcast receiver
			// it will change and give battery status

			int level = i.getIntExtra("level", 0);
			// initialize all objects
			ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar1);
			TextView tv = (TextView) findViewById(R.id.textView1);
			// set level of progress bar
			pb.setProgress(level);
			// display level on text view
			tv.setText(" * Batterylevel:" + Integer.toString(level) + "%");
			// start a song when the battery level touches 100%
			if (level == 100) {
				try {
					// Save small.mp4 in assets folder
					// we can not start a media file from the drawable folder
					// directly in broadcast method
					// hence we used the assets folder
					AssetFileDescriptor afd = getAssets().openFd("small.mp4");
					MediaPlayer mp = new MediaPlayer();
					// set file and starting point and ending point in bytes
					mp.setDataSource(afd.getFileDescriptor(),
							afd.getStartOffset(), afd.getLength());
					mp.prepare();
					// start song
					mp.start();
				} catch (IOException e) {
				}
			}
		}
	};

	private void getBatteryPercentage() {
		// TODO Auto-generated method stub
		BroadcastReceiver batteryLevelReceiver = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				context.unregisterReceiver(this);
				int currentLevel = intent.getIntExtra(
						BatteryManager.EXTRA_LEVEL, -1);
				int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
				int level2 = -1;
				if (currentLevel >= 0 && scale > 0) {
					level2 = (currentLevel * 100) / scale;
				}
				System.out.println("...................Ok");
				int curBrightnessValue = android.provider.Settings.System
						.getInt(getContentResolver(),
								android.provider.Settings.System.SCREEN_BRIGHTNESS,
								-1);
				System.out.println("......................Checking");
				batteryPercent.setText(" * Battery Level Remaining:" + level2
						+ "%");
				brightLevel.setText(" * Brightness Level is: "
						+ curBrightnessValue + "%");
				System.out.println("...................Checking done");

			}

		};
		IntentFilter batteryLevelFilter = new IntentFilter(
				Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(batteryLevelReceiver, batteryLevelFilter);
	}

	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// FullScreen Activity
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// set layout
		setContentView(R.layout.activity_battery_status);
		// register broadcast receiver
		// Get battery changed status
		// we can get more options like power connect, disconnect, call, etc.
		// To get more options, write Intent followed by a dot(.) and press
		// CTRL+Space
		// you will get all the options
		batteryPercent = (TextView) findViewById(R.id.textView3);
		brightLevel = (TextView) findViewById(R.id.textView4);
		getBatteryPercentage();

		registerReceiver(mbcr, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	}
}
