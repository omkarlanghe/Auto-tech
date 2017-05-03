package com.example.autotech;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class AutoSilent extends Activity {
	DateFormat d;
	Button b, f;
	Calendar h;
	TextView e, g;
	int hour, minute, ehour, eminute;
	Calendar c;
	
	static final int TIME_DIALOG_ID = 1111;
	static final int TIME_DIALOG_ID1 = 111;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto_silent);
		h = Calendar.getInstance();

		hour = h.get(Calendar.HOUR_OF_DAY);
		minute = h.get(Calendar.MINUTE);
		b = (Button) findViewById(R.id.b1);
		e = (TextView) findViewById(R.id.tv1);
		g = (TextView) findViewById(R.id.txt1);

		// registerReceiver(receiver,
		// new IntentFilter(AudioManager.RINGER_MODE_CHANGED_ACTION));

		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(TIME_DIALOG_ID);
				Toast.makeText(getBaseContext(), "Start activity at",
						Toast.LENGTH_SHORT).show();

			}
		});

		f = (Button) findViewById(R.id.btn1);
		f.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(TIME_DIALOG_ID1);
				Toast.makeText(getBaseContext(), "ends activity at",
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID:
			// start time dialog

			return new TimePickerDialog(this, timePickerListener,
					hour,minute, false);
		case TIME_DIALOG_ID1:

			// end time dialog
			return new TimePickerDialog(this, timePickerListener1,
					hour,minute, false);
		}
		return null;
	}

	private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {

		Calendar calendar = Calendar.getInstance();

		@Override
		public void onTimeSet(TimePicker arg0, int h1, int m1) {
			// TODO Auto-generated method stub
			hour = h1;
			minute = m1;

			Intent intent = new Intent(AutoSilent.this, Broadcast1.class);
			PendingIntent sender = PendingIntent.getBroadcast(AutoSilent.this,
					0, intent, 0);
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
            

			g.setText("will start on " + h1 + ":" + m1);
		}

	};

	
	private TimePickerDialog.OnTimeSetListener timePickerListener1 = new TimePickerDialog.OnTimeSetListener() {

		Calendar calendar = Calendar.getInstance();

		@Override
		public void onTimeSet(TimePicker arg0, int h1, int m1) {
			// TODO Auto-generated method stub
			hour = h1;
			minute = m1;

			Intent intent1 = new Intent(AutoSilent.this, Broadcast2.class);
			PendingIntent sender = PendingIntent.getBroadcast(AutoSilent.this,
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

			e.setText("will end on " + h1 + ":" + m1);
		}

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.auto_silent, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public static void call(Context c2) {
		// TODO Auto-generated method stub
		Toast.makeText(c2, "scilent", Toast.LENGTH_LONG).show();
	}

}
