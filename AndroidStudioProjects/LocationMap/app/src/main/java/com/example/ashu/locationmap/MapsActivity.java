package com.example.ashu.locationmap;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback ,GoogleMap.OnMarkerDragListener,LocationListener{

    private GoogleMap mMap;
    int i = 0;
    LatLng lastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @SuppressLint("MissingPermission")
    private void attachLocationListener() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Location location = null;
        if (locationManager != null) {
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            lastLocation = new LatLng(location.getLatitude(),location.getLongitude());

        }
        if (locationManager != null) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000
                            ,100,this);
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;

        attachLocationListener();


        mMap.setOnMarkerDragListener(this);

    }


    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }

    @Override
    public void onLocationChanged(Location location) {

        LatLng currentLatLng = new LatLng(location.getLatitude(),location.getLongitude());
        Log.e("Location", "onLocationChanged: Longitude = "+location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions()
                .position(currentLatLng)
                .draggable(true);
        mMap.addMarker(markerOptions);
        mMap.animateCamera(CameraUpdateFactory.newLatLng(currentLatLng));
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(lastLocation,currentLatLng);
        mMap.addPolyline(polylineOptions);
        lastLocation = currentLatLng;

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
