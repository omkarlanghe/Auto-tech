package com.example.autotech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;

public class ExploreNow extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// FullScreen Activity
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_explore_now);

		addListnerOnButton();
	}

	private void addListnerOnButton() {
		// TODO Auto-generated method stub
		RadioButton button1 = (RadioButton) findViewById(R.id.radioButton1);
		RadioButton button2 = (RadioButton) findViewById(R.id.radioButton2);
		RadioButton button3 = (RadioButton) findViewById(R.id.radioButton3);
		RadioButton button4 = (RadioButton) findViewById(R.id.radioButton4);
		RadioButton button5 = (RadioButton) findViewById(R.id.radioButton5);
		RadioButton button6 = (RadioButton) findViewById(R.id.radioButton6);

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i1 = new Intent(ExploreNow.this, ExploreSilent.class);
				startActivity(i1);
			}
		});

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i2 = new Intent(ExploreNow.this, ExploreBlue.class);
				startActivity(i2);
			}
		});

		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i3 = new Intent(ExploreNow.this, ExploreWifi.class);
				startActivity(i3);
			}
		});

		button4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i4 = new Intent(ExploreNow.this, ExploreBright.class);
				startActivity(i4);
			}
		});

		button5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i5 = new Intent(ExploreNow.this, ExploreMobile.class);
				startActivity(i5);
			}
		});

		button6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i6 = new Intent(ExploreNow.this, ExploreBattery.class);
				startActivity(i6);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.explore_now, menu);
		return true;
	}

}
