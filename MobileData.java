package com.example.autotech;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MobileData extends Activity {
	static final int TIME_DIALOG_ID11 = 1111;
	static final int TIME_DIALOG_ID22 = 111;
	int hour, minute;
	Calendar e;
	Button b, c;
	TextView t1, t2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_mobile_data);

		e = Calendar.getInstance();

		hour = e.get(Calendar.HOUR_OF_DAY);
		minute = e.get(Calendar.MINUTE);
		b = (Button) findViewById(R.id.bb1);
		t1 = (TextView) findViewById(R.id.textView1);
		t2 = (TextView) findViewById(R.id.textView2);
		{
			b.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					showDialog(TIME_DIALOG_ID11);
				}

			});
		}
		c = (Button) findViewById(R.id.bb2);
		c.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog(TIME_DIALOG_ID22);
			}

		});
	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID11:

			// set time picker as current time
			return new TimePickerDialog(this, timePickerListener, hour, minute,
					false);

		case TIME_DIALOG_ID22:
			return new TimePickerDialog(this, timePickerListener1, hour,
					minute, false);

		}
		return null;
	}

	private TimePickerDialog.OnTimeSetListener timePickerListener1 = new TimePickerDialog.OnTimeSetListener() {
		Calendar calendar = Calendar.getInstance();

		@Override
		public void onTimeSet(TimePicker arg0, int h1, int m1) {
			// TODO Auto-generated method stub
			hour = h1;
			minute = m1;

			Intent intent1 = new Intent(MobileData.this,
					MobileDataBroadcast3.class);
			PendingIntent sender = PendingIntent.getBroadcast(MobileData.this,
					0, intent1, 0);
			Calendar calNow = Calendar.getInstance();
			Calendar calSet = (Calendar) calNow.clone();

			calSet.set(Calendar.HOUR_OF_DAY, h1);
			calSet.set(Calendar.MINUTE, minute);
			calSet.set(Calendar.SECOND, 0);
			calSet.set(Calendar.MILLISECOND, 0);
			
			if(calSet.compareTo(calNow) <= 0){
				//Today Set time passed, count to tomorrow
				calSet.add(Calendar.DATE, 1);
			}
            
			AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
			am.set(AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(), sender);

			t2.setText("will end on " + h1 + ":" + m1);
		}
	};
	private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {

		Calendar calendar = Calendar.getInstance();

		@Override
		public void onTimeSet(TimePicker arg0, int h1, int m1) {
			// TODO Auto-generated method stub
			hour = h1;
			minute = m1;

			Intent intent1 = new Intent(MobileData.this,
					MobileDataBroadcast4.class);
			PendingIntent sender = PendingIntent.getBroadcast(MobileData.this,
					0, intent1, 0);

			Calendar calNow = Calendar.getInstance();
			Calendar calSet = (Calendar) calNow.clone();
			calSet.set(Calendar.HOUR_OF_DAY, h1);
			calSet.set(Calendar.MINUTE, minute);
			calSet.set(Calendar.SECOND, 0);
			calSet.set(Calendar.MILLISECOND, 0);
			
			if(calSet.compareTo(calNow) <= 0){
				//Today Set time passed, count to tomorrow
				calSet.add(Calendar.DATE, 1);
			}
            
			AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
			am.set(AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(), sender);

			t1.setText("will start on " + h1 + ":" + m1);
		}

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mobile_data, menu);
		return true;
	}

}
