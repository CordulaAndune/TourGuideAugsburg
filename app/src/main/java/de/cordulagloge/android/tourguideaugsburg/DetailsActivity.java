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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailsActivity extends AppCompatActivity{

    private Places currentPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar detailsToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(detailsToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent placeIntent = getIntent();
        if (placeIntent != null)
        {
            currentPlace = placeIntent.getParcelableExtra("currentPlace");
        }
        else if(savedInstanceState != null){
            currentPlace = savedInstanceState.getParcelable("currentPlace");
        }
        else {
            currentPlace = new Places(R.string.empty_place, R.string.inner_city,
                    R.string.empty_place_description, R.drawable.augsburg_default, R.string.empty_place_link);
        }
        Log.i("onCreate",getString(currentPlace.getName()));
        actionBar.setTitle(currentPlace.getName());
        TextView link = findViewById(R.id.link);
        Spanned linkText = Html.fromHtml(getString(currentPlace.getLink()));
        link.setText(linkText);
        link.setMovementMethod(LinkMovementMethod.getInstance());

        TextView description = findViewById(R.id.description);
        description.setText(getString(currentPlace.getDescription()));

        ImageView image = findViewById(R.id.image);
        image.setImageResource(currentPlace.getImageResourceId());

        ImageButton mapButton = findViewById(R.id.map_button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(DetailsActivity.this, MapActivity.class);
                mapIntent.putExtra("currentPlace",currentPlace);
                startActivity(mapIntent);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelable("currentPlace",currentPlace);
    }
}
