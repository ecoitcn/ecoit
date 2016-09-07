package com.example.xuexi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {

	private IntentFilter intentFilter;
	private NetworkChangeReceiver networkChangeReceiver;

	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_second);
		Intent intent = getIntent();
		Log.v("test", intent.getStringExtra("test"));
		intent.putExtra("data_return", "test result");
		setResult(RESULT_OK, intent);
		button = (Button) findViewById(R.id.button_1);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onDestroy() {
//		super.onDestroy();
		unregisterReceiver(networkChangeReceiver);
	}

	class NetworkChangeReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(
					Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isAvailable()) {
				Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
				Log.v("test", "network is availavle");
			} else {
				Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
				Log.v("test", "network is unavailable");
			}
		}
	}
}
