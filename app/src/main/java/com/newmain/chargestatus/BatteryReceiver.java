package com.newmain.chargestatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.ImageView;
public class BatteryReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent){
        //  MainActivity obj = new MainActivity();

        ImageView imageView = ((FullscreenActivity)context).findViewById(R.id.imageView);
        int[] images = {R.drawable.battery,R.drawable.batterynot,R.drawable.batteryfull};
        String action = intent.getAction();
        if(action != null && action.equals(Intent.ACTION_BATTERY_CHANGED)){
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
            if(status == BatteryManager.BATTERY_STATUS_CHARGING){
                Log.i("Charging","Now");
                imageView.setImageResource(images[0]);
            }
            else if(status == BatteryManager.BATTERY_STATUS_FULL){
                Log.i("Charging","Full");
                imageView.setImageResource(images[2]);
            }
            else
            {
                Log.i("DisCharging","Then");
                imageView.setImageResource(images[1]);
            }
        }
    }
}
