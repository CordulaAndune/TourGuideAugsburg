package de.cordulagloge.android.tourguideaugsburg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private Places currentPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar detailsToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(detailsToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent placeIntent = getIntent();
        if (placeIntent != null) {
            currentPlace = placeIntent.getParcelableExtra("currentPlace");
        } else if (savedInstanceState != null) {
            currentPlace = savedInstanceState.getParcelable("currentPlace");
        } else {
            currentPlace = new Places(R.string.empty_place, R.string.inner_city,
                    R.string.empty_place_description, R.drawable.augsburg_default, R.drawable.augsburg_default_small, R.string.empty_place_link);
        }
        assert actionBar != null;
        actionBar.setTitle(currentPlace.getName());
        TextView link = findViewById(R.id.link);
        Spanned linkText = Html.fromHtml(getString(currentPlace.getLink()));
        link.setText(linkText);
        link.setMovementMethod(LinkMovementMethod.getInstance());

        TextView description = findViewById(R.id.description);
        description.setText(getString(currentPlace.getDescription()));

        ImageButton mapButton = findViewById(R.id.map_button);
        ImageView image = findViewById(R.id.image);
        if (currentPlace.checkForImage()) {
            image.setImageResource(currentPlace.getImageResourceId());
        } else {
            image.setVisibility(View.GONE);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mapButton.getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            mapButton.setLayoutParams(params);
        }

        if (currentPlace.checkForMapLink()) {
            mapButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mapIntent = new Intent(DetailsActivity.this, MapActivity.class);
                    mapIntent.putExtra("currentPlace", currentPlace);
                    startActivity(mapIntent);
                }
            });
        } else {
            mapButton.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelable("currentPlace", currentPlace);
    }
}
