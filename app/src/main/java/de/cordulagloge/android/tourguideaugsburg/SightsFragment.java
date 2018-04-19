package de.cordulagloge.android.tourguideaugsburg;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.xml.datatype.Duration;



/**
 * A simple {@link Fragment} subclass.
 */
public class SightsFragment extends Fragment {

    ArrayList<Places> sightsList;

    public SightsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_places, container, false);

        sightsList = new ArrayList<Places>();
        sightsList.add(new Places(R.string.city_hall, R.string.inner_city, R.string.city_hall_description,
                R.drawable.augsburg_town_hall, R.string.city_hall_link));
        sightsList.add(new Places(R.string.perlach_tower, R.string.inner_city, R.string.perlach_tower_description,
                R.drawable.augsburg_perlachtower, R.string.perlach_tower_link));
        sightsList.add(new Places(R.string.magnificent_fountains, R.string.inner_city, R.string.magnificent_fountains_description,
                R.drawable.augsburg_fountain, R.string.magnificent_fountains_link));
        sightsList.add(new Places(R.string.cathedral, R.string.inner_city, R.string.cathedral_description,
                R.drawable.augsburg_dom, R.string.cathedral_link));
        sightsList.add(new Places(R.string.mozart_house, R.string.inner_city, R.string.mozart_house_description,
                R.drawable.augsburg_mozarthaus, R.string.mozart_house_link));
        sightsList.add(new Places(R.string.ana_church, R.string.inner_city, R.string.ana_church_description,
                R.drawable.augsburg_st_anna, R.string.ana_church_link));
        sightsList.add(new Places(R.string.synagogue, R.string.inner_city, R.string.synagogue_description,
                R.drawable.augsburg_synagogue, R.string.synagogue_link));
        sightsList.add(new Places(R.string.fugger_palace, R.string.inner_city, R.string.fugger_palace_description,
                R.drawable.augsburg_fugger_palace, R.string.fugger_palace_link));
        sightsList.add(new Places(R.string.stadtmetzg, R.string.inner_city, R.string.stadtmetzg_description,
                R.drawable.augsburg_stadtmetzg, R.string.stadtmetzg_link));
        sightsList.add(new Places(R.string.schaezler_palace, R.string.inner_city, R.string.schaezler_palace_description,
                R.drawable.augsburg_schaezler_palace, R.string.schaezler_palace_link));
        sightsList.add(new Places(R.string.ulrichs_churches, R.string.inner_city, R.string.ulrichs_churches_description,
                R.drawable.augsburg_ulrich, R.string.ulrichs_churches_link));
        sightsList.add(new Places(R.string.fuggerei, R.string.inner_city, R.string.fuggerei_description,
                R.drawable.augsburg_fuggerei, R.string.fuggerei_link));
        sightsList.add(new Places(R.string.brecht_house, R.string.inner_city, R.string.brecht_house_description,
                R.drawable.augsburg_brecht_house, R.string.brecht_house_link));

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
