package de.cordulagloge.android.tourguideaugsburg;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SightsFragment extends Fragment {

    private ArrayList<Places> sightsList;

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_places, container, false);

        sightsList = new ArrayList<>();
        sightsList.add(new Places(R.string.city_hall, R.string.inner_city, R.string.city_hall_description,
                R.drawable.augsburg_town_hall, R.drawable.augsburg_town_hall_small
                , R.string.city_hall_link,new double[]{48.36874299999999, 10.898718199999962}));
        sightsList.add(new Places(R.string.perlach_tower, R.string.inner_city, R.string.perlach_tower_description,
                R.drawable.augsburg_perlachtower, R.drawable.augsburg_perlachtower_small
                , R.string.perlach_tower_link,new double[]{48.3691815, 10.898438899999974 }));
        sightsList.add(new Places(R.string.magnificent_fountains, R.string.inner_city, R.string.magnificent_fountains_description,
                R.drawable.augsburg_fountain, R.drawable.augsburg_fountain_small
                , R.string.magnificent_fountains_link,new double[]{48.3690498, 10.897926900000016}));
        sightsList.add(new Places(R.string.cathedral, R.string.inner_city, R.string.cathedral_description,
                R.drawable.augsburg_dom, R.drawable.augsburg_dom_small
                , R.string.cathedral_link,new double[]{48.3727151, 10.896404399999938}));
        sightsList.add(new Places(R.string.mozart_house, R.string.inner_city, R.string.mozart_house_description,
                R.drawable.augsburg_mozarthaus, R.drawable.augsburg_mozarthaus_small
                , R.string.mozart_house_link,new double[]{48.3755645, 10.895653100000004}));
        sightsList.add(new Places(R.string.ana_church, R.string.inner_city, R.string.ana_church_description,
                R.drawable.augsburg_st_anna, R.drawable.augsburg_st_anna_small
                , R.string.ana_church_link,new double[]{48.3677877, 10.89528150000001}));
        sightsList.add(new Places(R.string.synagogue, R.string.inner_city, R.string.synagogue_description,
                R.drawable.augsburg_synagogue, R.drawable.augsburg_synagogue_small
                , R.string.synagogue_link,new double[]{48.3655278, 10.891961700000024}));
        sightsList.add(new Places(R.string.fugger_palace, R.string.inner_city, R.string.fugger_palace_description,
                R.drawable.augsburg_fugger_palace, R.drawable.augsburg_fugger_palace_small
                , R.string.fugger_palace_link,new double[]{48.3661626, 10.898723300000029}));
        sightsList.add(new Places(R.string.stadtmetzg, R.string.inner_city, R.string.stadtmetzg_description,
                R.drawable.augsburg_stadtmetzg, R.drawable.augsburg_stadtmetzg_small
                , R.string.stadtmetzg_link,new double[]{48.369643, 10.89947989999996}));
        sightsList.add(new Places(R.string.schaezler_palace, R.string.inner_city, R.string.schaezler_palace_description,
                R.drawable.augsburg_schaezler_palace, R.drawable.augsburg_schaezler_palace_small
                , R.string.schaezler_palace_link,new double[]{48.36499999999999, 10.899289899999985}));
        sightsList.add(new Places(R.string.ulrichs_churches, R.string.inner_city, R.string.ulrichs_churches_description,
                R.drawable.augsburg_ulrich, R.drawable.augsburg_ulrich_small
                , R.string.ulrichs_churches_link,new double[]{48.36194219999999, 10.900073700000007}));
        sightsList.add(new Places(R.string.fuggerei, R.string.inner_city, R.string.fuggerei_description,
                R.drawable.augsburg_fuggerei, R.drawable.augsburg_fuggerei_small
                , R.string.fuggerei_link,new double[]{48.3697155, 10.90388699999994}));
        sightsList.add(new Places(R.string.brecht_house, R.string.inner_city, R.string.brecht_house_description,
                R.drawable.augsburg_brecht_house, R.drawable.augsburg_brecht_house_small
                , R.string.brecht_house_link,new double[]{48.36998759999999, 10.900059599999963}));

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
