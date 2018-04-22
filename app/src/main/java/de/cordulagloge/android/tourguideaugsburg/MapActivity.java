package de.cordulagloge.android.tourguideaugsburg;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Places currentPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // set up toolbar
        Toolbar detailsToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(detailsToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent placeIntent = getIntent();
        if (placeIntent != null) {
            currentPlace = placeIntent.getParcelableExtra("currentPlace");
        } else if (savedInstanceState != null) {
            currentPlace = savedInstanceState.getParcelable("currentPlace");
        } else {
            currentPlace = new Places(R.string.empty_place, R.string.inner_city,
                    R.string.empty_place_description, R.drawable.augsburg_default, R.drawable.augsburg_default_small, R.string.empty_place_link);
        }

        actionBar.setTitle(currentPlace.getName());

        //SupportFragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        double[] currentCoordinates = currentPlace.getMapLink();
        LatLng currentMarkerPosition = new LatLng(currentCoordinates[0], currentCoordinates[1]);
        googleMap.addMarker(new MarkerOptions()
                .position(currentMarkerPosition)
                .title(getString(currentPlace.getName())));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentMarkerPosition,16.0f));
    }

    /**
     *  Conteol up button behaviour: send current Place to parent (Detail)Activity
     * @param item clicked item on the toolbar
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent detailIntent = NavUtils.getParentActivityIntent(this);
                detailIntent.putExtra("currentPlace", currentPlace);
                NavUtils.navigateUpTo(this, detailIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
