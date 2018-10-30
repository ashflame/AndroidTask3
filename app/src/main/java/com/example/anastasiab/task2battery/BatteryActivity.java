package com.example.anastasiab.task2battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class BatteryActivity extends AppCompatActivity {

    IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        registerReceiver(mBatteryStateReceiver, ifilter);
    }

    private BroadcastReceiver mBatteryStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int status = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            progressBar.setProgress(status);
            //Toast.makeText(context, ("Ваш заряд: "+ Integer.toString(status)), Toast.LENGTH_SHORT).show();
        }
    };
}
