package com.example.ashu.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()){

            case Intent.ACTION_AIRPLANE_MODE_CHANGED :
                Toast.makeText(context,"Airplane Mode",Toast.LENGTH_LONG).show();
                break;
            case Intent.ACTION_POWER_CONNECTED :
                Toast.makeText(context,"Power Connected")
        }



    }
}
