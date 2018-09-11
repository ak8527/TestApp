package com.example.ashu.sensor;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements SensorEventListener{
    TextView textView1,textView2,textView3;
    LinearLayout linearLayout;
    SensorManager sensorManager;
    Sensor typeStepDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        PackageManager pm = getPackageManager();
        if (pm.hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_COUNTER)) {
            // the awesome stuff here
            Log.e("OnFunction", "onCreate: "+123456);
            typeStepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        } else {
            Log.e("OnFunction", "onCreate: "+123456);

        }

//        Sensor gravityDefault = null;
//        if (sensorManager != null) {
//            gravityDefault = sensorManager.getDefaultSensor(Sensor.ty);
//        }

         linearLayout = findViewById(R.id.llView);

        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor s : sensors){
            Log.e("Sensor", "onCreate: "+s.toString() );
            Log.e("Sensor", "No. of sensor : "+sensors.size() );
        }

//        if (sensorManager != null) {
//            sensorManager.registerListener(this,typeStepDetector,SensorManager.SENSOR_DELAY_UI);
//        }

        sensorManager.registerListener(this,sensorManager.getDefaultSensor(18),SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int r,g,b;
    //  float[] valArray = event.values;
//      if(valArray[0]<255 && valArray[0]>0)
//          r1= (int) valArray[0] ;
//      if(valArray[1]<255 && valArray[1]>0)
//          g= (int) valArray[1];
//      if(valArray[2]<255 && valArray[2]>0)
//          b= (int) valArray[2];
//      textView1.setText(""+);
//      textView2.setText(""+valArray[1]);
//      textView3.setText(""+valArray[2]);

//        r = (int) (Math.abs(valArray[0])/9.8*255);
//        g =(int) (Math.abs(valArray[1])/9.8*255);
//        b = (int) (Math.abs(valArray[2])/9.8*255);
//


//
//     int color = Color.rgb(r,g,b);
//     linearLayout.setBackgroundColor(color);


        Sensor sense = event.sensor;


        Log.e("MainActivity", "onSensorChanged: "+sense.getName() );

        float[] value = event.values;

        Log.e("MainActivity", "onSensorChanged: "+value[0] );
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
