package com.anil.chargestatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import me.itangqi.waveloadingview.WaveLoadingView;


public class BatteryReceiver extends BroadcastReceiver{



    @Override
    public void onReceive(Context context, Intent intent){
        WaveLoadingView waveLoadingView = ((FullscreenActivity)context).findViewById(R.id.waveLoadingView);
        TextView tv = ((FullscreenActivity)context).findViewById(R.id.chargeStatus);
        String action = intent.getAction();
        TextView bp = ((FullscreenActivity)context).findViewById(R.id.batteryPercent);
        ImageView imageView = ((FullscreenActivity)context).findViewById(R.id.imageView);
        if(action != null && action.equals(Intent.ACTION_BATTERY_CHANGED)){
            int percent = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            bp.setText(Integer.toString(percent) + "%");if(percent < 30){
            waveLoadingView.setWaveColor(-65536);
            }
            else{
                waveLoadingView.setWaveColor(-8586240);
            }
            waveLoadingView.setProgressValue((percent));
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
            if(status == BatteryManager.BATTERY_STATUS_CHARGING){
                Log.i("Charging","Now");
                imageView.setVisibility(imageView.VISIBLE);
                tv.setText("Charging");
            }
            else if(status == BatteryManager.BATTERY_STATUS_FULL){
                Log.i("Charging","Full");
                tv.setText("Battery Full");
            }
            else
            {
                Log.i("DisCharging","Then");
                imageView.setVisibility(imageView.INVISIBLE);
                tv.setText("Discharging");
            }
        }
    }
}