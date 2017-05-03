package com.example.autotech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Selection extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// FullScreen Activity
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_selection);
		addListnerOnButton();
	}

	private void addListnerOnButton() {
		// TODO Auto-generated method stub
		ImageView imgButton1 = (ImageView) findViewById(R.id.imageView1);
		ImageView imgButton2 = (ImageView) findViewById(R.id.imageView2);
		ImageView imgButton3 = (ImageView) findViewById(R.id.imageView3);
		ImageView imgButton4 = (ImageView) findViewById(R.id.imageView4);
		ImageView imgButton5 = (ImageView) findViewById(R.id.imageView5);
		ImageView imgButton6 = (ImageView) findViewById(R.id.imageView6);
		ImageView imgButton7 = (ImageView) findViewById(R.id.imageView7);
		ImageView imgButton8 = (ImageView) findViewById(R.id.imageView8);

		imgButton1.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub

				Intent i = new Intent(Selection.this, AutoSilent.class);
				startActivity(i);

			}

		});
		imgButton2.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub

				Intent i2 = new Intent(Selection.this, AutoBluetooth.class);
				startActivity(i2);

			}
		});
		imgButton3.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub

				Intent i3 = new Intent(Selection.this, AutoWifi.class);
				startActivity(i3);

			}
		});
		imgButton4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub

				Intent i4 = new Intent(Selection.this, AutoBrightness.class);
				startActivity(i4);

			}
		});
		imgButton5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i5 = new Intent(Selection.this, MobileData.class);
				startActivity(i5);

			}
		});
		imgButton6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i6 = new Intent(Selection.this, BatteryStatus.class);
				startActivity(i6);

			}
		});
		imgButton7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i7 = new Intent(Selection.this, AboutUs.class);
				startActivity(i7);

			}

		});
		imgButton8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i8 = new Intent(Selection.this, Help.class);
				startActivity(i8);
			}

		});
	}

}
