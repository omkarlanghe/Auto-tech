package com.example.autotech;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.widget.Toast;

public class bluet extends BroadcastReceiver{
	BluetoothAdapter b;

	@Override
	public void onReceive(final Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		b = BluetoothAdapter.getDefaultAdapter();
		if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action)) {
			Toast.makeText(context, "disconnected", Toast.LENGTH_LONG).show();
				//SystemClock.sleep(2000);
			if(b.isEnabled())
			
			context.startActivity(new Intent(BluetoothAdapter.ACTION_STATE_CHANGED));
			slp s=new slp();
			s.start();
				
			// Device is now connected
		}

		NetworkInfo info = intent
				.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
		if(info!=null){
		 if(info.isConnectedOrConnecting()){

				Toast.makeText(context, "Autotech enableed", Toast.LENGTH_LONG).show();

			} else {
				//SystemClock.sleep(2000);
				
				WifiManager m = (WifiManager) 
				context.getSystemService(Context.WIFI_SERVICE);
				
				m.setWifiEnabled(false);
			}
		}
				
	
		
	

	
	
	
		/*
		 * if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
		 * if(intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 0) ==
		 * BluetoothAdapter.STATE_OFF){ Toast.makeText(context,
		 * "bluetooth of",Toast.LENGTH_LONG).show(); }} if
		 * (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
		 * if(intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1) ==
		 * BluetoothAdapter.STATE_ON){ Toast.makeText(context,
		 * "bluetooth on",Toast.LENGTH_LONG).show(); }} if
		 * (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
		 * if(intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 0) ==
		 * BluetoothAdapter.STATE_CONNECTED){ Toast.makeText(context,
		 * "connected ",Toast.LENGTH_LONG).show(); // catch
		 * (InterruptedException e) /* {
		 * 
		 * // TODO Auto-generated catch block
		 * b=BluetoothAdapter.getDefaultAdapter();
		 * 
		 * Toast.makeText(context,"cannot wait",Toast.LENGTH_LONG).show();
		 * 
		 * 
		 * } b.disable(); Toast.makeText(context,
		 * "bluetooth of",Toast.LENGTH_LONG).show(); }
		 * 
		 * if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
		 * if(intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 0) ==
		 * BluetoothAdapter.STATE_CONNECTED){ Toast.makeText(context,
		 * "dicc ",Toast.LENGTH_LONG).show(); } } } }
		 */
	}
}
class slp extends Thread{
	BluetoothAdapter b;
	public void run(){
		Thread g=new Thread(){
			public void run(){
				try {
					SystemClock.sleep(5000);
					b.disable();
					//Toast.makeText(MainActivity,"dissabled",Toast.LENGTH_LONG).show();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//Toast.makeText(, "cannot wait",Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
				
			}
		};
		g.start();
	
	}
}
