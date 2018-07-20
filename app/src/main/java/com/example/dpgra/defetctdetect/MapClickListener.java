package com.example.dpgra.defetctdetect;

import android.app.Activity;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import model.Pothole;

public class MapClickListener implements GoogleMap.OnMarkerClickListener {

    private Activity activity;

    public MapClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Object o = marker.getTag();
        if ( o instanceof Pothole ) {
            String id = ((Pothole) o).getId();
            double lat = ((Pothole) o).getLat();
            double lon = ((Pothole) o).getLon();
            String latStr = String.format("%.4f", lat);
            String lonStr = String.format("%.4f", lon);
            Toast.makeText(activity, "Pothole Id: " + id + "\nLongitude: " + lonStr + "\nLatitude: " + latStr, Toast.LENGTH_LONG ).show();
        }
        return false;
    }
}
