package de.cordulagloge.android.tourguideaugsburg;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActivitiesFragment extends Fragment {


    public ActivitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_places, container, false);

        final ArrayList<Places> sightsList = new ArrayList<>();
        sightsList.add(new Places(R.string.diocesan_museum, R.string.inner_city, R.string.diocesan_museum_description,R.drawable.augsburg_diocesan_museum, R.string.diocesan_museum_link));
        sightsList.add(new Places(R.string.fugger_welser_museum, R.string.inner_city, R.string.fugger_welser_museum_description,R.drawable.augsburg_fugger_welser_museum, R.string.fugger_welser_museum_link));
        sightsList.add(new Places(R.string.maximilian_museum, R.string.inner_city, R.string.maximilian_museum_description,R.drawable.augsburg_maximilianmuseum, R.string.maximilian_museum_link));
        sightsList.add(new Places(R.string.die_kiste, R.string.inner_city, R.string.die_kiste_description,R.drawable.augsburg_kiste, R.string.die_kiste_link));
        sightsList.add(new Places(R.string.walter_art_museum, R.string.spickel, R.string.walter_art_museum_description,R.drawable.augsburg_default, R.string.walter_art_museum_link));
        sightsList.add(new Places(R.string.textile_museum, R.string.spickel, R.string.textile_museum_description,R.drawable.augsburg_default, R.string.textile_museum_link));
        sightsList.add(new Places(R.string.augsburg_zoo, R.string.spickel, R.string.augsburg_zoo_description,R.drawable.augsburg_zoo, R.string.augsburg_zoo_link));
        sightsList.add(new Places(R.string.botanical_gardens, R.string.spickel, R.string.botanical_gardens_description,R.drawable.augsburg_botgardens, R.string.botanical_gardens_link));
        sightsList.add(new Places(R.string.climbing_forest_scherneck, R.string.scherneck, R.string.climbing_forest_scherneck_description,R.drawable.augsburg_climbin_forest, R.string.climbing_forest_scherneck_link));
        sightsList.add(new Places(R.string.football_golf, R.string.scherneck, R.string.football_golf_description,R.drawable.augsburg_soccerpark, R.string.football_golf_link));
        sightsList.add(new Places(R.string.titania, R.string.neusaess, R.string.titania_description,R.drawable.augsburg_titania, R.string.titania_link));
        sightsList.add(new Places(R.string.boulder_soccer_gersthofen, R.string.gersthofen, R.string.boulder_soccer_gersthofen_description,R.drawable.augsburg_default, R.string.boulder_soccer_gersthofen_link));

        ListView sightsListView = rootView.findViewById(R.id.listview);
        PlacesAdapter placesAdapter = new PlacesAdapter(getContext(),sightsList);
        sightsListView.setAdapter(placesAdapter);

        sightsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntent = new Intent(getContext(), DetailsActivity.class);
                detailIntent.putExtra("currentPlace",sightsList.get(i));
                startActivity(detailIntent);
            }
        });

        return rootView;
    }

}
