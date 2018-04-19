package de.cordulagloge.android.tourguideaugsburg;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        /*Toolbar detailsToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(detailsToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);*/

        //SupportFragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

       /* Intent placeIntent = getIntent();
        Places currentPlace;
        if (placeIntent != null) {
            currentPlace = placeIntent.getParcelableExtra("currentPlace");
        }
        else {
            currentPlace = new Places(R.string.empty_place, R.string.inner_city,
                    R.string.empty_place_description, R.drawable.augsburg_default, R.string.empty_place_link);
        }

        actionBar.setTitle(currentPlace.getName());
        TextView link = findViewById(R.id.link);
        Spanned linkText = Html.fromHtml(getString(currentPlace.getLink()));
        link.setText(linkText);
        link.setMovementMethod(LinkMovementMethod.getInstance());

        TextView description = findViewById(R.id.description);
        description.setText(getString(currentPlace.getDescription()));

        ImageView image = findViewById(R.id.image);
        image.setImageResource(currentPlace.getImageResourceId());*/
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng augsburg = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions()
                .position(augsburg)
                .title("Augsburg"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(augsburg));
    }
}
