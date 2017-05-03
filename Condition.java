package com.example.autotech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Condition extends Activity {
	ProgressBar pgr;
	int progress = 0;
	Handler h = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// FullScreen Activity
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.condition);
		pgr = (ProgressBar) findViewById(R.id.progressBar1);
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++) {
					progress += 20;
					h.post(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							pgr.setProgress(progress);
							if (progress == pgr.getMax()) {
								// pgr.setVisibility(4);
								//Toast.makeText(getApplicationContext(), progress,1000).show();
								Intent i = new Intent(
										"com.example.autotech.SELECTION");
								startActivity(i);

							}
						}

					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

					}
				}
			}
		}).start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();

	}
}