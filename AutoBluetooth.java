package com.example.autotech;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class AutoBluetooth extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto_bluetooth);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.auto_bluetooth, menu);
		return true;
	}

}
