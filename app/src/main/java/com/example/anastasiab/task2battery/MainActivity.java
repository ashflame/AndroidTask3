package com.example.anastasiab.task2battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    IntentFilter ifilter = new IntentFilter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ifilter.addAction(Intent.ACTION_POWER_CONNECTED);
        ifilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(mBatteryState, ifilter);
    }

    public void buttonOnClick(View v)
    {
        startActivity(new Intent(getApplicationContext(), BatteryActivity.class));
    }

    public void buttonOnClickGeo(View v)
    {
        startActivity(new Intent(getApplicationContext(), LocationActivity.class));
    }

    private BroadcastReceiver mBatteryState = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
                Toast.makeText(context, "Ваше устройство заряжается", Toast.LENGTH_SHORT).show();

            } else {
                intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED);
                Toast.makeText(context, "Ваше устройство разряжается", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
