package com.example.ashu.location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {
    public static final int LOCATION_REQUEST_CODE = 1234;
    TextView mLatitudeTv,mLongitudeTv,mSpeedTv,mAltitudeTv;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLatitudeTv = findViewById(R.id.latitudeTv);
        mLongitudeTv = findViewById(R.id.longitudeTv);
        mSpeedTv = findViewById(R.id.speedTv);
        mAltitudeTv = findViewById(R.id.altitudeTv);


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);


        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_REQUEST_CODE);

        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,100, this);


        }





    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LOCATION_REQUEST_CODE) {
            //This means the onRequestPermissionsResult method was called when user initiated
            //permission for location, so handle the case accordingly.

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,100, this);

                Toast.makeText(this, "Thank you for granting the permissions!", Toast.LENGTH_SHORT).show();
                //Now we have the permission, so do the actual processing here

            } else {
                Toast.makeText(this,
                        "Sorry, but I need the permissions for the app to work!",
                        Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == 12) {
            //Some other permission request resulted in this callback, so handle that
        }

    }

    @Override
    public void onLocationChanged(Location location) {

        Log.e("OnLocationChanged", "onLocationChanged: " + location.getLongitude() );

        mLatitudeTv.setText("Latitude : "+location.getLatitude());
        mLongitudeTv.setText("Longitude : "+location.getLongitude());
        mAltitudeTv.setText("ALtitude : "+location.getAltitude());
        mSpeedTv.setText("Speed : "+location.getSpeed());

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
