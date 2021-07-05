package com.example.myisi;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.myisi.databinding.FragmentUniversityBinding;

public class UniversityFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FragmentUniversityBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_university, container, false);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
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

        // Add a marker in Sydney and move the camera
        LatLng isi = new LatLng(14.68633321270179, -17.454885603452546);
        mMap.addMarker(new MarkerOptions().position(isi).title("ISI").snippet("Contact : +221338221981 Site : https://www.groupeisi.com/"));

        LatLng ucad = new LatLng(14.68633321270179, -17.454885603452546);
        mMap.addMarker(new MarkerOptions().position(ucad).title("UCAD").snippet("Contact : +221784946215 Site : https://www.ucad.snm/"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(isi,12));

        CircleOptions co = new CircleOptions()
                            .center(isi)
                            .radius(500)
                            .fillColor(Color.BLUE)
                            .strokeColor(Color.BLACK)
                            .strokeWidth(5);

        mMap.addCircle(co);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                if(marker.getTitle().equals("ISI")){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:768529988"));
                    startActivity(intent);
                }
                else{

                    if(marker.getTitle().equals("ISI")){
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:768529988"));
                        intent.putExtra("sms_body", "Bonsoir M1GL, A bientôt pour le voyage");
                        startActivity(intent);
                    }
                }
                return false;
            }
        });

    }
}