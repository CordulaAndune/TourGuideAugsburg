package de.cordulagloge.android.tourguideaugsburg;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
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
        sightsList.add(new Places(R.string.diocesan_museum, R.string.inner_city, R.string.diocesan_museum_description,
                R.drawable.augsburg_diocesan_museum, R.drawable.augsburg_diocesan_museum_small
                , R.string.diocesan_museum_link, new double[]{48.3731748, 10.895744700000023}));
        sightsList.add(new Places(R.string.fugger_welser_museum, R.string.inner_city, R.string.fugger_welser_museum_description,
                R.drawable.augsburg_fugger_welser_museum, R.drawable.augsburg_fugger_welser_museum_small
                , R.string.fugger_welser_museum_link, new double[]{48.374082, 10.900385000000028}));
        sightsList.add(new Places(R.string.maximilian_museum, R.string.inner_city, R.string.maximilian_museum_description,
                R.drawable.augsburg_maximilianmuseum, R.drawable.augsburg_maximilianmuseum_small,
                R.string.maximilian_museum_link, new double[]{48.3678219, 10.896409199999994}));
        sightsList.add(new Places(R.string.die_kiste, R.string.inner_city, R.string.die_kiste_description,
                R.drawable.augsburg_kiste, R.drawable.augsburg_kiste_small
                , R.string.die_kiste_link, new double[]{48.3603417, 10.90338870000005}));
        sightsList.add(new Places(R.string.walter_art_museum, R.string.spickel, R.string.walter_art_museum_description,
                R.drawable.augsburg_default, R.drawable.augsburg_default_small
                , R.string.walter_art_museum_link, new double[]{48.36722, 10.919490099999962}));
        sightsList.add(new Places(R.string.textile_museum, R.string.spickel, R.string.textile_museum_description,
                R.drawable.augsburg_default, R.drawable.augsburg_default_small,
                R.string.textile_museum_link, new double[]{48.363538, 10.913008699999978}));
        sightsList.add(new Places(R.string.augsburg_zoo, R.string.spickel, R.string.augsburg_zoo_description,
                R.drawable.augsburg_zoo, R.drawable.augsburg_zoo_small,
                R.string.augsburg_zoo_link, new double[]{48.3468233, 10.91471249999995}));
        sightsList.add(new Places(R.string.botanical_gardens, R.string.spickel, R.string.botanical_gardens_description,
                R.drawable.augsburg_botgardens, R.drawable.augsburg_botgardens_small
                , R.string.botanical_gardens_link, new double[]{48.349505, 10.915032999999994}));
        sightsList.add(new Places(R.string.climbing_forest_scherneck, R.string.scherneck, R.string.climbing_forest_scherneck_description,
                R.drawable.augsburg_climbin_forest, R.drawable.augsburg_climbin_forest_small
                , R.string.climbing_forest_scherneck_link, new double[]{48.480098, 10.929304000000002}));
        sightsList.add(new Places(R.string.football_golf, R.string.scherneck, R.string.football_golf_description,
                R.drawable.augsburg_soccerpark, R.drawable.augsburg_soccerpark_small,
                R.string.football_golf_link, new double[]{48.470423, 10.895744700000023}));
        sightsList.add(new Places(R.string.titania, R.string.neusaess, R.string.titania_description,
                R.drawable.augsburg_titania, R.drawable.augsburg_titania_small
                , R.string.titania_link, new double[]{48.4012214, 10.824618099999952}));
        sightsList.add(new Places(R.string.boulder_soccer_gersthofen, R.string.gersthofen, R.string.boulder_soccer_gersthofen_description,
                R.drawable.augsburg_default, R.drawable.augsburg_default_small
                , R.string.boulder_soccer_gersthofen_link, new double[]{48.43792029999999, 10.872801500000037}));

        GridView sightsListView = rootView.findViewById(R.id.listview);
        PlacesAdapter placesAdapter = new PlacesAdapter(getContext(), sightsList);
        sightsListView.setAdapter(placesAdapter);

        sightsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntent = new Intent(getContext(), DetailsActivity.class);
                detailIntent.putExtra("currentPlace", sightsList.get(i));
                startActivity(detailIntent);
            }
        });

        return rootView;
    }

}
