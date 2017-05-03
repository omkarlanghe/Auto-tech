package com.example.autotech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class AboutUs extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// FullScreen Activity
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_about_us);

			addListnerOnButton();
		}
	

	private void addListnerOnButton() {
		// TODO Auto-generated method stub
		ImageView imgButton1 = (ImageView) findViewById(R.id.imgView);
		
		imgButton1.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub

				Intent i = new Intent(AboutUs.this, SimpleBrowser.class);
				startActivity(i);

			}

		});

		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about_us, menu);
		return true;
	}

}
